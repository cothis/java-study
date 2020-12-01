package day021.flowmenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    FlowPanel panel;
    JButton button;

    public MainFrame() throws HeadlessException {
        setLayout(null);
        button = new JButton();
        button.setBounds(10, 10, 70, 30);
        button.setText("menu");
        button.addActionListener(this::playFlowPanel);
        add(button);

        panel = new FlowPanel(this);

        setSize(600, 480);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    void playFlowPanel(ActionEvent e) {
        panel.flow();
        button.setVisible(false);
    }
}

class FlowPanel extends JPanel {

    MainFrame frame;
    JButton testButton;
    Timer t;
    boolean show = false;

    int x;
    int y;
    int target;

    public FlowPanel(MainFrame frame) {
        this.frame = frame;
        setLayout(null);


        t = new Timer(1, this::doFlow);

        testButton = new JButton();
        testButton.setText("hello");
        testButton.setBounds(50,200,100,180);
        testButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flow();
            }
        });
        add(testButton);

        setBounds(-200,0,200,480);
        setVisible(true);
        setBackground(Color.ORANGE);
        frame.add(this);
    }

    public void doFlow(ActionEvent e) {
        if (show) {
            this.setLocation(++x, y);
        }
        else {
            this.setLocation(--x, y);
        }

        if(x == target) {
            t.stop();
            frame.button.setVisible(!show);
        }
    }

    public void flow() {
        x = this.getX();
        y = this.getY();
        int length = this.getWidth();
        show = !show;

        if (show) {
            target = x + length;
        } else {
            target = x - length;
        }
        t.start();
    }
}