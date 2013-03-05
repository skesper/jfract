package de.jfract.gui;

import de.jfract.ApplicationContext;
import de.jfract.math.ColorModel;
import de.jfract.math.color.AlternatingModel;
import de.jfract.math.color.DefaultModel;
import de.jfract.math.color.SimpleGreyModel;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: kesper
 * Date: 05.03.13
 * Time: 14:14
 * To change this template use File | Settings | File Templates.
 */
public class ConfirmDialogs {

    public static void showError(String msg) {
        JOptionPane.showConfirmDialog(ApplicationContext.getInstance().getMainFrame(), msg, "ERROR", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
    }

    public static String showInput(String msg, String value) {
        String result = JOptionPane.showInputDialog(
                ApplicationContext.getInstance().getMainFrame(),
                msg,
                value);
        return result;
    }

    private static final ColorModel[] COLOR_MODELS = new ColorModel[]{
            new DefaultModel(),
            new SimpleGreyModel(),
            new AlternatingModel()
    };

    public static ColorModel showColorModelSelect(ColorModel selectedModel) {
        ColorModel selected = (ColorModel)JOptionPane.showInputDialog(
                ApplicationContext.getInstance().getMainFrame(),
                "Select the color model",
                "Color Model",
                JOptionPane.QUESTION_MESSAGE,
                null,
                COLOR_MODELS,
                selectedModel==null ? COLOR_MODELS[0] : selectedModel);

        return selected;
    }
}
