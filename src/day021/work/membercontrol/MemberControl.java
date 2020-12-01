package day021.work.membercontrol;

import day021.work.membercontrol.dto.Batter;
import day021.work.membercontrol.dto.Member;
import day021.work.membercontrol.dto.Pitcher;
import day021.work.membercontrol.file.FileController;
import day021.work.membercontrol.repository.MemberRepository;
import day021.work.membercontrol.repository.MemoryMemberRepository;
import day021.work.membercontrol.view.main.MainView;

import java.util.List;

public class MemberControl {

    private static MemberRepository memberRepository;

    public static void main(String[] args) {
        // test data
//        Member member = new Batter("홍길동", 19, 192.3, 30, 20, 1.3);
//        Member member1 = new Batter("김개똥", 23, 182.3, 20, 22, 12.3);
//        Member member2 = new Batter("강타자", 11, 172.3, 90, 26, 1.13);
//        Member member3 = new Pitcher("강투수", 19, 162.3, 50, 89, 3.53);

        FileController fc = new FileController();
        List<Member> members = fc.loadDatas();
        memberRepository = new MemoryMemberRepository(members);
        new MainView();
    }

    public static MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
