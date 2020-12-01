package day021.work.membercontrol.view.main.panel;

import day021.work.membercontrol.MemberControl;
import day021.work.membercontrol.dto.Batter;
import day021.work.membercontrol.dto.Member;
import day021.work.membercontrol.dto.Pitcher;
import day021.work.membercontrol.repository.MemberRepository;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MemberTableModel extends AbstractTableModel {

    //private final MemberRepository memberRepository = MemberControl.getMemberRepository();

    private final List<Member> members;
    private final String[] header;
    private final JPanel panel;

    public MemberTableModel(List<Member> members, String[] header, JPanel panel) {
        this.members = new ArrayList<>(members);
        this.header = header;
        this.panel = panel;
    }

    public void redraw() {
        JTable jTable = ((ContentPanelImpl) panel).jTable;
        jTable.revalidate();
        jTable.repaint();

        //Table 내용 가운데 정렬
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        TableColumnModel columnModel = jTable.getColumnModel();
        for (int i = 0; i < jTable.getColumnCount(); i++) {
            columnModel.getColumn(i).setCellRenderer(cellRenderer);
        }

    }

    public void replace(Member prev, Member newMember) {
        int i = members.indexOf(prev);
        members.set(i, newMember);
        redraw();

    }

    public void addRow(Member member) {
        members.add(member);
        redraw();
    }

    public void removeRow(Member member) {
        members.remove(member);
        redraw();
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }

    @Override
    public int getRowCount() {
        return members.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    public Member getRowItem(int rowIndex) {
        return members.get(rowIndex);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object value = null;
        Member member = members.get(rowIndex);

        switch(columnIndex) {
            case 0:
                value = member.getId();
                break;
            case 1:
                value = member.getName();
                break;
            case 2:
                value = member.getAge();
                break;
            case 3:
                value = member.getHeight();
                break;
        }

        if(member instanceof Pitcher) {
            Pitcher p = (Pitcher) member;
            switch (columnIndex) {
                case 4:
                    value = p.getWin();
                    break;
                case 5:
                    value = p.getLose();
                    break;
                case 6:
                    value = p.getDefence();
                    break;
            }
        }
        else {
            if(member instanceof Batter) {
                Batter b = (Batter) member;
                switch (columnIndex) {
                    case 4:
                        value = b.getHitCount();
                        break;
                    case 5:
                        value = b.getHits();
                        break;
                    case 6:
                        value = b.getHitRate();
                        break;
                }
            }
        }

        return value;
    }
}
