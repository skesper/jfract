package de.jfract.math;

/**
 * User: sk
 * Date: 27.02.13
 * Time: 21:21
 */
public class ConvergenceDivergence extends Fractal {

    private static final long serialVersionUID = 1317976087112039454L;

    public ConvergenceDivergence() {
    }


    @Override
    protected Complex calc(Complex z, Complex c, Complex result) {
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

        result.set(c1real * c1real - c1imag * c1imag,2. * c1real * c1imag);
        return result;
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

    @Override
    public Complex getPreferredCenterPoint() {
        return new Complex(-3.,0.);
    }

    @Override
    public double getPreferredD() {
        return 10.;
    }

    @Override
    public String toString() {
        return "Convergence Divergence";
    }
}
