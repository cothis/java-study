package day021.work.membercontrol.view;

import day021.work.membercontrol.MemberControl;
import day021.work.membercontrol.dto.Batter;
import day021.work.membercontrol.dto.Member;
import day021.work.membercontrol.dto.Pitcher;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertForm extends JFrame {

    JRadioButton pitcher, batter;
    JButton ok, cancel;

    JPanel inputForm;

    LabeledTextField name;
    LabeledTextField age;
    LabeledTextField height;
    LabeledTextField var1;
    LabeledTextField var2;
    LabeledTextField var3;


    public InsertForm() throws HeadlessException {
        setTitle("Insert Form");
        setLayout(null);

        setSize(300,440);
        setLocationRelativeTo(null);

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(null);
        titlePanel.setBounds(0, 0, this.getWidth(), 60);
        titlePanel.setBackground(Color.ORANGE);

        JLabel backgroundLabel = new JLabel();
        backgroundLabel.setText("INSERT Form");
        backgroundLabel.setFont(new Font("돋움", Font.BOLD, 25));
        backgroundLabel.setBounds(10, 15, 300, 30);
        titlePanel.add(backgroundLabel);

        add(titlePanel);

        JPanel bodyPanel = new JPanel();
        bodyPanel.setLayout(null);
        bodyPanel.setBounds(0, 60, this.getWidth(), this.getHeight() - 160);

        ButtonGroup buttonGroup = new ButtonGroup();

        pitcher = new JRadioButton("투수", true);
        pitcher.setBounds(20, 5, 60, 40);
        pitcher.setFont(this.getFont());
        pitcher.addActionListener(this::callChangeLabel);
        buttonGroup.add(pitcher);
        bodyPanel.add(pitcher);

        batter = new JRadioButton("타자", false);
        batter.setBounds(80, 5, 60, 40);
        batter.setFont(this.getFont());
        batter.addActionListener(this::callChangeLabel);
        buttonGroup.add(batter);
        bodyPanel.add(batter);
        add(bodyPanel);

        inputForm = new JPanel();
        inputForm.setLayout(null);
        inputForm.setBounds(20, 50, bodyPanel.getWidth() - 60, bodyPanel.getHeight() - 60);
        TitledBorder border = new TitledBorder("선수 정보");
        border.setTitleFont(new Font("돋움", Font.PLAIN, 13));
        inputForm.setBorder(border);

        int x = 80;
        name = new LabeledTextField(inputForm, x,30);
        name.label.setText("이름");
        age = new LabeledTextField(inputForm, x,60);
        age.label.setText("나이");
        height = new LabeledTextField(inputForm, x,90);
        height.label.setText("키");
        var1 = new LabeledTextField(inputForm, x,120);
        var2 = new LabeledTextField(inputForm, x,150);
        var3 = new LabeledTextField(inputForm, x,180);
        changeLabel("투수");

        bodyPanel.add(inputForm);


        JPanel selectionPanel = new JPanel();
        selectionPanel.setLayout(null);
        selectionPanel.setBounds(0, this.getHeight() - 100, this.getWidth(), 60);
        selectionPanel.setBackground(Color.LIGHT_GRAY);
        ok = new JButton("OK");
        ok.setFont(this.getFont());
        ok.setBounds(selectionPanel.getWidth()-200, selectionPanel.getHeight()/3,
                80, selectionPanel.getHeight()/2);
        ok.addActionListener(this::insertMember);
        cancel = new JButton("Cancel");
        cancel.setFont(this.getFont());
        cancel.setBounds(selectionPanel.getWidth()-110, selectionPanel.getHeight()/3,
                80, selectionPanel.getHeight()/2);
        selectionPanel.add(ok);
        selectionPanel.add(cancel);
        add(selectionPanel);

        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void callChangeLabel(ActionEvent e) {
        changeLabel(((JRadioButton)e.getSource()).getText());
    }

    public void changeLabel(String name) {
        if(name.equals("타자")){
            var1.label.setText("타수");
            var2.label.setText("안타수");
            var3.label.setText("타율");
        } else {
            var1.label.setText("승리 횟수");
            var2.label.setText("패배 횟수");
            var3.label.setText("방어율");
        }
    }

    public void insertMember(ActionEvent e) {
        try {
            String name = this.name.textField.getText();
            int age = Integer.parseInt(this.age.textField.getText());
            double height = Double.parseDouble(this.height.textField.getText());
            int var1 = Integer.parseInt(this.var1.textField.getText());
            int var2 = Integer.parseInt(this.var2.textField.getText());
            double var3 = Double.parseDouble(this.var3.textField.getText());

            if (pitcher.isSelected()) {
                Member member = new Pitcher(name, age, height, var1, var2, var3);
                MemberControl.getMemberRepository().addMember(member);
            }
            else {
                Member member = new Batter(name, age, height, var1, var2, var3);
                MemberControl.getMemberRepository().addMember(member);
            }

            JOptionPane.showMessageDialog(null, "선수가 추가되었습니다.");

        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "잘못 입력하셨습니다.");
        }
    }
}
