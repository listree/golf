package com.golfclub.members.repository;

import com.golfclub.members.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, String> {

    /**
     * Finds the list of member by Country
     * @param country
     * @return  A list of members whose country is an exact match with the given input.
     *          If no persons is found, this method returns an empty list.
     */
    @Query(name = "SELECT p FROM MEMBERS p WHERE LOWER(p.country) = LOWER(:country)")
    public List<Member> findByCountry(@Param("country") String country);
}