package de.jfract.math;


public class Mandel extends Fractal {

	public Mandel() {
	}

	@Override
	protected Complex calc(Complex z, Complex c) {
		return z.multiply(z).add(c);
	}

    @Override
    public UsageType getType() {
        return UsageType.START_POINT;
    }

    @Override
    public int getPreferredMaxIt() {
        return 100;
    }

    @Override
    public Complex getPreferredStartPoint() {
        return new Complex(0,0);
    }

    @Override
    public Complex getPreferredFixPoint() {
        return null;
    }

    @Override
    public double getPreferredD() {
        return 2.5;
    }
}
