package com.golfclub.members.services;

import com.golfclub.members.models.Member;
import com.golfclub.members.controllers.MembersListData;
import com.golfclub.members.services.exception.MemberNotFoundException;

import java.util.Collection;
import java.util.Optional;


/**
 * Provides service tier CRUD operations for {@code Members}.
 *
 * @author Summer Golfer
 *
 */
public interface MemberService {

    /**
     * Get all the {@code Member} known to this service.
     *
     * @return all {@code Member}s known to this service
     */
    public MembersListData getMembers();

    /**
     * Get the {@code Member} associated with {@code memberId}
     *
     * @param memberId
     *            identifier for requested {@code Member}
     * @return {@code Member} associated with {@code memberId}
     * @throws InterruptedException
     *             if no {@code Member} found for {@code memberId}
     */
    public Optional<Member> getMemberById(String memberId);

    /**
     * Get the {@code Member} associated with {@code memberId}
     *
     * @param country
     *            identifier for requested {@code Member}
     * @return all {@code Member} associated with {@code birthCountry}
     * @throws MemberNotFoundException
     *             if no {@code Member} found for {@code birthCOuntry}
     */
     public Optional<Collection<Member>> getMemberByCountry(String country);

    /**
     * Create a new {@code Member} with auto-generated ID. The
     *      * date and time modeled as UTC milliseconds.
     *
     * @param member
     *            {@code Member} to create
     * @throws MemberNotFoundException
     *
     * @return {@code Member} associated with {@code Member}
     */
    public Member createMember(Member member);

    /**
     * Updates {@code Member} to reflect input {@code member}.
     *
     * @param member
     *            specifies required {@code Member} state
     * @param memberId
     *            specifies the updating {@code Member}'s identifier
     * @return updated {@code Member}
     * @throws MemberConstraintViolationException
     *             if the following preconditions aren't satisfied:
     *             <ul>
     *             <li>{@code memberId} must not be null or empty</li>
     *             <li>if {@code member.id} is not null or empty, it must
     *             equal {@code memberId}</li>
     *             <li>{@code member} must not be null</li>
     *             </ul>
     * @throws MemberNotFoundException
     *             if no {@code Member} found for {@code memberId}
     */
    public Member updateMember(Member member, String memberId);

    /**
     * Delete {@code Member} associated with {@code memberId}
     *
     * @param memberId
     *            identifier for deleting {@code Member}
     * @throws MemberNotFoundException
     *             if {@code Member} associated with {@code memberId}
     *             doesn't exist
     */
    public void deleteMember(String memberId);
}
