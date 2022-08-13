package com.golfclub.members.controllers;

import com.golfclub.members.models.Member;
import com.golfclub.members.services.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import static java.util.stream.Collectors.toCollection;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "v1/members", produces = { MediaType.APPLICATION_JSON_VALUE })
@Tag(name = "members")
public class MemberController {

    @Resource
    private MemberService memberService;

    @RequestMapping(method = RequestMethod.GET)
    @Operation(description = "Get all the members", summary = "Get all the members")
    public ResponseEntity<MembersListData> getMembers() {
        MembersListData members = memberService.getMembers();
        return ok(members);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<MemberData> getMemberById(@PathVariable("id") String id) {
        Optional<Member> member = memberService.getMemberById(id);

        if (member.isPresent()) {
            return new ResponseEntity<>(new MemberData(member.get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/country/{country}")
    public ResponseEntity<MembersListData> getMembersByCountry(@PathVariable("country") String country) {
        Optional<Collection<Member>> members = memberService.getMemberByCountry(country);

        if (members.isPresent()) {
            MembersListData membersObj = new MembersListData();
            ArrayList<Member> newList = members.get().stream().collect(toCollection(ArrayList::new));
            membersObj.setMembers(newList);
            return new ResponseEntity<>(membersObj , HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    @Operation(description = "Create a new member by input", summary = "Create a new member")
    public ResponseEntity<MemberData> createMember(@RequestBody MemberData memberData) {

        Member member = memberService.createMember(new Member(memberData));
        return ok(memberData);
    }


    @RequestMapping(method = RequestMethod.PUT)
    @Operation(description = "Update an existing member by input", summary = "Update an existing member")
    public ResponseEntity<MemberData> updateMember(@RequestBody MemberData memberData) {

        Member member = memberService.updateMember(new Member(memberData), memberData.getMemberId());
        return ok(memberData);
    }


}
