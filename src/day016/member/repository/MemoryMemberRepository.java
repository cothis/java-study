package day016.member.repository;

import day016.member.domain.Member;

import java.util.ArrayList;
import java.util.List;

public class MemoryMemberRepository implements MemberRepository{
    List<Member> list = new ArrayList<>();

    public MemoryMemberRepository() {
        list.add(new Member(1, "홍길동", 17));
        list.add(new Member(2, "일지매", 18));
        list.add(new Member(3, "김개똥", 23));
    }

    public void add(Member member) {
        list.add(member);
    }

    public Member remove(int index) {
        return list.remove(index);
    }

    public Member remove(Member member) {
        list.remove(member);
        return member;
    }

    public void update(int index, Member member) {
        list.set(index, member);
    }

    public Member findById(int number) {
        for (Member member : list) {
            if (number == member.getNumber()) {
                return member;
            }
        }
        return null;
    }

    public int findIndexById(int id) {
        for (int i = 0 ; i < list.size() ; i++) {
            if(id == list.get(i).getNumber()) {
                return i;
            }
        }
        return -1;
    }

    public List<Member> getList() {
        return list;
    }

    // 추가, 삭제, 수정

    // 검색
    // 이름
    // 나이 18세 이상 멤버
}
