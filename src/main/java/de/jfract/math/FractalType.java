package de.jfract.math;

/**
 * Created with IntelliJ IDEA.
 * User: kesper
 * Date: 22.02.13
 * Time: 15:50
 * To change this template use File | Settings | File Templates.
 */
public enum FractalType {

    MANDEL("Mandelbrot", Mandel.class),
    JULIA("Julia", Julia.class),
    CHAOS1("Chaotic Model 1", Chaos1.class),
    CHAOS2("Chaotic Model 2", Chaos2.class),
    CHAOS3("Chaotic Model 3", Chaos3.class),
    LOTKA("Lotka Volterra", Lotka.class)
    ;

    private String label;
    private Class<? extends Fractal> impl;

    private FractalType(String label, Class<? extends Fractal> impl) {
        this.label = label;
        this.impl = impl;
    }

    public String getLabel() {
        return label;
    }

    public Class<? extends Fractal> getImplementation() {
        return impl;
    }

    @Override
    public String toString() {
        return label;
    }
}
