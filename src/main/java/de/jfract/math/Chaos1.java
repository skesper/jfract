package de.jfract.math;

public class Chaos1 extends Fractal {

    private Complex one = new Complex(1., 0.);

	public Chaos1() {
//        super(new Complex(0., 0.), null);
        super(new Complex(0., .6), null);
	}

	@Override
	protected Complex calc(Complex z, Complex c) {
		Complex zz = z.square().add(one);
		
		return zz.divide(c);
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
}
