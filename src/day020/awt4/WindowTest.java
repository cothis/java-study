package day020.awt4;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
    Panel
        : Window 위의 Window

    TextField, TextArea

*/
public class WindowTest extends JFrame { //implements ActionListener {

    JTextField textField;
    JTextArea textArea;

    JButton nextInsert, prevInsert;

    public WindowTest() throws HeadlessException {
        super("타이틀바");

        JPanel textAreaPanel = new JPanel();
        textArea = new JTextArea();
        textArea.setLineWrap(true);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(400,300));
        textAreaPanel.add(scrollPane);

        JPanel inputComponentPanel = new JPanel();
        textField = new JTextField(30);

        nextInsert = new JButton("next insert");
//        nextInsert.addActionListener(this);
        nextInsert.addActionListener(e -> nextInserted(e, true));

        prevInsert = new JButton("prev insert");
//        prevInsert.addActionListener(this);
        prevInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String msg = textField.getText() + "\n";
//                textArea.insert(msg, textArea.getLineStartOffset(0));
                textArea.insert(msg, 0);
            }
        });

        inputComponentPanel.add(textField);
        inputComponentPanel.add(nextInsert);
        inputComponentPanel.add(prevInsert);

        Container contentPane = getContentPane();
        contentPane.add(textAreaPanel, BorderLayout.CENTER);
        contentPane.add(inputComponentPanel, BorderLayout.SOUTH);

        setBounds(100,100,640,480);
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void nextInserted(ActionEvent e, boolean up) {
        String msg = textField.getText() + "\n";
        textArea.append(msg);
    }


    /*
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        String btnLabel = btn.getText();

        if(btnLabel.equals("next insert")) {

        }
        else if(btnLabel.equals("prev insert")) {

        }
    }
    */
}
