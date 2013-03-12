package de.jfract.gui;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * User: kesper
 * Date: 04.03.13
 * Time: 09:30
 */
public class IconHolder {

    public static final String APP_ICON_16 = "jfract-16.png";
    public static final String APP_ICON_32 = "jfract-32.png";
    public static final String APP_ICON_64 = "jfract-64.png";

    private static final HashMap<String, Image> iconCache = new HashMap<String, Image>();

    public static Image getIcon() {
        return getIcon(APP_ICON_16);
    }

    public static Image getIcon(String key) {
        Image icon = iconCache.get(key);
        if (icon==null) {
            try {
                icon = ImageIO.read(ClassLoader.getSystemResourceAsStream(key));
            } catch (IOException ex) {
                Logger.getLogger(IconHolder.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return icon;
    }

}
