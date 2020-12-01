package day021.work.membercontrol.view.main.panel;

import day021.work.membercontrol.MemberControl;
import day021.work.membercontrol.dto.Batter;
import day021.work.membercontrol.dto.Member;
import day021.work.membercontrol.dto.Pitcher;
import day021.work.membercontrol.repository.MemoryMemberRepository;
import day021.work.membercontrol.view.InsertDialog;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.stream.Collectors;

public class ContentPanelImpl extends ContentPanel{

    JTable jTable;

    JRadioButton type_all;
    JRadioButton type_pitcher;
    JRadioButton type_batter;

    MemberTableModel dm;


    public void checkButton(ActionEvent e) {
        JRadioButton source = (JRadioButton) e.getSource();

        showTable(source.getText());
    }

    public void showTable(String type) {
        String[] header = null;
        List<Member> members = null;
        switch (type) {
            case "모두":
                // 테이블에 모든 리스트 출력
                header = new String[]{"번호", "이름", "나이", "키"};
                members = MemberControl.getMemberRepository().findAllMember();

                break;
            case "투수":
                // 테이블에 투수만 출력
                header = new String[]{"번호", "이름", "나이", "키", "승리 횟수", "패배 횟수", "방어율"};
                members = MemberControl.getMemberRepository().findAllMember()
                        .stream().filter(member -> member instanceof Pitcher)
                        .collect(Collectors.toList());

                break;
            case "타자":
                // 테이블에 타자만 출력
                header = new String[]{"번호", "이름", "나이", "키", "타수", "안타수", "타율"};
                members = MemberControl.getMemberRepository().findAllMember()
                        .stream().filter(member -> member instanceof Batter)
                        .collect(Collectors.toList());

                break;
        }
        dm = new MemberTableModel(members, header, this);
        ((MemoryMemberRepository)MemberControl.getMemberRepository()).setMemberTableModel(dm);
        jTable.setModel(dm);
        dm.redraw();
    }

    public ContentPanelImpl(JFrame jFrame) {
        setGeometry();
        this.setFont(new Font("돋움", Font.PLAIN, 15));

        ButtonGroup radio = new ButtonGroup();

        type_all = new JRadioButton("모두", true);
        type_all.setFont(this.getFont());
        type_all.setBounds(5,5,55,25);
        type_all.setOpaque(false);
        type_all.addActionListener(this::checkButton);
        radio.add(type_all);
        add(type_all);

        type_pitcher = new JRadioButton("투수", false);
        type_pitcher.setFont(this.getFont());
        type_pitcher.setBounds(60,5,55,25);
        type_pitcher.setOpaque(false);
        type_pitcher.addActionListener(this::checkButton);
        radio.add(type_pitcher);
        add(type_pitcher);

        type_batter = new JRadioButton("타자", false);
        type_batter.setFont(this.getFont());
        type_batter.setBounds(115,5,55,25);
        type_batter.setOpaque(false);
        type_batter.addActionListener(this::checkButton);
        radio.add(type_batter);
        add(type_batter);

        jTable = new JTable(null);
        jTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point point = e.getPoint();
                int row = jTable.rowAtPoint(point);
                if (e.getClickCount() == 2 && jTable.getSelectedRow() != -1) {
                    Member rowItem = dm.getRowItem(row);
                    new InsertDialog(jFrame, rowItem);

                }
            }
        });
        showTable("모두");



        JScrollPane jScrollPane = new JScrollPane(jTable);
        jScrollPane.setBounds(5, 35, this.getWidth() - 10, this.getHeight() - 40);
        add(jScrollPane);
    }
}
