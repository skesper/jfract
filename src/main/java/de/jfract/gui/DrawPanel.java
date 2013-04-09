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

    @Override
    public void repaint(Rectangle r) {
        super.repaint(r);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void repaint(long tm, int x, int y, int width, int height) {
        super.repaint(tm, x, y, width, height);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public Graphics getGraphics() {
        return super.getGraphics();
    }
}
