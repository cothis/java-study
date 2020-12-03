package day023.chatting.client.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainView extends JFrame {

    JLabel ipAddrLabel;
    JTextField ipAddr;

    JLabel portLabel;
    JTextField port;

    JLabel nameLabel;
    JTextField name;

    JLabel errorMessage;

    JButton enterRoom;

    ObjectInputStream is;

    private Socket socket;
    private List<String> users;

    public String getName() {
        return name.getText();
    }

    public List<String> getUsers() {
        return users;
    }

    public Socket getSocket() {
        return socket;
    }

    public static Font font = new Font("돋움", Font.PLAIN, 13);

    public MainView() throws HeadlessException {
        setLayout(null);
        setFont(font);

        users = new ArrayList<>();

        createControls();

        setResizable(false);
        setPreferredSize(new Dimension(enterRoom.getX() + enterRoom.getWidth() + 10 + 16, 240));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void createControls() {
        errorMessage = new JLabel("Invalid!");
        errorMessage.setForeground(Color.red);
        errorMessage.setSize(100, 30);
        errorMessage.setVisible(false);
        add(errorMessage);

        ipAddrLabel = new JLabel("server ip");
        ipAddrLabel.setBounds(10,10,60,30);
        ipAddr = new JTextField("192.168.0.136");
        ipAddr.setInputVerifier(new IPVerifier(errorMessage, ipAddr));
        ipAddr.setBounds(ipAddrLabel.getX(), ipAddrLabel.getY() + ipAddrLabel.getHeight(),
                120, ipAddrLabel.getHeight());
        add(ipAddrLabel);
        add(ipAddr);

        portLabel = new JLabel("port");
        portLabel.setBounds(ipAddrLabel.getX() + ipAddr.getWidth() + 10,10,30,30);
        port = new JTextField("9000");
        port.setInputVerifier(new PortVerifier(errorMessage, port));
        port.setBounds(portLabel.getX(), portLabel.getY() + portLabel.getHeight(),
                60, portLabel.getHeight());
        add(portLabel);
        add(port);

        nameLabel = new JLabel("name");
        nameLabel.setBounds(10, ipAddr.getY() + ipAddr.getHeight() + 10, 60, 30);
        name = new JTextField();
        name.setBounds(nameLabel.getX(), nameLabel.getY() + nameLabel.getHeight(),
                120, nameLabel.getHeight());
        add(nameLabel);
        add(name);

        enterRoom = new JButton("Enter Room");
        enterRoom.setBounds(10, name.getY() + name.getHeight() + 10,
                port.getX() + port.getWidth() - ipAddr.getX(), 30);
        enterRoom.addActionListener(this::openRoom);
        add(enterRoom);
    }

    public void openRoom(ActionEvent e) {
        String name = this.name.getText();
        if(name.length() == 0) {
            JOptionPane.showMessageDialog(null,"이름을 입력하세요.");
            return;
        }

        try {
            InetSocketAddress socketAddress = new InetSocketAddress(ipAddr.getText(), Integer.parseInt(port.getText()));
            socket = new Socket();
            socket.connect(socketAddress);

            //보내는 놈
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            pw.println(name);

            ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
            os.writeObject("ha");
            os.flush();

            //받는 놈
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            br.readLine();

            ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
            is.readObject();

            is = new ObjectInputStream(socket.getInputStream());
            Object o = is.readObject();
            System.out.println(o);



        } catch (Exception exception) {
            exception.printStackTrace();
            JOptionPane.showMessageDialog(null, "연결에 실패했습니다.");
            return;
        }

        setVisible(false);
        new ChattingRoom(this);
    }
}

class PortVerifier extends InputVerifier {

    JLabel errorLabel;
    JTextField targetField;

    public PortVerifier(JLabel errorLabel, JTextField targetField) {
        this.errorLabel = errorLabel;
        this.targetField = targetField;
    }

    @Override
    public boolean verify(JComponent input) {
        String text = ((JTextField) input).getText();
        try {
            int number = Integer.parseInt(text);
            boolean res = number <= 65535 && number >= 1024;
            if (res && errorLabel.isVisible()) {
                errorLabel.setVisible(false);
                errorLabel.revalidate();
                errorLabel.repaint();
            } else if (!res) {
                throw new NumberFormatException();
            }
            return true;
        } catch (NumberFormatException e) {
            errorLabel.setLocation(targetField.getX(), targetField.getY() + targetField.getHeight());
            errorLabel.setVisible(true);
            errorLabel.revalidate();
            errorLabel.repaint();
            return false;
        }
    }
}

class IPVerifier extends InputVerifier {

    JLabel errorLabel;
    JTextField targetField;

    public IPVerifier(JLabel errorLabel, JTextField targetField) {
        this.errorLabel = errorLabel;
        this.targetField = targetField;
    }

    @Override
    public boolean verify(JComponent input) {
        String text = ((JTextField) input).getText();
        try {
            boolean res;
            String[] ips = text.split("\\.");
            for (String ip : ips) {
                int number = Integer.parseInt(ip);
                res = number >= 0 && number <= 255;
                if (res && errorLabel.isVisible()) {
                    errorLabel.setVisible(false);
                    errorLabel.revalidate();
                    errorLabel.repaint();
                } else if (!res) {
                    throw new Exception();
                }
            }
            return true;
        } catch (Exception e) {
            errorLabel.setLocation(targetField.getX(), targetField.getY() + targetField.getHeight());
            errorLabel.setVisible(true);
            errorLabel.revalidate();
            errorLabel.repaint();
            return false;
        }
    }
}