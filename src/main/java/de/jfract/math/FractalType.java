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
        fractals.add(new Chaos1());
        fractals.add(new Chaos2());
        fractals.add(new Chaos3());
        fractals.add(new Chaos4());
        fractals.add(new Lotka());

        return fractals;
    }
}
