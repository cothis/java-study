package day021.awt.windowchange;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
    Frame, Panel
    
    장면 전환
    Frame1, Frame2
    close   open

    Frame
        Panel1 -> Panel2
*/
public class WindowChange {

    public static void main(String[] args) {
        new Frame1();

    }

}

class Frame1 extends JFrame {

    public Frame1() throws HeadlessException {
        setLayout(null);

        JButton btn = new JButton("change frame");
        btn.setBounds(100, 100, 100, 30);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Frame2();
            }
        });
        add(btn);

        setBounds(0, 0, 640, 480);
        getContentPane().setBackground(Color.PINK);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}

class Frame2 extends JFrame {

    public Frame2() throws HeadlessException {
        setLayout(null);

        JButton btn = new JButton("change frame");
        btn.setBounds(100, 100, 100, 100);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Frame1();
            }
        });
        add(btn);

        setBounds(0, 0, 640, 480);
        setVisible(true);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
