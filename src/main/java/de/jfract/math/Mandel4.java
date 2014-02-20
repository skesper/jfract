package de.jfract.math;

/**
 * User: Kesper
 * Date: 22.01.14
 * Time: 11:33
 */
public class Mandel4 extends Fractal {

    private static final long serialVersionUID = 8303601425014270360L;

    public Mandel4() {
    }

    @Override
    protected Complex calc(Complex z, Complex c, Complex result) {
        Complex zz = z.multiply(z);
        zz = zz.multiply(zz);
        zz = zz.multiply(zz);
        zz.multiply(zz).add(c, result);
        return result;
    }

    @Override
    public UsageType getType() {
        return UsageType.START_POINT;
    }

    @Override
    public int getPreferredMaxIt() {
        return 1000;
    }

    @Override
    public Complex getPreferredStartPoint() {
        return new Complex(0,0);
    }

    @Override
    public Complex getPreferredFixPoint() {
        return null;
    }

    @Override
    public Complex getPreferredCenterPoint() {
        return new Complex(0.,0.);
    }

    @Override
    public double getPreferredD() {
        return 2.5;
    }

    @Override
    public String toString() {
        return "Mandelbrot^16 Set";
    }
}

