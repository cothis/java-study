package day021.awt.panelchange;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelChange {

    public static void main(String[] args) {
        new WindowTest();
    }

}

class WindowTest extends JFrame {

    MyButtonPanel panel1, panel2;

    public WindowTest() throws HeadlessException {

//        setLayout(new FlowLayout());
        setLayout(null);

        panel1 = new MyButtonPanel(this::switchPanel, "p1");
        panel1.setBackground(Color.PINK);
        panel1.setVisible(true);

        panel2 = new MyButtonPanel(this::switchPanel, "p2");
        panel2.setBackground(Color.YELLOW);
        JLabel label = new JLabel("P2 Label");
        label.setOpaque(true);
        label.setBounds(0,0,300,50);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setBackground(Color.CYAN);
        panel2.add(label);
        panel2.setVisible(true);

        add(panel1);

        setBounds(0, 0, 600, 600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void switchPanel(MyButtonPanel p) {
        this.getContentPane().remove(p);
        if (p == panel1) {
            this.getContentPane().add(panel2);
        }
        if (p == panel2) {
            this.getContentPane().add(panel1);
        }
        revalidate();
        repaint();
    }

}

@FunctionalInterface
interface TestInterface {
    void swap(MyButtonPanel p);
}

class MyButtonPanel extends JPanel {

    JButton button;

    public MyButtonPanel(TestInterface t, String name) {
        this.setLayout(null);
        setName(name);

        button = new JButton(name);
        button.setBounds(200, 200, 80, 60);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t.swap(MyButtonPanel.this);
            }
        });
        add(button);
        setBounds(0,0,500,500);
    }
}
