package day018.baseball_singleton;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.Scanner;

public class SelectView {
    public SelectView() {}
    public Optional<Member> searchList() {
        Scanner sc = ScannerSingle.getScanner();
        Optional<Member> result = Optional.empty();

        System.out.println("1.아이디검색 2.이름검색");
        int select = sc.nextInt();

        if(select == 1) {
            System.out.print("아이디: ");
            result = Repository.getInstance().findById(sc.nextInt());
        }
        else if (select == 2) {
            System.out.print("이름 : ");
            result = Repository.getInstance().findByName(sc.next());
        }
        return result;
    }
}
