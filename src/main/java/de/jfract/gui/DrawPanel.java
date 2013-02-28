package de.jfract.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;


/**
 * User: kesper
 * Date: 22.02.13
 * Time: 15:20
 */
public class DrawPanel extends JPanel {


    public DrawPanel() {
        this.addMouseListener(new MouseClickListener());
    }

    @Override
    public void paint(Graphics g) {
        paintComponent(g);
    }

    public void paintComponent(Graphics g) {
//        g.setColor(Color.black);
//        g.fillRect(0,0,getWidth(), getHeight());
    }

}
