package de.jfract.math;


public class Julia extends Fractal {

    public Julia() {
    }


    @Override
	protected Complex calc(Complex z, Complex c) {
		return z.multiply(z).add(c);
	}

    @Override
    public UsageType getType() {
        return UsageType.FIX_POINT;
    }

    @Override
    public int getPreferredMaxIt() {
        return 2000;
    }

    @Override
    public Complex getPreferredStartPoint() {
        return null;
    }

    @Override
    public Complex getPreferredFixPoint() {
        return new Complex(-1.2,0.155);
    }

    @Override
    public double getPreferredD() {
        return 2.5;
    }
}
