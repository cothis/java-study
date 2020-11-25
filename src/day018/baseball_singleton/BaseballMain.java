package day018.baseball_singleton;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class BaseballMain {
    public void start() {
        FileController.getInstance().loadData();
        while(true) {
            System.out.println("1.Insert 2.Delete 3.Update 4.Select 5.printAll 6.saveData 7.Exit");
            int select = ScannerSingle.getScanner().nextInt();
            if(select == 1) {
                new InsertView();
            }
            else if(select == 2) {
                new DeleteView();
            }
            else if(select == 3) {
                new UpdateView();
            }
            else if(select == 4) {
                SelectView selectView = new SelectView();
                Optional<Member> member = selectView.searchList();
                if (member.isPresent()) {
                    System.out.println(member.get());
                } else {
                    System.out.println("해당 회원이 없습니다.");
                }


            }
            else if(select == 5) {
                System.out.println("전체 회원 조회");
                List<Member> all = Repository.getInstance().findAll();
                for (Member m : all) {
                    System.out.println(m);
                }
            }
            else if(select == 6) {
                FileController.getInstance().saveData();
            }
            else if(select == 7) {
                System.out.println("Thanks you.");
                break;
            }
            else {
                System.out.println("메뉴의 숫자값을 입력해주세요.");
            }
        }
    }

    public static void main(String[] args) {
        BaseballMain bb = new BaseballMain();
        bb.start();
    }
}
