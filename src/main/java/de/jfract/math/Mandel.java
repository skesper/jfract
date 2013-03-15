package de.jfract.math;


public class Mandel extends Fractal {

    private static final long serialVersionUID = 8303601425014270359L;

    public Mandel() {
	}

	@Override
	protected Complex calc(Complex z, Complex c, Complex result) {
        z.multiply(z).add(c, result);
		return result;
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
    public Complex getPreferredCenterPoint() {
        return new Complex(-0.75,0.);
    }

    @Override
    public double getPreferredD() {
        return 2.5;
    }

    @Override
    public String toString() {
        return "Mandelbrot Set";
    }
}
