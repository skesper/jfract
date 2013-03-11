package de.jfract.math;

import java.awt.Color;
import java.io.Serializable;

public abstract class ColorModel implements Serializable {

    private static final long serialVersionUID = 41151373813827556L;

    protected double rconv;
    protected double gconv;
    protected double bconv;
    protected double rdiv;
    protected double gdiv;
    protected double bdiv;

    // 30,80,50,300,500,800
    public ColorModel(double rconv, double gconv, double bconv, double rdiv, double gdiv, double bdiv) {
        this.rconv = rconv;
        this.gconv = gconv;
        this.bconv = bconv;
        this.rdiv = rdiv;
        this.gdiv = gdiv;
        this.bdiv = bdiv;

    }

	public Color getColor(Result res) {
		switch(res.divergence) {
		case chaotic: 
			return Color.black;
			
		case convergent: {
            return getConvergentColor(res.iteration);
		}
		
		case divergent: { 
            return getDivergentColor(res.iteration);
		}
		}
		return Color.white;
	}

    public double getBconv() {
        return bconv;
    }

    public void setBconv(double bconv) {
        this.bconv = bconv;
    }

    public double getBdiv() {
        return bdiv;
    }

    public void setBdiv(double bdiv) {
        this.bdiv = bdiv;
    }

    public double getGconv() {
        return gconv;
    }

    public void setGconv(double gconv) {
        this.gconv = gconv;
    }

    public double getGdiv() {
        return gdiv;
    }

    public void setGdiv(double gdiv) {
        this.gdiv = gdiv;
    }

    public double getRconv() {
        return rconv;
    }

    public void setRconv(double rconv) {
        this.rconv = rconv;
    }

    public double getRdiv() {
        return rdiv;
    }

    public void setRdiv(double rdiv) {
        this.rdiv = rdiv;
    }

    protected abstract Color getDivergentColor(int it);

    protected abstract Color getConvergentColor(int it);
}
