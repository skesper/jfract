package de.jfract.math;

import java.util.ArrayList;
import java.util.List;

/**
 * User: kesper
 * Date: 22.02.13
 * Time: 15:50
 */
public class FractalType {

    public static List<Fractal> getFractals() {
        ArrayList<Fractal> fractals = new ArrayList<Fractal>();

        fractals.add(new Mandel());
        fractals.add(new Julia());
        fractals.add(new TheEyeOfTheBeast());
        fractals.add(new ConvergenceDivergence());
        fractals.add(new ConvergenceDivergenceTwo());
        fractals.add(new CircularImpression());
        fractals.add(new DoubleHeadedDude());
        fractals.add(new TripleHeadedDude());
        fractals.add(new Lotka());

        return fractals;
    }
}
