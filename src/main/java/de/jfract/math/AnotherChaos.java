package de.jfract.math;

/**
 * User: kesper
 * Date: 15.03.13
 * Time: 14:48
 */
public class AnotherChaos extends Fractal {
    private Complex pi = new Complex(Math.PI, 0.);
    @Override
    protected Complex calc(Complex z, Complex c, Complex result) {
        double d = Math.sqrt(z.real()*z.real()+z.imaginary()*z.imaginary());
        double a = d*Math.sin(z.real());
        double b = d*Math.cos(z.imaginary());
        result.set(
                a*a-b*b+c.real(),
                2.*a*b+c.imaginary()
        );
        return result;
    }
    @Override
    public UsageType getType() {
        return UsageType.NONE;
    }

    @Override
    public int getPreferredMaxIt() {
        return 100;
    }

    @Override
    public Complex getPreferredStartPoint() {
        return null;
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
        return "Another Chaos";
    }
}
