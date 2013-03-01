package de.jfract.math;

import de.jfract.ApplicationContext;

import java.awt.Color;
import java.io.Serializable;

public class ColorModel implements Serializable {
	private int r;
	private int g;
	private int b;
	
	public ColorModel(int r, int g, int b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	public Color getColor(Result res) {
		switch(res.divergence) {
		case chaotic: 
			return Color.black;
			
		case convergent: {
            return get_color2(res.iteration);
		}
		
		case divergent: { 
            return get_color1(res.iteration);
		}
		}
		return Color.white;
	}

    private Color get_color1(int it) {
        double fac;

        double logfac = 0.6;

        fac = Math.PI + Math.log(it) / Math.log(logfac) * 2. * Math.PI / 5.;

        double shift0 = it / 300.; //_xwidth ;
        double shift1 = it / 500.; //_xwidth ;
        double shift2 = it / 800.; //_xwidth ;// */

        float r = (float) (128 * Math.sin(shift0 + fac)) + 128;
        float g = (float) (128 * Math.sin(shift1 + 1. / 3. * Math.PI + fac)) + 128;
        float bl = (float) (128 * Math.sin(shift2 + 2. / 3. * Math.PI + fac)) + 128;// */

//		Color c = new Color(bl/256.F,g/256.F,r/256.F,1.F);
        Color c = new Color(r / 256.F, g / 256.F, bl / 256.F, 1.F);

        return c;
    }

    private Color get_color2(int it) {
        double fac;

        double logfac = 0.6;

        fac = Math.log(it) / Math.log(logfac) * 2. * Math.PI / 5.;

        double shift0 = it / 30.; // _xwidth ;
        double shift1 = it / 80.; // _xwidth ;
        double shift2 = it / 50.; // _xwidth ;// */

        float r = (float) (0.5F * Math.sin(shift0 + fac)) + 0.5F;
        float g = (float) (0.5F * Math.sin(shift1 + 1. / 3. * Math.PI + fac)) + 0.5F;
        float bl = (float) (0.5F * Math.sin(shift2 + 2. / 3. * Math.PI + fac)) + 0.5F;

        Color c = new Color(r, g, bl, 1.F);

        return c;
    }

}
