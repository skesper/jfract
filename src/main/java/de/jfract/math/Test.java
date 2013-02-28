package de.jfract.math;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.CyclicBarrier;

import javax.imageio.ImageIO;

public class Test {
	public static void main(String[] args) throws Exception {
		
		int maxx = 2000;
		int maxy = 2000;
		BufferedImage bi = new BufferedImage(maxx, maxy, BufferedImage.TYPE_INT_RGB);
		
//		Fractal fractal = new Mandel();
//		double d = 0.01;
//		double mx = -0.65;
//		double my = 0.41;


		Fractal fractal = new Julia(new Complex(-0.72, 0.2));
		double d = .02;
		double mx = 0.;
		double my = 0.;

//		Fractal fractal = new Chaos2();
//		double d = 4.;
//		double mx = 0.;
//		double my = 0.;

//		Fractal fractal = new Lotka(0.1, 0.4, 0.3, 0.1, 0.5);
//		double d =8.;
//		double mx = 0.;
//		double my = 1.;
		
		int maxit = 10000;
		
		ColorModel cm = new ColorModel(200, 50, 2000);
		int processors = Runtime.getRuntime().availableProcessors();
		int workLoad = maxx/processors;
		
		Thread[] cals = new Thread[processors];
		
		ColumnSynchronizer cs = new ColumnSynchronizer(maxx);
		if (processors>1) {
			CyclicBarrier cb = new CyclicBarrier(processors+1);
			for(int i=0;i<processors;++i) {
				cals[i] = new Thread(new Worker(maxx, maxy, cs, maxit, fractal, bi.createGraphics(), cm, d, mx, my, cb));
				cals[i].start();
			}
		
			cb.await();
		} else {
			Worker w = new Worker(maxx, maxy, cs, maxit, fractal, bi.createGraphics(), cm, d, mx, my, null);
			w.run();
		}
		
		ImageIO.write(bi, "PNG", new File(fractal.getClass().getSimpleName()+".png"));
	}

}
