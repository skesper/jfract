package de.jfract.math;

import java.io.Serializable;

public abstract class Fractal implements Serializable {
	private Complex startPoint = null;
	private Complex fixPoint = null;
	
	public Fractal(Complex startPoint, Complex fixPoint) {
		this.startPoint = startPoint;
		this.fixPoint = fixPoint;
	}
	
	public Result calc(Complex c, int maxit) {
		Result r = new Result();
		
		Complex z0=c;
        if (getType()==UsageType.START_POINT || getType()==UsageType.BOTH) {
            z0 = startPoint;
        } // */

//        Complex z1=new Complex(c.real()-10000., c.imaginary());
        Complex z1=new Complex(0,0);
		Complex d;
		Complex e;
        if (getType()==UsageType.FIX_POINT || getType()==UsageType.BOTH) {
            e = fixPoint;
        } else {
            e = c;
        }

		r.divergence = null;
		for(int i=0;i<maxit;++i) {
			z0 = calc(z0, e);
			d = z0.subtract(z1);
			if (d.abs()<1.E-12) {
				r.iteration = i;
                r.divergence = Divergence.convergent;
				break;
			}
            if (z0.abs2()>1.e+10) {
                r.iteration = i;
                r.divergence = Divergence.divergent;
                break;
            }
			z1 = z0;
		}

		if (r.divergence==null) {
			r.divergence = Divergence.chaotic;
			r.iteration = 0;
		}
		
		return r;
	}

    public Complex getFixPoint() {
        return fixPoint;
    }

    public void setFixPoint(Complex fixPoint) {
        this.fixPoint = fixPoint;
    }

    public Complex getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Complex startPoint) {
        this.startPoint = startPoint;
    }

    /**
	 * Berechnet 
	 * z_{t+1} := f(z_{t}, c)
	 * @param z
	 * @param c
	 * @return
	 */
	protected abstract Complex calc(Complex z, Complex c);

    public abstract UsageType getType();

    public abstract int getPreferredMaxIt();

    public abstract Complex getPreferredStartPoint();

    public abstract Complex getPreferredFixPoint();

    public enum UsageType {
        NONE,
        FIX_POINT,
        START_POINT,
        BOTH
    }
}
