package de.jfract;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 * Created with IntelliJ IDEA.
 * User: kesper
 * Date: 22.02.13
 * Time: 15:16
 * To change this template use File | Settings | File Templates.
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
