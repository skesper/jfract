package de.jfract.gui;

import de.jfract.gui.actions.*;
import de.jfract.math.FractalType;

import javax.swing.*;

/**
 * User: kesper
 * Date: 22.02.13
 * Time: 15:24
 */
public class GuiStaticCreator {

    public static JMenuBar createMenu() {
        JMenuBar bar = new JMenuBar();

        JMenu file = new JMenu("File");
        file.add(new LoadAction());
        file.add(new SaveAction());
        file.add(new JSeparator());
        file.add(new ExportAction());
        file.add(new JSeparator());
        file.add(new ExitAction());
        bar.add(file);

        JMenu sett = new JMenu("Settings");
        sett.add(new IterationDepthAction());
        sett.add(new ParameterAction());
        sett.add(new SelectColorModelAction());
        bar.add(sett);

        JMenu frac = new JMenu("Fractals");

        for(FractalType ft : FractalType.values()) {
            frac.add(new FractalChooseAction(ft));
        }

        frac.add(new JSeparator());
        frac.add(new CalculateAction());

        bar.add(frac);

        return bar;
    }
}
