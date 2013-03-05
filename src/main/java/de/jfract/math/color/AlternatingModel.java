package de.jfract.math.color;

import de.jfract.math.ColorModel;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: kesper
 * Date: 05.03.13
 * Time: 15:38
 * To change this template use File | Settings | File Templates.
 */
public class AlternatingModel extends ColorModel {

    public AlternatingModel() {
        super(0,0,0,0,0,0);
    }

    public AlternatingModel(double rconv, double gconv, double bconv, double rdiv, double gdiv, double bdiv) {
        super(rconv, gconv, bconv, rdiv, gdiv, bdiv);
    }

    @Override
    protected Color getConvergentColor(int it) {
        double itd = Math.log(it);
        float col = 0.5F+0.5F*(float)Math.sin(itd);
        return new Color(col,col,col,1.F);
    }

    @Override
    protected Color getDivergentColor(int it) {
        return it%2==0 ? Color.WHITE : Color.BLACK;
    }

    @Override
    public String toString() {
        return "Alternating B/W Model";
    }
}
