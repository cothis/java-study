package day021.work.membercontrol.view;

import day021.work.membercontrol.MemberControl;
import day021.work.membercontrol.dto.Member;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class SearchPanel extends JPanel {

    JComboBox<String> choice;
    JTextField textField;
    JButton button;

    JList<Member> list;

    List<String> getNames() {
        List<Member> allMember = MemberControl.getMemberRepository().findAllMember();
        return allMember.stream().map(Member::getName).collect(Collectors.toList());
    }

    public SearchPanel(JFrame jFrame) {
        setLayout(null);
        setSize(260, 660);
        setLocation(5, 65);
        setBackground(Color.GRAY);

        String[] choiceItems = {"이름", "타입"};
        choice = new JComboBox<>(choiceItems);
        choice.setBounds(5,5,60,24);
        choice.setFont(this.getFont());
        add(choice);

        textField = new JTextField();
        textField.setBounds(70,5,120,24);
        textField.setFont(this.getFont());
        add(textField);

        button = new JButton("검색");
        button.setBounds(195, 5, 60, 24);
        button.setFont(this.getFont());
        add(button);


        DefaultListModel<Member> dlms = new DefaultListModel<>();
        for (Member member : MemberControl.getMemberRepository().findAllMember()) {
            dlms.addElement(member);
        }

        list = new JList<>();
        list.setModel(dlms);

        list.setFont(this.getFont());
        JScrollPane jScrollPane = new JScrollPane(list);
        jScrollPane.setSize(250, 620);
        jScrollPane.setLocation(5, 35);

        add(jScrollPane);

    }
}
