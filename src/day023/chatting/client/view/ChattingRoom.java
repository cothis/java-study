package day023.chatting.client.view;

import day023.chatting.client.thread.ClientReceiveThread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ChattingRoom extends JFrame {

    MainView parent;

    JLabel textAreaLabel;
    JTextArea textArea;

    JLabel listLabel;
    JList<String> list;
    DefaultListModel<String> dm;

    JTextField inputField;
    JButton sendButton;

    ClientReceiveThread receiveThread;

    public ChattingRoom(MainView mainView) throws HeadlessException {
        setTitle("AJoo Talk v1.0");
        this.parent = mainView;
        setLayout(null);
        createControls();

        receiveThread = new ClientReceiveThread(parent.getSocket(), textArea, this);
        receiveThread.start();

        setSize(800,600);
        setLocationRelativeTo(null);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    parent.getSocket().close();
                    receiveThread.setExit(true);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                dispose();
                parent.setVisible(true);
                parent.revalidate();
                parent.repaint();
            }
        });
    }

    public void createControls() {
        textAreaLabel = new JLabel("Chatting");
        textAreaLabel.setBounds(10, 10, 550, 30);
        add(textAreaLabel);

        textArea = new JTextArea();
        textArea.setBounds(10, textAreaLabel.getY() + textAreaLabel.getHeight(), textAreaLabel.getWidth(), 450);
        textArea.setText("");
        JScrollPane textAreaScroll = new JScrollPane(textArea);
        textAreaScroll.setBounds(10, textAreaLabel.getY() + textAreaLabel.getHeight(), textAreaLabel.getWidth(), 450);
        add(textAreaScroll);

        listLabel = new JLabel("User List");
        listLabel.setBounds(textAreaLabel.getX() + textAreaLabel.getWidth() + 10, textAreaLabel.getY(), 200, textAreaLabel.getHeight());
        add(listLabel);

        dm = new DefaultListModel<>();
        for (String user : parent.getUsers()) {
            dm.add(dm.size(), user);
        }

        list = new JList<>();
        list.setBounds(listLabel.getX(), listLabel.getY() + listLabel.getHeight(), listLabel.getWidth(), textArea.getHeight());
        JScrollPane listScroll = new JScrollPane(list);
        listScroll.setBounds(listLabel.getX(), listLabel.getY() + listLabel.getHeight(), listLabel.getWidth(), textArea.getHeight());
        add(listScroll);
        list.setModel(dm);

        inputField = new JTextField("");
        inputField.setBounds(10, textArea.getY() + textArea.getHeight() + 10, textArea.getWidth(), 30);
        inputField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == 10) {
                    sendMessage(null);
                }
            }
        });
        add(inputField);

        sendButton = new JButton("Send");
        sendButton.setBounds(listLabel.getX(), inputField.getY(), list.getWidth(), 30);
        sendButton.addActionListener(this::sendMessage);
        add(sendButton);
    }

    public void sendMessage(ActionEvent ae) {
        if(inputField.getText().length() == 0) {
            return;
        }
        Socket client = parent.getSocket();

        try {
            PrintWriter pw = new PrintWriter(client.getOutputStream(), true);
            pw.println(inputField.getText());
            textArea.append(parent.getName() + ": " + inputField.getText() + "\n");
            inputField.setText("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addList(String name) {
        dm.clear();
        for (String user : parent.getUsers()) {
            dm.add(dm.size(), user);
        }
    }
}
