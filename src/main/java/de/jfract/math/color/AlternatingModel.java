package de.jfract.math.color;

import de.jfract.math.ColorModel;

import java.awt.*;

/**
 * User: kesper
 * Date: 05.03.13
 * Time: 15:38
 */
public class AlternatingModel extends ColorModel {
    private static final double logfac = Math.log(0.6);

    public AlternatingModel() {
        super(0,0,0,0,0,0);
    }

    @Override
    protected Color getConvergentColor(int it) {
        double itd = Math.log(it);
        float col = 0.5F+0.5F*(float)Math.sin(itd);
        return new Color(col,col,col,1.F);
    }

    @Override
    protected Color getDivergentColor(int it) {

        int logit = (int)(Math.log(it) / logfac);

        return logit%2==0 ? Color.WHITE : Color.BLACK;
    }

    @Override
    public String toString() {
        return "Alternating B/W Model";
    }
}
