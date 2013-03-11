package de.jfract.math;

public class Chaos1 extends Fractal {

    private static final long serialVersionUID = -6956379302323843340L;

    private Complex one = new Complex(1., 0.);

	public Chaos1() {
	}

	@Override
	protected Complex calc(Complex z, Complex c, Complex result) {
		Complex zz = z.square().add(one);

        Complex zzc = zz.divide(c);
        result.set(zzc.real(), zzc.imaginary());
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
        return new Complex(0., .6);
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
