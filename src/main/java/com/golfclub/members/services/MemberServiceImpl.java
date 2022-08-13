package com.golfclub.members.services;

import com.golfclub.members.models.Member;
import com.golfclub.members.controllers.MembersListData;
import com.golfclub.members.repository.MemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MemberServiceImpl.class);

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public MembersListData getMembers() {
        MembersListData members = new MembersListData();
        memberRepository.findAll()
                .forEach(members.getMembers()::add);

        return members;
    }

    @Override
    public Optional<Member> getMemberById(String memberId) {
        Member member = null;

        /* simulated network delay */
        try {
            member = memberRepository.getById(memberId);
            Thread.sleep((long)(Math.random() * 2000));
        } catch (Exception e) {
            LOGGER.error("message=Exception in getMemberById; exception={}", e.toString());
            return Optional.empty();
        }
        return Optional.of(member);
    }

    @Override
    public Optional<Collection<Member>> getMemberByCountry(String country) {
        try {
            Collection<Member> members = memberRepository.findByCountry(country);
            return Optional.of(members);
        } catch (Exception e) {
            LOGGER.error("message=Exception in getMembersByCountry; exception={}", e.toString());
            return Optional.empty();
        }
    }

    @Override
    public Member createMember(Member member) {
        try {
            Member saved = memberRepository.save(member);
            return saved;
        } catch (Exception e) {
            LOGGER.error("message=Exception in createMember; exception={}", e.toString());
            return member; // todp: this is so right
        }

    }

    @Override
    public Member updateMember(Member member, String memberId) {
        try {
            Member saved = memberRepository.save(member);
            return saved;
        } catch (Exception e) {
            LOGGER.error("message=Exception in createMember; exception={}", e.toString());
            return member; // todo: this is not right yet
        }

    }

    @Override
    public void deleteMember(String memberId) {
        try {
            Optional<Member> dbMember = this.getMemberById(memberId);
            if( dbMember.isPresent() )
               memberRepository.delete(dbMember.get());
        } catch (Exception e) {
            LOGGER.error("message=Exception in createMember; exception={}", e.toString());
        }

    }

}
