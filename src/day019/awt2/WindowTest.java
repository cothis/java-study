package day019.awt2;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowTest extends Frame implements WindowListener {
    public WindowTest() {

        //setLayout(new FlowLayout());
        //setLayout(new GridLayout(3,2));
        setLayout(null);

        // Label
        Label label = new Label();
        label.setText("Label");
        label.setBounds(150,30,50,30);
        label.setBackground(Color.pink);
        add(label);

        Label label1 = new Label("Label1입니다");
        label1.setBackground(Color.ORANGE);
        label1.setBounds(150,80,70,30);
        add(label1);

        Button button = new Button();
        button.setBackground(Color.green);
        button.setLabel("버튼");
        button.setBounds(150,150,100,30);
        add(button);

        //setSize(640,480);
        //setLocation(100,100);
        setBounds(100,100,800,600);
        addWindowListener(this);
        setVisible(true);
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
