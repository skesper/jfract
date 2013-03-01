package de.jfract.gui.actions;

import de.jfract.ApplicationContext;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created with IntelliJ IDEA.
 * User: kesper
 * Date: 25.02.13
 * Time: 12:56
 * To change this template use File | Settings | File Templates.
 */
public class IterationDepthAction extends AbstractAction {
    public IterationDepthAction() {
        putValue(Action.NAME, "Iteration depth ...");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String result = JOptionPane.showInputDialog(
                ApplicationContext.getInstance().getMainFrame(),
                "Iteration depth",
                ApplicationContext.getInstance().getFractalParameters().getMaxit());

        if (result!=null) {
            try {
                int it = Integer.parseInt(result);
                ApplicationContext.getInstance().getFractalParameters().setMaxit(it);
                ApplicationContext.getInstance().recalculate();
            } catch(NumberFormatException nfe) {
                JOptionPane.showConfirmDialog(
                        ApplicationContext.getInstance().getMainFrame(),
                        "The number "+result+" could not be parsed",
                        "ERROR",
                        JOptionPane.ERROR_MESSAGE);

            }
        }
    }
}
