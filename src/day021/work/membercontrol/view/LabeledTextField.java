package day021.work.membercontrol.view;

import javax.swing.*;
import java.awt.*;

public class LabeledTextField {

    JTextField textField;
    JLabel label;

    public LabeledTextField(JPanel panel, int x, int y) {

        Font f = new Font("돋움", Font.PLAIN, 15);

        textField = new JTextField();
        textField.setSize(150,20);
        textField.setLocation(x, y);
        textField.setFont(f);

        label = new JLabel();
        label.setSize(70, 20);
        label.setLocation(x - label.getWidth(), y);
        label.setFont(f);

        panel.add(textField);
        panel.add(label);
    }
}
