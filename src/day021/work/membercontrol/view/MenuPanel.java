package day021.work.membercontrol.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MenuPanel extends JPanel {

    JButton addBtn, removeBtn, saveBtn;

    public MenuPanel(JFrame jFrame) {
        setLayout(null);

        setBackground(Color.GRAY);
        setSize(1024, 60);

        addBtn = new JButton("추가");
        addBtn.setBounds(15, 15, 70, 30);
        addBtn.setFont(this.getFont());
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InsertForm();
            }
        });
        add(addBtn);

        removeBtn = new JButton("삭제");
        removeBtn.setBounds(100, 15, 70, 30);
        removeBtn.setFont(this.getFont());
        add(removeBtn);

        saveBtn = new JButton("저장");
        saveBtn.setBounds(939, 15, 70, 30);
        saveBtn.setFont(this.getFont());
        add(saveBtn);

    }
}
