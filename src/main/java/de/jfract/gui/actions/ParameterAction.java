package de.jfract.gui.actions;

import de.jfract.ApplicationContext;
import de.jfract.gui.ConfirmDialogs;
import de.jfract.gui.ParameterFrame;
import de.jfract.math.FractalPars;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created with IntelliJ IDEA.
 * User: kesper
 * Date: 26.02.13
 * Time: 09:31
 * To change this template use File | Settings | File Templates.
 */
public class ParameterAction extends AbstractAction {
    public ParameterAction() {
        putValue(AbstractAction.NAME, "Parameters ...");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ParameterFrame pf = new ParameterFrame();
        pf.setTitle("Parameter");
        FractalPars fp = ApplicationContext.getInstance().getFractalParameters();
        if (fp==null || fp.getFractal()==null) {
            ConfirmDialogs.showError("You must select a fractal first!");
            return;
        }
        pf.setFixPoint(fp.getFixPoint());
        pf.setStartPoint(fp.getStartPoint());
        pf.setIterations(fp.getMaxit());

        pf.setVisible(true);
    }
}
