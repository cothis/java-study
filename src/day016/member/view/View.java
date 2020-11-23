package day016.member.view;

import day016.member.domain.Member;
import day016.member.repository.MemberRepository;
import day016.member.repository.MemoryMemberRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {
    private final MemberRepository memberRepository;
    private final Scanner sc = new Scanner(System.in);

    public View(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member createMember() {
        Member member = new Member();

        System.out.print("번호 : ");
        member.setNumber(sc.nextInt());

        System.out.print("이름 : ");
        member.setName(sc.next());

        System.out.print("나이 : ");
        member.setAge(sc.nextInt());

        return member;
    }

    public Member SearchMember() {
        System.out.print("회원 번호를 입력해주세요 : ");
        int number = sc.nextInt();
        return memberRepository.findById(number);
    }

    public void updateMember() {
        System.out.print("회원 번호를 입력해주세요 : ");
        int number = sc.nextInt();
        int index = memberRepository.findIndexById(number);

        Member member = new Member();
        member.setNumber(number);

        System.out.print("이름 : ");
        member.setName(sc.next());

        System.out.print("나이 : ");
        member.setAge(sc.nextInt());

        memberRepository.update(index, member);
    }

    public List<Member> getGreaterMembers(int targetAge) {
        List<Member> list = memberRepository.getList();
        List<Member> result = new ArrayList<>();
        for (Member member : list) {
            if (member.getAge() >= targetAge) {
                result.add(member);
            }
        }

        return result;
    }

    public void printAll() {
        List<Member> list = memberRepository.getList();

        System.out.println("전체 멤버 리스트");
        for (Member member : list) {
            System.out.println(member);
        }
        System.out.println();
    }

    public void index() {
        while(true) {
            printAll();
            System.out.println("1.추가, 2.삭제, 3.수정, 4.18세이상 멤버 5.종료");
            int select = sc.nextInt();
            switch (select) {
                case 1: {
                    System.out.println("회원 추가 화면입니다.");
                    Member member = createMember();
                    memberRepository.add(member);
                    break;
                }
                case 2: {
                    System.out.println("회원 삭제 화면입니다.");
                    Member member = SearchMember();
                    memberRepository.remove(member);
                    break;
                }
                case 3: {
                    System.out.println("회원 수정 화면입니다.");
                    updateMember();
                    break;
                }
                case 4: {
                    System.out.println("18세 이상 멤버 리스트입니다.");
                    List<Member> greaterMembers = getGreaterMembers(18);
                    for (Member member : greaterMembers) {
                        System.out.println(member);
                    }
                }
                default: {
                    break;
                }
            }
            if (select == 5) {
                break;
            }
        }
    }
}
