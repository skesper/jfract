package de.jfract.math;

/**
 * Created with IntelliJ IDEA.
 * User: sk
 * Date: 27.02.13
 * Time: 21:21
 * To change this template use File | Settings | File Templates.
 */
public class Chaos3 extends Fractal {

    public Chaos3() {
        super(new Complex(-2.,0), new Complex(0,0));
    }

    public Chaos3(Complex startPoint, Complex fixPoint) {
        super(startPoint, fixPoint);
    }

    @Override
    protected Complex calc(Complex z, Complex c) {
        double a, b, cc, d;
        double a1, a2, b1, b2;
        double n, c1, c2;

        cc = c.real();
        d = c.imaginary();

        a = z.real();
        b = z.imaginary();


        a1 = a * a - b * b + cc;
        a2 = 2. * a + cc;
        b1 = 2. * a * b + d;
        b2 = 2. * b + d;

        n = a2 * a2 + b2 * b2;

        c1 = (a1 * a2 + b1 * b2) / n;
        c2 = (-a1 * b2 + a2 * b1) / n;

        return new Complex(c1 * c1 - c2 * c2,2. * c1 * c2);
    }

    @Override
    protected UsageType getType() {
        return UsageType.NONE;
    }
}
