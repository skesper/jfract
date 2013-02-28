package de.jfract.gui;

import de.jfract.ApplicationContext;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created with IntelliJ IDEA.
 * User: kesper
 * Date: 22.02.13
 * Time: 17:00
 * To change this template use File | Settings | File Templates.
 */
public class MouseClickListener implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        int button = e.getButton();

        DrawPanel dp = ApplicationContext.getInstance().getPanel();

        boolean recalc = false;
        if (button == 1) {
            ApplicationContext.getInstance().getFractalParameters().zoomIn(x,y,dp.getWidth(),dp.getHeight());
            recalc = true;
        } else if (button == 3) {
            ApplicationContext.getInstance().getFractalParameters().zoomOut(x,y,dp.getWidth(),dp.getHeight());
            recalc = true;
        } else if (button == 2) {
            ApplicationContext.getInstance().getFractalParameters().pan(x,y,dp.getWidth(),dp.getHeight());
            recalc = true;
        }
        if (recalc) {
            ApplicationContext.getInstance().recalculate();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        ((JPanel)e.getSource()).setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        ((JPanel)e.getSource()).setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
}
