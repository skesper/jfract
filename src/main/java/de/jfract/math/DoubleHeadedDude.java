package de.jfract.math;

/**
 * User: kesper
 * Date: 12.03.13
 * Time: 14:14
 */
public class DoubleHeadedDude extends Fractal {

    private static final long serialVersionUID = 1987907579514148L;

    @Override
    protected Complex calc(Complex z, Complex c, Complex result) {
        // z^2*(z+c)+c = z^3+c*z^2+c
        z.multiply(z.add(c)).multiply(z).add(c, result);
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
        return new Complex(-0.07354560438236997,-0.9010456183611532);
    }

    @Override
    public double getPreferredD() {
        return 0.078125;
    }

    @Override
    public String toString() {
        return "Double Headed Dude";
    }
}
