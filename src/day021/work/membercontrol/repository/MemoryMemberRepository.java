package day021.work.membercontrol.repository;

import day021.work.membercontrol.dto.Member;
import day021.work.membercontrol.view.main.panel.MemberListModel;
import day021.work.membercontrol.view.main.panel.MemberTableModel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Integer, Member> store;
    private Integer sequence;
    private MemberTableModel memberTableModel;
    private DefaultListModel<Member> dlm;

    public MemoryMemberRepository() {
        store = new HashMap<>();
        sequence = 0;
    }

    public MemoryMemberRepository(List<Member> list) {
        this();
        for (Member member : list) {
            this.addMember(member);
        }
        if (list.size() > 0) {
            sequence = list.get(list.size()-1).getId();
        }
    }

    public void setMemberTableModel(MemberTableModel dm) {
        this.memberTableModel = dm;
    }

    public void setListModel(DefaultListModel<Member> list) {
        this.dlm = list;
    }

    @Override
    public void addMember(Member member) {
        member.setId(++sequence);
        store.put(sequence, member);
        if(memberTableModel != null) {
            memberTableModel.addRow(member);
        }
        if (dlm != null) {
            dlm.addElement(member);
        }
    }

    @Override
    public void removeMember(Integer memberId) {
        Member remove = store.remove(memberId);
        if(memberTableModel != null) {
            memberTableModel.removeRow(remove);
        }
        if (dlm != null) {
            dlm.removeElement(remove);
        }
    }

    @Override
    public Member findById(Integer memberId) {
        return store.get(memberId);
    }

    @Override
    public Member findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny()
                .get();
    }

    @Override
    public void updateMember(Member present, Member member) {
        member.setId(present.getId());
        store.replace(present.getId(), member);

        dlm.setElementAt(member, member.getId()-1);
        memberTableModel.replace(present, member);

    }

    @Override
    public List<Member> findAllMember() {
        return new ArrayList<>(store.values());
    }
}
