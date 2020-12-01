package day021.work.membercontrol.view.main.panel;

import day021.work.membercontrol.MemberControl;
import day021.work.membercontrol.dto.Batter;
import day021.work.membercontrol.dto.Member;
import day021.work.membercontrol.dto.Pitcher;
import day021.work.membercontrol.repository.MemoryMemberRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.stream.Collectors;

public class SearchPanel extends JPanel {

    JComboBox<String> choice;
    JTextField textField;
    JButton button;

    JComboBox<String> type;

    JList<Member> list;
    DefaultListModel<Member> dlms;
//    MemberListModel dlms;

    List<String> getNames() {
        List<Member> allMember = MemberControl.getMemberRepository().findAllMember();
        return allMember.stream().map(Member::getName).collect(Collectors.toList());
    }

    public SearchPanel(JFrame jFrame) {
        setLayout(null);
        setSize(260, 660);
        setLocation(5, 65);
        setBackground(Color.GRAY);

        dlms = new DefaultListModel<>();
//        dlms = new MemberListModel();
        ((MemoryMemberRepository)MemberControl.getMemberRepository()).setListModel(dlms);

        String[] choiceItems = {"이름", "타입"};
        choice = new JComboBox<>(choiceItems);
        choice.setBounds(5,5,60,24);
        choice.setFont(this.getFont());
        choice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedItem = (String) choice.getSelectedItem();
                if (selectedItem == null) return;

                if (selectedItem.equals("이름")) {
                    textField.setVisible(true);
                    type.setVisible(false);
                }
                else {
                    textField.setVisible(false);
                    type.setVisible(true);
                }
            }
        });
        add(choice);

        textField = new JTextField();
        textField.setBounds(70,5,120,24);
        textField.setFont(this.getFont());
        textField.setVisible(true);
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10) { // enter
                    searchItems(null);
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {}
        });
        add(textField);

        type = new JComboBox<>(new String[]{"투수", "타자"});
        type.setBounds(70, 5, 120, 24);
        type.setFont(this.getFont());
        type.setVisible(false);
        add(type);


        button = new JButton("검색");
        button.setBounds(195, 5, 60, 24);
        button.setFont(this.getFont());
        button.addActionListener(this::searchItems);
        add(button);

        list = new JList<>();
        list.setFont(this.getFont());
        updateList("");

        JScrollPane jScrollPane = new JScrollPane(list);
        jScrollPane.setSize(250, 620);
        jScrollPane.setLocation(5, 35);

        add(jScrollPane);
    }

    public void addList(Member member) {
        dlms.addElement(member);
    }

    public void updateList(String str) {
        dlms.removeAllElements();

        for (Member member : MemberControl.getMemberRepository().findAllMember()) {
            if (member.getName().contains(str)) {
                dlms.addElement(member);
            }
        }
        list.setModel(dlms);
    }

    public void removeSelectedItem() {
        if (list.isSelectionEmpty()) {
            return;
        }
        List<Member> selectedValuesList = list.getSelectedValuesList();

        for (Member member : selectedValuesList) {
            MemberControl.getMemberRepository().removeMember(member.getId());
        }
    }

    public void searchItems(ActionEvent e) {
        String selectedItem = (String) choice.getSelectedItem();
        if (selectedItem.equals("이름")) {
            updateList(textField.getText());
        } else if (selectedItem.equals("타입")) {
            dlms.removeAllElements();
            String str = (String) type.getSelectedItem();
            System.out.println(str);

            for (Member member : MemberControl.getMemberRepository().findAllMember()) {
                if (member instanceof Batter && str.equals("타자")) {
                    dlms.addElement(member);
                } else if (member instanceof Pitcher && str.equals("투수")) {
                    dlms.addElement(member);
                }
            }
            list.setModel(dlms);
        }
    }
}
