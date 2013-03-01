package de.jfract.math;

public class Lotka extends Fractal {
	private double a,b,c,d, dt;

    public Lotka() {
        super(null, new Complex(1, 2));
        this.a = 0.1;
        this.b = 1.4;
        this.c = 0.3;
        this.d = 0.1;
        this.dt = 0.5;
    }

	public Lotka(double a, double b, double c, double d, double dt) {
		super(null, new Complex(1, 2));
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.dt = dt;
	}

	@Override
	protected Complex calc(Complex z, Complex cc) {
		double N = z.real();
		double P = z.imaginary();
		
		Complex e = new Complex(N+dt*N*(a-b*P), P+dt*P*(c*N-d));
		return e;
	}

    @Override
    protected UsageType getType() {
        return UsageType.NONE;
    }
}
