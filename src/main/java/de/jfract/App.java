package de.jfract;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 * Here starts the application. We will only accept JVM's that are aware of the
 * Nimbus LAF - which means jdk 1.6+ I think...
 * User: kesper
 * Date: 22.02.13
 * Time: 15:16
 */
public class App {

    public static void main(String[] args) throws Exception {

        UIManager.setLookAndFeel(new NimbusLookAndFeel());


        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ApplicationContext.getInstance().getMainFrame().setVisible(true);
            }
        });
    }
}
