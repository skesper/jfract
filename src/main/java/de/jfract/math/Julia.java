package de.jfract.math;


public class Julia extends Fractal {

    public Julia() {
        super(null, new Complex(-1.2,0.3));
    }

    public Julia(Complex fixPoint) {
        super(null, fixPoint);
    }

    @Override
	protected Complex calc(Complex z, Complex c) {
		return z.multiply(z).add(c);
	}

    @Override
    protected UsageType getType() {
        return UsageType.FIX_POINT;
    }
}
