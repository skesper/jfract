package de.jfract.math;

import java.awt.Graphics2D;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Worker implements Runnable {

	private int maxx;
	private int maxy;
	private int maxit;
	private Fractal f;
	private ColorModel cm;
	private double d;
	private double d2;
	private double ulx, uly;
    private ColumnSynchronizer cs;
	private CyclicBarrier cb;
    private DrawingQueue dq;


    public Worker(ColumnSynchronizer cs, DrawingQueue dq, CyclicBarrier cb, FractalPars fp) {
        this.maxx = fp.getMaxx();
        this.maxy = fp.getMaxy();
        this.maxit = fp.getMaxit();
        this.f = fp.getFractal();
        this.dq = dq;
        this.cm = fp.getColorModel();
        this.d = fp.getD();
        this.cb = cb;
        this.cs = cs;
        double aspect = ((double)maxx)/((double)maxy);
        d2 = d*aspect;

        // Obere linke Ecke
        ulx = fp.getCenterX()-d2/2.;
        uly = fp.getCenterY()-d/2.;

    }
	
	@Override
	public void run() {
        Thread me = Thread.currentThread();
        while(true) {
            if (me.isInterrupted()) break;
            int i = cs.getNextColumn();
            if (i<0) break;

			double x = ulx+d2*((double)i)/maxx;
			for(int j=0;j<maxy;++j) {
				double y = uly+d*((double)j)/maxy;
				Complex c = new Complex(x, y);
				Result r = f.calc(c, maxit);
                dq.set(i,j,cm.getColor(r));
			}
		}
		
		if (cb!=null) {
			try {
				cb.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
