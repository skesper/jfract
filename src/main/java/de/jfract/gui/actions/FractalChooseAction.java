package de.jfract.gui.actions;

import de.jfract.ApplicationContext;
import de.jfract.math.Fractal;
import de.jfract.math.FractalPars;
import de.jfract.math.FractalType;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created with IntelliJ IDEA.
 * User: kesper
 * Date: 22.02.13
 * Time: 15:50
 * To change this template use File | Settings | File Templates.
 */
public class FractalChooseAction extends AbstractAction {

    private Fractal fractal = null;

    public FractalChooseAction(Fractal fractal) {
        this.fractal = fractal;
        this.putValue(AbstractAction.NAME, fractal.toString());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            FractalPars fp = new FractalPars();
            fp.setFractal(fractal);
            fp.setMaxit(fractal.getPreferredMaxIt());
            fp.setStartPoint(fractal.getPreferredStartPoint());
            fp.setFixPoint(fractal.getPreferredFixPoint());
            fp.setD(fractal.getPreferredD());

            ApplicationContext.getInstance().setFractalParameters(fp);
        } catch (Exception e1) {
            e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            JOptionPane.showConfirmDialog(ApplicationContext.getInstance().getMainFrame(), "ERROR", e1.getMessage(), JOptionPane.ERROR_MESSAGE);
        }

        ApplicationContext.getInstance().recalculate();
    }
}
