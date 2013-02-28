package de.jfract.gui.actions;

import de.jfract.ApplicationContext;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * User: kesper
 * Date: 22.02.13
 * Time: 16:01
 */
public class CalculateAction extends AbstractAction {

    public CalculateAction() {
        putValue(Action.NAME, "Calculate ...");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ApplicationContext.getInstance().recalculate();
    }
}
