package de.jfract.math;


public class Julia extends Fractal {

    private static final long serialVersionUID = 4056896094058649853L;

    public Julia() {
    }


    @Override
	protected Complex calc(Complex z, Complex c, Complex result) {
		result.set(z.multiply(z).add(c));
        return result;
	}

    @Override
    public UsageType getType() {
        return UsageType.FIX_POINT;
    }

    @Override
    public int getPreferredMaxIt() {
        return 200;
    }

    @Override
    public Complex getPreferredStartPoint() {
        return null;
    }

    @Override
    public Complex getPreferredFixPoint() {
        return new Complex(-1.2,0.3);
    }

    @Override
    public double getPreferredD() {
        return 2.5;
    }
}
