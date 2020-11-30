package day021.random_button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {

    JButton[] button = null;

    int randomNum;

    public MainFrame(int count) throws HeadlessException {
        super("main");
        setLayout(null);


//        JOptionPane.showMessageDialog(null, count + "");

        randomNum = (int) (Math.random() * count) + 1;
//        JOptionPane.showMessageDialog(null, "randomNum:" + randomNum);

        button = new JButton[count];

        int x = 0;
        int y = 0;
        for (int i = 0; i < button.length; i++) {
            button[i] = new JButton((i + 1) + "");
            button[i].setBounds(160 + x * 90, 150 + y * 90, 80, 80);
            button[i].addActionListener(this);
            add(button[i]);

            if(i % 3 == 2) y++;

            if(x == 2) x = 0;
            else x++;
        }


        setBounds(200, 100, 580, 480);
        setVisible(true);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        String btnNum = btn.getText();

        for (int i = 0; i < button.length; i++) {
            if (btnNum.equals((i + 1) + "")) {
//                JOptionPane.showMessageDialog(null, (i + 1) + " 버튼 클릭!");
                if (randomNum == (i + 1)) {
                    JOptionPane.showMessageDialog(null, "당신이 걸렸습니다");
                } else {
                    // 버튼 비활성화
//                    button[i].setEnabled(false);
                    
                    // 버튼 비시각화
                    button[i].setVisible(false);
                }
            }

        }


    }
}
