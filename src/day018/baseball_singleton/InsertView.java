package day018.baseball_singleton;

import java.util.Scanner;

public class InsertView {
    public InsertView() {
        // 이름:string
        // 나이:int
        // 키:double
        Scanner sc = ScannerSingle.getScanner();
        Member member = new Member();

        System.out.println("회원 입력입니다.");

        System.out.println("이름: ");
        member.setName(sc.next());

        System.out.println("나이: ");
        member.setAge(sc.nextInt());

        System.out.println("키: ");
        member.setHeight(sc.nextDouble());

        Repository.getInstance().add(member);
    }
}
