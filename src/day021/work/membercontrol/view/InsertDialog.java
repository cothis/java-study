package day021.work.membercontrol.view;

import day021.work.membercontrol.MemberControl;
import day021.work.membercontrol.dto.Batter;
import day021.work.membercontrol.dto.Member;
import day021.work.membercontrol.dto.Pitcher;
import day021.work.membercontrol.view.components.LabeledTextField;
import day021.work.membercontrol.view.main.MainView;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InsertDialog extends JDialog {

    JRadioButton pitcher, batter;
    JButton ok, cancel;

    JPanel inputForm;
    JFrame parent;

    LabeledTextField name;
    LabeledTextField age;
    LabeledTextField height;
    LabeledTextField var1;
    LabeledTextField var2;
    LabeledTextField var3;
    boolean updateMode = false;
    Member present = null;

    public InsertDialog(JFrame parent, Member presentMember) throws HeadlessException {
        super(parent, "Insert Form", true);
        this.parent = parent;
        this.present = presentMember;
        setTitle("Insert Form");
        setLayout(null);
        setResizable(false);
        updateMode = (presentMember != null);

        setSize(300,440);
        setLocationRelativeTo(null);

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(null);
        titlePanel.setBounds(0, 0, this.getWidth(), 60);
        titlePanel.setBackground(Color.ORANGE);

        JLabel backgroundLabel = new JLabel();
        if (updateMode) {
            backgroundLabel.setText("UPDATE Form");
        } else {
            backgroundLabel.setText("INSERT Form");
        }
        backgroundLabel.setFont(new Font("돋움", Font.BOLD, 25));
        backgroundLabel.setBounds(10, 15, 300, 30);
        titlePanel.add(backgroundLabel);

        add(titlePanel);

        JPanel bodyPanel = new JPanel();
        bodyPanel.setLayout(null);
        bodyPanel.setBounds(0, 60, this.getWidth(), this.getHeight() - 160);

        ButtonGroup buttonGroup = new ButtonGroup();

        boolean selectedPitcher = true;
        if(updateMode) {
            if(presentMember instanceof Pitcher) {
                selectedPitcher = true;
            }
            else {
                selectedPitcher = false;
            }
        }

        pitcher = new JRadioButton("투수", selectedPitcher);
        pitcher.setBounds(20, 5, 60, 40);
        pitcher.setFont(this.getFont());
        pitcher.addActionListener(this::callChangeLabel);
        buttonGroup.add(pitcher);
        bodyPanel.add(pitcher);

        batter = new JRadioButton("타자", !selectedPitcher);
        batter.setBounds(80, 5, 60, 40);
        batter.setFont(this.getFont());
        batter.addActionListener(this::callChangeLabel);
        buttonGroup.add(batter);
        bodyPanel.add(batter);
        add(bodyPanel);

        if(updateMode){
            pitcher.setEnabled(false);
            batter.setEnabled(false);
        }


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
        var3.textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    insertMember(null);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        if (updateMode) {
            if (presentMember instanceof Pitcher) {
                changeLabel("투수");
            } else {
                changeLabel("타자");
            } 
        } else {
            changeLabel("투수");
        } 

        if (updateMode) {
            name.textField.setText(presentMember.getName());
            age.textField.setText(presentMember.getAge() + "");
            height.textField.setText(presentMember.getHeight() + "");

            if (presentMember instanceof Pitcher) {
                Pitcher p = (Pitcher) presentMember;
                var1.textField.setText(p.getWin() + "");
                var2.textField.setText(p.getLose() + "");
                var3.textField.setText(p.getDefence() + "");
            } else {
                Batter b = (Batter) presentMember;
                var1.textField.setText(b.getHitCount() + "");
                var2.textField.setText(b.getHits() + "");
                var3.textField.setText(b.getHitRate() + "");
            }
        }

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

            Member member;

            if (pitcher.isSelected()) {
                member = new Pitcher(name, age, height, var1, var2, var3);
            }
            else {
                member = new Batter(name, age, height, var1, var2, var3);
            }

            if (updateMode) {
                MemberControl.getMemberRepository().updateMember(present, member);
                JOptionPane.showMessageDialog(null, "선수 정보가 변경되었습니다.");
            } else {
                MemberControl.getMemberRepository().addMember(member);
                JOptionPane.showMessageDialog(null, "선수가 추가되었습니다.");
            }


        } catch (Exception exception) {
            exception.printStackTrace();
            JOptionPane.showMessageDialog(null, "잘못 입력하셨습니다.");
        }
    }
}
