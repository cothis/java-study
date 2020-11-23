package day016.member.repository;

import day016.member.domain.Member;

import java.util.List;

public interface MemberRepository {
    void add(Member member);

    Member remove(int index);

    Member remove(Member member);

    void update(int index, Member member);

    Member findById(int number);

    int findIndexById(int id);

    List<Member> getList();
}
