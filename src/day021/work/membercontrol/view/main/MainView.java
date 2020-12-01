package day021.work.membercontrol.view.main;

import day021.work.membercontrol.view.main.panel.ContentPanel;
import day021.work.membercontrol.view.main.panel.ContentPanelImpl;
import day021.work.membercontrol.view.main.panel.MenuPanel;
import day021.work.membercontrol.view.main.panel.SearchPanel;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {

    Font font = new Font("돋움", Font.PLAIN, 15);
    MenuPanel menuPanel;
    SearchPanel searchPanel;
    ContentPanel contentPanel;

    public MainView() throws HeadlessException {
        super("Member Control Program v1.0");
        setLayout(null);
        setFont(font);
        javax.swing.UIManager.put("OptionPane.messageFont", font);
        setResizable(false);


        menuPanel = new MenuPanel(this);
        menuPanel.setLocation(0,0);
        add(menuPanel);

        searchPanel = new SearchPanel(this);

        add(searchPanel);

        contentPanel = new ContentPanelImpl(this);
        add(contentPanel);

        setSize(1040, 768);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public SearchPanel getSearchPanel() {
        return searchPanel;
    }

}

