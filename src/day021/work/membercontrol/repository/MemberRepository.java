package day021.work.membercontrol.repository;

import day021.work.membercontrol.dto.Member;

import java.util.List;

public interface MemberRepository {
    void addMember(Member member);
    void removeMember(Integer memberId);
    Member findById(Integer memberId);
    Member findByName(String name);
    void updateMember(Integer memberId, Member member);
    List<Member> findAllMember() ;
}
