package de.jfract.math;


public class Mandel extends Fractal {

	public Mandel() {
		super(null, null);
	}

	@Override
	protected Complex calc(Complex z, Complex c) {
		return z.multiply(z).add(c);
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
}
