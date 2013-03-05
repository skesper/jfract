package de.jfract.math.color;

import de.jfract.math.ColorModel;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: kesper
 * Date: 05.03.13
 * Time: 15:32
 * To change this template use File | Settings | File Templates.
 */
public class SimpleGreyModel extends ColorModel {

    public SimpleGreyModel() {
        super(50,50,50,300,500,800);
    }

    public SimpleGreyModel(double rconv, double gconv, double bconv, double rdiv, double gdiv, double bdiv) {
        super(rconv, gconv, bconv, rdiv, gdiv, bdiv);
    }

    protected Color getDivergentColor(int it) {
        double fac;

        double logfac = 0.6;

        fac = Math.PI + Math.log(it) / Math.log(logfac) * 2. * Math.PI / 5.;

        double shift0 = it / rdiv; //_xwidth ;
        double shift1 = it / gdiv; //_xwidth ;
        double shift2 = it / bdiv; //_xwidth ;// */

        float r = (float) (128 * Math.sin(shift0 + fac)) + 128;
        float g = (float) (128 * Math.sin(shift1 + fac)) + 128;
        float bl = (float) (128 * Math.sin(shift2 + fac)) + 128;// */
//        float r = (float) (128 * Math.sin(shift0 + fac)) + 128;
//        float g = (float) (128 * Math.sin(shift1 + 1. / 3. * Math.PI + fac)) + 128;
//        float bl = (float) (128 * Math.sin(shift2 + 2. / 3. * Math.PI + fac)) + 128;// */

//		Color c = new Color(bl/256.F,g/256.F,r/256.F,1.F);
        Color c = new Color(r / 256.F, g / 256.F, bl / 256.F, 1.F);

        return c;
    }

    protected Color getConvergentColor(int it) {
        double fac;

        double logfac = 0.6;

        fac = Math.log(it) / Math.log(logfac) * 2. * Math.PI / 5.;

        double shift0 = it / rconv; // _xwidth ;
        double shift1 = it / gconv; // _xwidth ;
        double shift2 = it / bconv; // _xwidth ;// */

        float r = (float) (0.5F * Math.sin(shift0 + fac)) + 0.5F;
        float g = (float) (0.5F * Math.sin(shift1 + fac)) + 0.5F;
        float bl = (float) (0.5F * Math.sin(shift2 + fac)) + 0.5F;
//        float r = (float) (0.5F * Math.sin(shift0 + fac)) + 0.5F;
//        float g = (float) (0.5F * Math.sin(shift1 + 1. / 3. * Math.PI + fac)) + 0.5F;
//        float bl = (float) (0.5F * Math.sin(shift2 + 2. / 3. * Math.PI + fac)) + 0.5F;

        Color c = new Color(r, g, bl, 1.F);

        return c;
    }


    @Override
    public String toString() {
        return "Chilled mostly grey Model";
    }
}
