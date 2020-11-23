package day016.account.controller;

import day016.account.annotation.Component;
import day016.account.domain.Member;
import day016.account.service.Service;
import day016.account.view.View;

import java.util.List;

@Component
public class MemberController {
    private Service service;
    private View view;

    public MemberController(Service service, View view) {
        this.service = service;
        this.view = view;
    }

    public boolean index() {
        int menu = view.menu();
        if(menu == 1) {
            // 회원등록
            createUser();
        }
        else if (menu == 2) {
            // 회원목록
            printUserList();
        }
        else {
            // 종료
            return true;
        }
        return false;
    }

    public void createUser() {
        Member member = view.getNewUser();
        service.join(member);
    }

    private void printUserList() {
        List<Member> members = service.findMembers();
        view.printMembers(members);
    }

}
