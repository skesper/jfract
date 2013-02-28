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

    private FractalType type = null;

    public FractalChooseAction(FractalType fractalType) {
        this.type = fractalType;
        this.putValue(AbstractAction.NAME, fractalType.getLabel());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            Fractal fractal = type.getImplementation().newInstance();
            FractalPars fp = new FractalPars();
            fp.setFractal(fractal);
            ApplicationContext.getInstance().setFractalParameters(fp);
        } catch (Exception e1) {
            e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            JOptionPane.showConfirmDialog(ApplicationContext.getInstance().getMainFrame(), "ERROR", e1.getMessage(), JOptionPane.ERROR_MESSAGE);
        }

        ApplicationContext.getInstance().recalculate();
    }
}
