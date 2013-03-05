package de.jfract.math;

import java.awt.Color;
import java.io.Serializable;

public abstract class ColorModel implements Serializable {
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

    protected abstract Color getDivergentColor(int it);

    protected abstract Color getConvergentColor(int it);
}
