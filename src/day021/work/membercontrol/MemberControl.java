package day021.work.membercontrol;

import day021.work.membercontrol.dto.Member;
import day021.work.membercontrol.repository.MemberRepository;
import day021.work.membercontrol.repository.MemoryMemberRepository;
import day021.work.membercontrol.view.MainView;

public class MemberControl {

    private static final MemberRepository memberRepository = new MemoryMemberRepository();

    public static void main(String[] args) {
        Member member = new Member("홍길동", 19, 192.3);
        Member member1 = new Member("김개똥", 11, 132.3);
        Member member2 = new Member("강타자", 12, 144.3);
        Member member3 = new Member("약투수", 23, 164.3);
        memberRepository.addMember(member);
        memberRepository.addMember(member1);
        memberRepository.addMember(member2);
        memberRepository.addMember(member3);
        new MainView();
    }

    public static MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
