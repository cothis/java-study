package day020.work;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GameFrame extends JFrame {
    int number = 0;
    int answer;
    JLabel numberLabel;
    JButton[][] buttons;
    JButton resetButton;

    public GameFrame() throws HeadlessException {
        this(5);
    }

    public GameFrame(int number) throws HeadlessException {
        setTitle("게임 화면");
        setLayout(null);
        this.number = number;

        createButtons();
        reset();

        resetButton = new JButton("Reset");
        resetButton.setBounds(50, 400, 180, 60);
        resetButton.addActionListener(this::callReset);
        add(resetButton);

        setBounds(120,120,340,600);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void createAnswer() {
        answer = (int)(Math.random() * number) + 1;
        System.out.println(answer);
    }

    public void createButtons() {
        int rowNum = ((number-1) / 3) + 1;
        buttons = new JButton[rowNum][3];

        int count = 0;
        for(int row = 0; row < buttons.length; row++ ) {
            for(int col = 0; col < buttons[row].length ; col++) {
                if(row*3 + col < number) {
                    buttons[row][col] = new JButton();
                    JButton ptrButton = buttons[row][col];
                    ptrButton.addActionListener(this::buttonClicked);
                    ptrButton.setText( String.valueOf(row*3 + col+1));
                    ptrButton.setBounds(50+col*80, 150+row*80, 60, 60);
                    add(ptrButton);
                }
            }
        }
    }

    public void buttonClicked(ActionEvent e) {
        int value = Integer.parseInt(((JButton)e.getSource()).getText());
        if(value != answer) {
            ((JButton)e.getSource()).setEnabled(false);
            JOptionPane.showMessageDialog(null, "틀렸습니다.");
        }
        else {
            numberLabel.setText(value + "번 님 당첨!");
            JOptionPane.showMessageDialog(null, "당첨 했습니다.");
            allEnable(false);

        }
    }

    public void allEnable(boolean enable) {
        for (JButton[] button : buttons) {
            for (JButton jButton : button) {
                if(jButton != null) jButton.setEnabled(enable);
            }
        }
    }

    public void callReset(ActionEvent e) {
        reset();
        JOptionPane.showMessageDialog(null,"초기화 됐습니다.");
    }

    public void reset() {
        allEnable(true);

        numberLabel = new JLabel(number+"개의 숫자");
        numberLabel.setBounds(50,50,180,50);
        numberLabel.setBackground(Color.PINK);
        numberLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(numberLabel);

        createAnswer();
    }
}
