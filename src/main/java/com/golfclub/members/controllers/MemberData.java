package com.golfclub.members.controllers;

import com.golfclub.members.models.Member;
import lombok.Data;

import java.io.Serializable;

@Data
public class MemberData implements Serializable {

    public MemberData() {
    }

    public MemberData(Member member) {
        memberId = member.getMemberId();
        birthDay = member.getBirthDay();
        firstName = member.getFirstName();
        lastName = member.getLastName();
        country = member.getCountry();
        weight = member.getWeight();
        height = member.getHeight();
    }

    private String memberId;
    private String birthDay;
    private String country;
    private String firstName;
    private String lastName;
    private String weight;
    private String height;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

}
