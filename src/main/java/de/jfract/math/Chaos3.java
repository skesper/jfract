package de.jfract.math;

/**
 * User: sk
 * Date: 27.02.13
 * Time: 21:21
 */
public class Chaos3 extends Fractal {

    public Chaos3() {
        super(null, null);
    }

    public Chaos3(Complex startPoint, Complex fixPoint) {
        super(startPoint, fixPoint);
    }

    @Override
    protected Complex calc(Complex z, Complex c) {
        double zreal, zimag, creal, cimag;
        double areal, aimag, breal, bimag;
        double n, c1real, c1imag;

        creal = c.real();
        cimag = c.imaginary();

        zreal = z.real();
        zimag = z.imaginary();


        areal = zreal * zreal - zimag * zimag + creal;
        aimag = 2. * zreal + creal;
        breal = 2. * zreal * zimag + cimag;
        bimag = 2. * zimag + cimag;

        n = aimag * aimag + bimag * bimag;

        c1real = (areal * aimag + breal * bimag) / n;
//        c1imag = (-areal * bimag + aimag * breal) / n;
        c1imag = (aimag * breal-areal * bimag) / n;

        return new Complex(c1real * c1real - c1imag * c1imag,2. * c1real * c1imag);
    }

    @Override
    public UsageType getType() {
        return UsageType.START_POINT;
    }

    @Override
    public int getPreferredMaxIt() {
        return 2500;
    }

    @Override
    public Complex getPreferredStartPoint() {
        return new Complex(0.,0.);
    }

    @Override
    public Complex getPreferredFixPoint() {
        return null;
    }
}
