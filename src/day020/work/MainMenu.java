package day020.work;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainMenu extends JFrame {

    JTextField textField;
    JButton set;
    JButton start;
    int number;

    public MainMenu() throws HeadlessException {
        this(5);
    }

    public MainMenu(int number) throws HeadlessException {
        setTitle("랜덤 게임 설정");
        setLayout(null);
        this.number = number;

        JLabel message = new JLabel("버튼 갯수 설정");
        message.setBounds(100,40,200,40);
        message.setHorizontalAlignment(SwingConstants.CENTER);
        add(message);

        textField = new JTextField(number + "");
        textField.setBounds(100, 100, 200, 40);
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        add(textField);

        set = new JButton("set");
        set.setBounds(100,160,80, 80);
        set.addActionListener(this::set);
        add(set);

        start = new JButton("start");
        start.setBounds(220,160,80,80);
        start.addActionListener(this::start);
        add(start);

        setBounds(100,100,400,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void start(ActionEvent e) {
        new GameFrame(number);
    }

    public void set(ActionEvent e) {
        try {
            int temp = Integer.parseInt(textField.getText());
            if(temp < 2 || temp > 9) JOptionPane.showMessageDialog(null,"2~9 사이의 숫자를 입력해주세요.");
            else {
                number = temp;
            }
        } catch (NumberFormatException ne) {
            JOptionPane.showMessageDialog(null,"잘못 입력하셨습니다.");
        } finally {
            textField.setText(number + "");
        }
    }
}
