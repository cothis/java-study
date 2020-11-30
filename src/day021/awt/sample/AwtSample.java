package day021.awt.sample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AwtSample {

    public static void main(String[] args) {
        new WindowTest();

    }

}

/*
    Radio Button : AWT X, Swing O
        : 선택 1개
    Check Box
        : 선택 여러개
*/

class WindowTest extends Frame implements WindowListener, ActionListener, ItemListener {

    Checkbox cb1, cb2, cb3, cb4, cb5;
    Label label1, label2;

    Checkbox exitCheck;

    JRadioButton[] radioButtons;
    Label labelJRadio;

    public WindowTest() throws HeadlessException {
        CheckboxGroup cbGroup1 = new CheckboxGroup();
        cb1 = new Checkbox("사과", cbGroup1, true);
        cb2 = new Checkbox("배", cbGroup1, false);
        cb3 = new Checkbox("바나나", cbGroup1, false);

        CheckboxGroup cbGroup2 = new CheckboxGroup();
        cb4 = new Checkbox("빨강", cbGroup2, false);
        cb5 = new Checkbox("파강", cbGroup2, true);
        
        exitCheck = new Checkbox("exit");

        add(cb1);
        add(cb2);
        add(cb3);
        add(cb4);
        add(cb5);
        add(exitCheck);

        cb1.addItemListener(this);
        cb2.addItemListener(this);
        cb3.addItemListener(this);
        cb4.addItemListener(this);
        cb5.addItemListener(this);
        exitCheck.addItemListener(this);

        label1 = new Label("label1");
        label2 = new Label("label2");

        add(label1);
        add(label2);

        JPanel jPanel = new JPanel();
        String[] items = {"프로그래머", "백수", "건물주", "선생님"};
        ButtonGroup jGroup = new ButtonGroup();
        radioButtons = new JRadioButton[items.length];

        for (int i = 0; i < items.length; i++) {
            String item = items[i];
            radioButtons[i] = new JRadioButton(item);
            radioButtons[i].addActionListener(this::testJRadioButtons);
            jGroup.add(radioButtons[i]);
            jPanel.add(radioButtons[i]);
        }
        labelJRadio = new Label(items[0]);
        jPanel.add(labelJRadio);
        add(jPanel);

        setLayout(new FlowLayout());
        setBounds(0, 0, 640, 480);
        setVisible(true);

        addWindowListener(this);
    }

    public void testJRadioButtons(ActionEvent e) {
        JRadioButton source = (JRadioButton) e.getSource();
        labelJRadio.setText(source.getText());
    }


    @Override
    public void itemStateChanged(ItemEvent e) {
        Object obj = e.getSource();

        // CheckBox
        if (obj == exitCheck) {
            Checkbox cb = (Checkbox) obj;
            if (cb.getState()) {
                System.exit(0);
            }
        }

        // Radio Button
        if (obj == cb1 || obj == cb2 || obj == cb3) {
            Checkbox cb = (Checkbox) obj;
            if (cb.getState()) {
                label1.setText(cb.getLabel());
            }
        }

        // Radio Button
        if (obj == cb4 || obj == cb5) {
            Checkbox cb = (Checkbox) obj;
            if (cb.getState()) {
                label2.setText(cb.getLabel());
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

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
