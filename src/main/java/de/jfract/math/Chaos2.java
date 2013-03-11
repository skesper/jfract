package de.jfract.math;

public class Chaos2 extends Fractal {
    private static final long serialVersionUID = 8166937600676697635L;
    private static Complex one = new Complex(-2., 0.);

	public Chaos2() {
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
        aimag = 3. * zreal + creal;
        breal = 2. * zreal * zimag + cimag;
        bimag = 3. * zimag + cimag;

        n = aimag * aimag + bimag * bimag;

        c1real = (areal * aimag+breal * bimag) / n;
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
        return 1000;
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
    public double getPreferredD() {
        return 10.;
    }
}
