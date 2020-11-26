package day019.awt3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowTest extends Frame implements WindowListener, ActionListener {
    Label label;
    Button button1, button2;

    public WindowTest() throws HeadlessException {

        setLayout(null);

        label = new Label("label");
        label.setBounds(100,100,350,30);
        label.setBackground(Color.PINK);
        add(label);

        button1 = new Button("one button");
        button1.setBounds(100,160,150,30);
        button1.addActionListener(this);
        add(button1);

        button2 = new Button("two button");
        button2.setBounds(300,160,150,30);
        button2.addActionListener(this);
        add(button2);

        setBounds(100,100,640,480);
        addWindowListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println("버튼 클릭");
        //JOptionPane.showMessageDialog(null,"버튼 클릭");
        Button btn = (Button) e.getSource();
        String btnTitle = btn.getLabel();
        if(btnTitle.equals("one button")) {
            //JOptionPane.showMessageDialog(null,"one");
            label.setText("one button click");
        }
        else if(btnTitle.equals("two button")) {
            //JOptionPane.showMessageDialog(null,"two");
            label.setText("two button click");
        }
    }

    @Override
    public void windowOpened(WindowEvent e) { }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) { }

    @Override
    public void windowIconified(WindowEvent e) { }

    @Override
    public void windowDeiconified(WindowEvent e) { }

    @Override
    public void windowActivated(WindowEvent e) { }

    @Override
    public void windowDeactivated(WindowEvent e) { }

}
