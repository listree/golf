package com.golfclub.members.models;

import com.golfclub.members.controllers.MemberData;

import java.util.Random;
import javax.persistence.*;

@Entity
@Table(name="MEMBERS")
public class Member {

    @Id
    @Column(name = "MEMBERID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String memberId;

    @Column(name = "BIRTHDAY")
    private String birthDay;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "NAMEFIRST")
    private String firstName;

    @Column(name = "NAMELAST")
    private String lastName;

    @Column(name = "WEIGHT")
    private String weight;

    @Column(name = "HEIGHT")
    private String height;

    public Member() {}

    public Member(MemberData data) {
        memberId = "" + (new Random().nextInt());
        birthDay = data.getBirthDay();
        firstName = data.getFirstName();
        lastName = data.getLastName();
        country = data.getCountry();
        weight = data.getWeight();
        height = data.getHeight();
    }

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
