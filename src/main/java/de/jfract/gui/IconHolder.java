package de.jfract.gui;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * User: kesper
 * Date: 04.03.13
 * Time: 09:30
 */
public class IconHolder {
    private static Image icon = null;
    public static Image getIcon() {
        if (icon==null) {
            try {
                icon = ImageIO.read(ClassLoader.getSystemResourceAsStream("jfract-16.png"));
            } catch (IOException ex) {
                Logger.getLogger(IconHolder.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return icon;
    }
}
