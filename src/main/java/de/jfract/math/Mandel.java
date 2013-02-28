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
    protected UsageType getType() {
        return UsageType.NONE;
    }
}
