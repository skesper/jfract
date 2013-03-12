package de.jfract.math;

/**
 * User: sk
 * Date: 3/4/13
 * Time: 4:32 PM
 */
public class Chaos4 extends Fractal {

    private static final long serialVersionUID = 3765221945314388687L;

    public Chaos4() {
    }

    @Override
    protected Complex calc(Complex z, Complex c, Complex result) {

//        Complex a = new Complex(
//                z.real()*z.real()-z.imaginary()*z.imaginary()+c.real(),
//                2.*z.real()+c.real());
//
//        Complex b = new Complex(
//                2.*z.real()*z.imaginary()+c.imaginary(),
//                2.*z.imaginary()+c.imaginary());


        // ((z^2+c)/(z+c))^2
        Complex z2 = z.multiply(z);

        Complex a = z2.add(c);
        Complex b = z.add(c);

        Complex c2 = a.divide(b);
        Complex c3 = c2.multiply(c2);
        result.set(c3);
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
        return new Complex(-1.e-9,0.);
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
        return "Chaotic Model 4";
    }
}
