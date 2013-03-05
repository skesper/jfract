package de.jfract.gui.actions;

import de.jfract.ApplicationContext;
import de.jfract.gui.ConfirmDialogs;
import de.jfract.math.ColorModel;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created with IntelliJ IDEA.
 * User: kesper
 * Date: 05.03.13
 * Time: 15:52
 * To change this template use File | Settings | File Templates.
 */
public class SelectColorModelAction extends AbstractAction {

    public SelectColorModelAction() {
        putValue(AbstractAction.NAME, "Select Color Model ...");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        ColorModel model = ApplicationContext.getInstance().getFractalParameters().getColorModel();

        model = ConfirmDialogs.showColorModelSelect(model);

        if (model!=null) {
            ApplicationContext.getInstance().getFractalParameters().setColorModel(model);
            ApplicationContext.getInstance().recalculate();
        }
    }
}
