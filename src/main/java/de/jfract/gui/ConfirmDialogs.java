package de.jfract.gui;

import de.jfract.ApplicationContext;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: kesper
 * Date: 05.03.13
 * Time: 14:14
 * To change this template use File | Settings | File Templates.
 */
public class ConfirmDialogs {

    public static void showError(String msg) {
        JOptionPane.showConfirmDialog(ApplicationContext.getInstance().getMainFrame(), msg, "ERROR", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
    }

    public static String showInput(String msg, String value) {
        String result = JOptionPane.showInputDialog(
                ApplicationContext.getInstance().getMainFrame(),
                msg,
                value);
        return result;
    }
}
