package de.jfract.gui.actions;

import de.jfract.ApplicationContext;
import de.jfract.math.FractalPars;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created with IntelliJ IDEA.
 * User: kesper
 * Date: 01.03.13
 * Time: 12:21
 * To change this template use File | Settings | File Templates.
 */
public class LoadAction extends AbstractAction {
    public LoadAction() {
        putValue(Action.NAME, "Load ...");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser ch = new JFileChooser(System.getProperty("user.dir"));
        ch.setFileFilter(new JfractFileFilter());
        if (ch.showOpenDialog(null) == JFileChooser.CANCEL_OPTION) return;

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(ch.getSelectedFile());
            ObjectInputStream ois = new ObjectInputStream(fis);
            FractalPars fp = (FractalPars)ois.readObject();
            ois.close();
            fis.close();
            ApplicationContext.getInstance().setFractalParameters(fp);
            ApplicationContext.getInstance().recalculate();
        } catch (Exception e1) {
            e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}
