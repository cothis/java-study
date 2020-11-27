package day020.awt_counter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class CounterWindow extends Frame implements WindowListener, ActionListener {

    private Label title;
    private Label countLabel;
    private int count = 0;

    private Button upCount;
    private Button downCount;
    private Button resetButton;

    private Button popup;

    public CounterWindow() throws HeadlessException {
        setLayout(null);

        setTitle("카운터 프로그램");

        title = new Label("카운터");
        title.setBounds(120,60,240,60);
        title.setBackground(Color.GRAY);
        title.setAlignment(Label.CENTER);
        add(title);

        countLabel = new Label(String.valueOf(count));
        countLabel.setBounds(120, 180, 240, 40);
        countLabel.setBackground(Color.GRAY);
        countLabel.setAlignment(Label.CENTER);
        add(countLabel);

        upCount = new Button("+");
        upCount.setBounds(120,270,100,60);
        upCount.addActionListener(this);
        add(upCount);

        downCount = new Button("-");
        downCount.setBounds(260,270,100,60);
        downCount.addActionListener(this);
        add(downCount);

        resetButton = new Button("Reset");
        resetButton.setBounds(120,360,240,60);
        resetButton.addActionListener(this);
        add(resetButton);

        popup = new Button("popup");
        popup.setBounds(120,440,60,20);
        popup.addActionListener(this::showPopup);
        add(popup);

        Timer t = new Timer(1000, this::upTimer);
        t.start();

        setBounds(200,200,480,480);
        addWindowListener(this);
        setVisible(true);
    }

    public void showPopup(ActionEvent e) {
        Frame f = new Popup();
    }

    public void upTimer(ActionEvent e) {
        count++;
        countLabel.setText(String.valueOf(count));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof Button){
            switch (((Button) e.getSource()).getLabel()) {
                case "+": {
                    count++;
                    break;
                }
                case "-": {
                    count--;
                    break;
                }
                case "Reset": {
                    count = 0;
                    break;
                }
            }
            countLabel.setText(String.valueOf(count));
        }
        else {
            System.out.println(e.getSource());
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
