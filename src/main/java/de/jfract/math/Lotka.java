package de.jfract.math;

public class Lotka extends Fractal {
    private static final long serialVersionUID = 3064642858133868768L;
    private double a,b,c,d, dt;

    public Lotka() {
        this.a = 0.1;
        this.b = 1.4;
        this.c = 0.3;
        this.d = 0.1;
        this.dt = 0.5;
    }

	@Override
	protected Complex calc(Complex z, Complex cc, Complex result) {
		double N = z.real();
		double P = z.imaginary();
		
		result.set(N+dt*N*(a-b*P), P+dt*P*(c*N-d));
		return result;
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
        return 25.;
    }

    @Override
    public String toString() {
       return "Lotka Volterra";
    }
}
