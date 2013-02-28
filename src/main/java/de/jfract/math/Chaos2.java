package de.jfract.math;

public class Chaos2 extends Fractal {
	private static Complex one = new Complex(-2., 0.);

	public Chaos2() {
		super(null, one);
	}

	@Override
	protected Complex calc(Complex z, Complex c) {
		Complex zz = z.square().add(one);
		return zz.divide(z.add(c));
	}


    @Override
    protected UsageType getType() {
        return UsageType.NONE;
    }
}
