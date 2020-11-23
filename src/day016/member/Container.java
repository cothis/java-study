package day016.member;

import day016.member.repository.MemberRepository;
import day016.member.repository.MemoryMemberRepository;
import day016.member.view.View;

public class Container {
    MemberRepository memberRepository = new MemoryMemberRepository();
    View view = new View(memberRepository);

    public Container() {
        view.index();
    }
}
