package de.jfract.gui.actions;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created with IntelliJ IDEA.
 * User: kesper
 * Date: 22.02.13
 * Time: 15:26
 * To change this template use File | Settings | File Templates.
 */
public class ExitAction extends AbstractAction {
    public ExitAction() {
        putValue(AbstractAction.NAME, "Exit");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
