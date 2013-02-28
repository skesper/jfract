package de.jfract.math;

import java.awt.Color;

public class ColorModel {
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
			double rit = 127.+127.*Math.cos(Math.log10(r*(double)res.iteration));
			double git = 127.+127.*Math.cos(Math.log10(g*(double)res.iteration));
			double bit = 127.+127.*Math.cos(Math.log10(b*(double)res.iteration));
			int cr = ((int)(rit))%256;
			int cg = ((int)(git))%256;
			int cb = ((int)(bit))%256;
			return new Color(cr,cg,cb);
		}
		
		case divergent: { 
			double rit = 127.+127.*Math.sin(Math.log(r+r*(double)res.iteration));
			double git = 127.+127.*Math.sin(Math.log(g+g*(double)res.iteration));
			double bit = 127.+127.*Math.sin(Math.log(b+b*(double)res.iteration));
			int cr = ((int)(rit))%256;
			int cg = ((int)(git))%256;
			int cb = ((int)(bit))%256;
			return new Color(cr,cg,cb);
		}
		}
		return Color.white;
	}
}
