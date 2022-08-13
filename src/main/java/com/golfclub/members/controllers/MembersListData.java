package com.golfclub.members.controllers;

import com.golfclub.members.models.Member;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class MembersListData implements Serializable {
    private List<Member> members;

    public MembersListData() {
        this.members = new ArrayList<>();
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
