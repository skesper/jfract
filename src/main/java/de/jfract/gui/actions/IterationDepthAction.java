package de.jfract.gui.actions;

import de.jfract.ApplicationContext;
import de.jfract.gui.ConfirmDialogs;
import de.jfract.math.FractalPars;

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
        FractalPars fp = ApplicationContext.getInstance().getFractalParameters();
        if (fp==null || fp.getFractal()==null) {
            ConfirmDialogs.showError("You must select a fractal first!");
            return;
        }

        String result = ConfirmDialogs.showInput("Iteration depth",
                ""+fp.getMaxit());

        if (result!=null) {
            try {
                int it = Integer.parseInt(result);
                fp.setMaxit(it);
                ApplicationContext.getInstance().recalculate();
            } catch(NumberFormatException nfe) {
                ConfirmDialogs.showError("The number "+result+" could not be parsed");
            }
        }
    }
}
