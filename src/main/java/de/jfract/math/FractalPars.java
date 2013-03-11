package de.jfract.math;


import de.jfract.math.color.DefaultModel;

import java.io.Serializable;

public class FractalPars implements Serializable {

    private static final long serialVersionUID = 123456789L;

    private ColorModel colorModel = new DefaultModel();
	private int maxx = 2000;
	private int maxy = 2000;
	private int maxit = 100;
	private Fractal fractal;
	private double d;
	private double d2;
	private double centerX = 0., centerY = 0.;

    public FractalPars() {
        setD(2.5);
    }

    public ColorModel getColorModel() {
		return colorModel;
	}
	public void setColorModel(ColorModel colorModel) {
		this.colorModel = colorModel;
	}
	public int getMaxx() {
		return maxx;
	}
	public void setMaxx(int maxx) {
		this.maxx = maxx;
	}
	public int getMaxy() {
		return maxy;
	}
	public void setMaxy(int maxy) {
		this.maxy = maxy;
	}
	public int getMaxit() {
		return maxit;
	}
	public void setMaxit(int maxit) {
		this.maxit = maxit;
	}
	public Fractal getFractal() {
		return fractal;
	}
	public void setFractal(Fractal f) {
		this.fractal = f;
	}
	public double getD() {
		return d;
	}
	public void setD(double d) {
		this.d = d;
        double aspect = ((double)maxx)/((double)maxy);
        d2 = d*aspect;
	}
	public double getD2() {
		return d2;
	}

	public double getCenterX() {
		return centerX;
	}
	public void setCenterX(double centerX) {
		this.centerX = centerX;
	}
	public double getCenterY() {
		return centerY;
	}
	public void setCenterY(double centerY) {
		this.centerY = centerY;
	}
	public Complex getStartPoint() {
		return fractal.getStartPoint();
	}
	public void setStartPoint(Complex startPoint) {
		this.fractal.setStartPoint(startPoint);
	}
	public Complex getFixPoint() {
		return fractal.getFixPoint();
	}
	public void setFixPoint(Complex fixPoint) {
		this.fractal.setFixPoint(fixPoint);
	}

    public void zoomIn(int x, int y, int width, int height) {

        pan(x,y,width,height);

        setD(d/4.);
        System.out.println("DEBUG: zoom: "+getD());
    }

    public void zoomOut(int x, int y, int width, int height) {
        setD(d*4.);
        System.out.println("DEBUG: zoom: "+getD());
    }

    public void pan(int x, int y, int width, int height) {
        double dx = (double)x;
        double dy = (double)y;
        double dw = (double)width;
        double dh = (double)height;

        double ux = centerX -d2/2.;
        double uy = centerY -d/2.;

        centerX = ux+d2*dx/dw;
        centerY = uy+d*dy/dh;

        System.out.println("DEBUG: center: ("+centerX+","+centerY+")");
    }

    @Override
    public FractalPars clone() throws CloneNotSupportedException {
        FractalPars clone = new FractalPars();
        clone.setMaxx(this.getMaxx());
        clone.setMaxy(this.getMaxy());
        clone.setMaxit(this.getMaxit());
        clone.setCenterX(this.getCenterX());
        clone.setStartPoint(this.getStartPoint());
        clone.setCenterY(this.getCenterY());
        clone.setColorModel(this.getColorModel());
        clone.setD(this.getD());
        clone.setFixPoint(this.getFixPoint());
        clone.setFractal(this.getFractal());
        return clone;
    }
}
