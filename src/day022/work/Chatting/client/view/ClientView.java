package day022.work.Chatting.client.view;

import javax.swing.*;
import java.awt.*;

public class ClientView extends JFrame {

    JTextField address;
    JLabel addressLabel;

    JTextField port;
    JLabel portLabel;

    JButton connectButton;

    public ClientView() throws HeadlessException {
        setTitle("Chatting App");


        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
