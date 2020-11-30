package day021.awt.choice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class AwtChoice {

    public static void main(String[] args) {
        new WindowTest();
    }

}

class WindowTest extends JFrame {

    Choice choice;
    Label label;

    public WindowTest() throws HeadlessException {
        setLayout(new FlowLayout());

        choice = new Choice();
        choice.add("사과");
        choice.add("귤");
        choice.add("배");
        choice.add("바나나");
        choice.add("오렌지");

        choice.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                label.setText(choice.getSelectedItem());
            }
        });
        add(choice);

        label = new Label("---");
        add(label);

        setBounds(0, 0, 640, 480);
        setVisible(true);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
