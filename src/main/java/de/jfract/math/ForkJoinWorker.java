package de.jfract.math;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.concurrent.RecursiveTask;

public class ForkJoinWorker extends RecursiveTask<Color> {

	private static final long serialVersionUID = -3459445990754784104L;

	private FractalPars pars;
	private int columnToCompute;
	private Graphics2D g;

	public ForkJoinWorker(FractalPars pars, Graphics2D g, int columnToCompute) {
		this.columnToCompute = columnToCompute;
		this.pars = pars;
		this.g = g;
	}
	
	@Override
	protected Color compute() {
		double x = pars.getCenterX()+pars.getD2()*((double)columnToCompute)/pars.getMaxx();
		double uly = pars.getCenterY();
		double d = pars.getD();
		int maxy = pars.getMaxy();
		Fractal f = pars.getFractal();
		int maxit = pars.getMaxit();
		ColorModel cm = pars.getColorModel();
		for(int j=0;j<pars.getMaxy();++j) {
			double y = uly+d*((double)j)/maxy;
			Complex c = new Complex(x, y);
			Result r = f.calc(c, maxit);
			g.setColor(cm.getColor(r));
			g.drawLine(columnToCompute, j, columnToCompute, j);
		}
		return null;
	}

	public Result calc(Complex c, int maxit) {
		Result r = new Result();
		
		Complex z0=pars.getStartPoint()==null ? c : pars.getStartPoint();
		
		Complex z1=new Complex(c.real()-10000., c.imaginary());
		Complex d;
		Complex e = pars.getFixPoint() == null ? c : pars.getFixPoint();
		r.divergence = null;
        Complex result = new Complex();
		for(int i=0;i<maxit;++i) {
			z0 = pars.getFractal().calc(z0, e, result);
			if (z0.abs()>2.) {
				r.iteration = i;
				r.divergence = Divergence.divergent;
				break;
			}
			d = z0.subtract(z1);
			if (d.abs()<1.E-10) {
				r.divergence = Divergence.convergent;
				r.iteration = i;
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
	
}
