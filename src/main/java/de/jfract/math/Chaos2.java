package de.jfract.math;

public class Chaos2 extends Fractal {
	private static Complex one = new Complex(-2., 0.);

	public Chaos2() {
	}

	@Override
	protected Complex calc(Complex z, Complex c) {
		Complex zz = z.square().add(one);
		return zz.divide(z.add(c));
	}


    @Override
    public UsageType getType() {
        return UsageType.NONE;
    }

    @Override
    public int getPreferredMaxIt() {
        return 1000;
    }

    @Override
    public Complex getPreferredStartPoint() {
        return null;
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
