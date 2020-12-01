package day021.work.membercontrol.view.main.panel;

import javax.swing.*;
import java.awt.*;

public abstract class ContentPanel extends JPanel {
    void setGeometry() {
        setLayout(null);
        setBackground(Color.GRAY);
        setSize(750,660);
        setLocation(270, 65);
    }
}
