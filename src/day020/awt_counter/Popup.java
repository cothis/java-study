package day020.awt_counter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Popup extends Frame implements ActionListener, WindowListener {

    public Popup() throws HeadlessException {
        this.setBounds(220,220,480,480);
        paintComponents(this.getGraphics());
        addWindowListener(this);
        setVisible(true);
    }

    public void setBackgroundImage(BufferedImage image) {
        Panel background = new Panel() {

        };

    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);

        String path = "D:/Lenna.png";
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(path));

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(image);
        g.drawImage(image, 0, 0, this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        this.dispose();
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
