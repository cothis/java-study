package day021.work.membercontrol.view.main.panel;

import day021.work.membercontrol.MemberControl;
import day021.work.membercontrol.repository.MemberRepository;

import javax.swing.*;

public class MemberListModel extends AbstractListModel {

    private final MemberRepository memberRepository = MemberControl.getMemberRepository();

    @Override
    public int getSize() {
        return memberRepository.findAllMember().size();
    }

    @Override
    public Object getElementAt(int index) {
        return memberRepository.findById(index + 1).getName();
    }
}
