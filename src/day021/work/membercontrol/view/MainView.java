package day021.work.membercontrol.view;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {

    Font font = new Font("돋움", Font.PLAIN, 15);

    public MainView() throws HeadlessException {
        super("Member Control Program v1.0");
        setLayout(null);
        setFont(font);


        MenuPanel menuPanel = new MenuPanel(this);
        menuPanel.setLocation(0,0);
        add(menuPanel);

        SearchPanel searchPanel = new SearchPanel(this);

        add(searchPanel);

        ContentPanel contentPanel = new ContentPanelImpl(this);
        add(contentPanel);

        setSize(1040, 768);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

