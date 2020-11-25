package day018.baseball_singleton;

import java.util.Optional;

public class DeleteView {
    public DeleteView() {
        System.out.println("회원 삭제 화면입니다.");
        SelectView selectView = new SelectView();

        Optional<Member> member = selectView.searchList();

        member.ifPresent(m -> Repository.getInstance().remove(m));

    }
}
