package de.jfract.math;

/**
 * User: kesper
 * Date: 12.03.13
 * Time: 14:14
 */
public class TripleHeadedDude extends Fractal {

    private static final long serialVersionUID = 1987907579514148L;

    @Override
    protected Complex calc(Complex z, Complex c, Complex result) {
        // z^2*(z+c)+c = z^3+c*z^2+c
        // z^3+c*z^2+c^2*z+c^3
        Complex z2 = z.multiply(z);
        Complex z3 = z2.multiply(z);
//        Complex c2 = c.multiply(c);
//        Complex c3 = c2.multiply(c);

        z3.add(z2).add(z).add(c, result);
        return result;
    }

    @Override
    public UsageType getType() {
        return UsageType.START_POINT;
    }

    @Override
    public int getPreferredMaxIt() {
        return 2000;
    }

    @Override
    public Complex getPreferredStartPoint() {
        return new Complex(0.,0.);
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
        return 10.;
    }

    @Override
    public String toString() {
        return "Triple Headed Dude";
    }
}
