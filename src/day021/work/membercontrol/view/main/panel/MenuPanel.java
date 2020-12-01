package day021.work.membercontrol.view.main.panel;

import day021.work.membercontrol.MemberControl;
import day021.work.membercontrol.dto.Member;
import day021.work.membercontrol.file.FileController;
import day021.work.membercontrol.view.InsertDialog;
import day021.work.membercontrol.view.main.MainView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MenuPanel extends JPanel {

    JButton addBtn, removeBtn, saveBtn;
    JFrame parent;

    public MenuPanel(JFrame jFrame) {
        setLayout(null);
        this.parent = jFrame;

        setBackground(Color.GRAY);
        setSize(1024, 60);

        addBtn = new JButton("추가");
        addBtn.setBounds(15, 15, 70, 30);
        addBtn.setFont(this.getFont());
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InsertDialog(jFrame, null);
            }
        });
        add(addBtn);

        removeBtn = new JButton("삭제");
        removeBtn.setBounds(100, 15, 70, 30);
        removeBtn.setFont(this.getFont());
        removeBtn.addActionListener(this::removeMember);
        add(removeBtn);

        saveBtn = new JButton("저장");
        saveBtn.setBounds(939, 15, 70, 30);
        saveBtn.setFont(this.getFont());
        saveBtn.addActionListener(this::saveMembers);
        add(saveBtn);

    }
    public void removeMember(ActionEvent e) {
        ((MainView)parent).getSearchPanel().removeSelectedItem();
    }

    public void saveMembers(ActionEvent e) {
        System.out.println("save logic");
        List<Member> allMember = MemberControl.getMemberRepository().findAllMember();

        FileController fc = new FileController();
        fc.saveMembers(allMember);

        JOptionPane.showMessageDialog(null, "저장되었습니다.");
    }

}
