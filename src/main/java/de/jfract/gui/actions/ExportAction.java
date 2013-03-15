package de.jfract.gui.actions;

import de.jfract.gui.ExportFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * User: kesper
 * Date: 11.03.13
 * Time: 10:03
 */
public class ExportAction extends AbstractAction {
    public ExportAction() {
        super("Export ...");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ExportFrame frame = new ExportFrame();
        frame.setVisible(true);
    }
}
