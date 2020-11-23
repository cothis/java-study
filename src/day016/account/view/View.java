package day016.account.view;

import day016.account.domain.Member;

import java.util.List;
import java.util.Scanner;

public class View {
    Scanner sc = new Scanner(System.in);

    private int getInteger(String message) {
        int inputNumber = 0;
        while(true) {
            try {
                System.out.println(message);
                System.out.print("> ");
                inputNumber = sc.nextInt();
                break;
            } catch (Exception e){
                System.out.println("잘못입력하셨습니다.");
                sc.nextLine();
            }
        }
        return inputNumber;
    }

    public int menu() {
        return getInteger("1.회원추가 2.회원목록 3.종료");
    }

    public Member getNewUser() {
        System.out.println("이름을 입력해주세요");
        System.out.print("> ");
        String name = sc.next();
        Member member = new Member();
        member.setName(name);
        return member;
    }

    public void printMembers(List<Member> members) {
        for (Member member : members) {
            System.out.println(member);
        }
    }
}
