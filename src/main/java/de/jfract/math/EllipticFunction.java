package de.jfract.math;

/**
 * User: kesper
 * Date: 05.04.13
 * Time: 16:06
 */
public class EllipticFunction extends Fractal {

    private Complex start = new Complex(-2.5,0.);


    @Override
    protected Complex calc(Complex z, Complex c, Complex result) {

        // (c*z^2+b)/(a*z+d)
//        Complex z2 = z.multiply(z);
//        Complex q = c.multiply(z2).add(b).divide(a.multiply(z).add(d));

        // (c*z^2+z)/(z^2+z)
        Complex z2 = z.multiply(z);
        Complex q = z2.multiply(c).add(z).divide(c.add(z));

        result.set(q.real(), q.imaginary());
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
        return start;
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
        return "Elliptic Function";
    }
}
