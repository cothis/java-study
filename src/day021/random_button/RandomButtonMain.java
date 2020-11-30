package day021.random_button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class RandomButtonMain {
    public static void main(String[] args) {
        new ButtonConfig();
    }
}

class ButtonConfig extends Frame implements WindowListener, ActionListener {

    TextField tf;
    Button setBtn, startBtn;

    int buttonCount;

    public ButtonConfig() throws HeadlessException {
        super("설정");
        setLayout(null);

        buttonCount = 2;

        Label label = new Label("Button Count");
        label.setBounds(30, 30, 240, 30);
        add(label);

        tf = new TextField("2");
        tf.setBounds(30, 80, 240, 20);
        add(tf);

        setBtn = new Button("set");
        setBtn.setBounds(30, 120, 100, 30);
        setBtn.addActionListener(this);
        add(setBtn);

        startBtn = new Button("start");
        startBtn.setBounds(160, 120, 100, 30);
        startBtn.addActionListener(this);
        add(startBtn);

        setSize(320,240);
        setLocation(100,100);
        setVisible(true);
        addWindowListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Button btn = (Button) e.getSource();
        String btnLabel = btn.getLabel();

        if (btnLabel.equals("set")) {
            buttonCount = Integer.parseInt(tf.getText());
//            JOptionPane.showMessageDialog(null, tf.getText());
        } else if (btnLabel.equals("start")) {
            new MainFrame(buttonCount);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}