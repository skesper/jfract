package de.jfract.math.worker;

import de.jfract.ApplicationContext;
import de.jfract.math.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.*;
import javafx.scene.paint.Color;

import java.awt.*;
import java.util.concurrent.ForkJoinTask;

/**
 * User: kesper
 * Date: 31.03.2014
 * Time: 15:18
 */
public class FractalForkJoinTask extends ForkJoinTask<Integer> {

    private int offset;
    private int tasks;
    private FractalPars fp;
    private Graphics2D g2d;
    private ApplicationContext.CalculationMonitor monitor;

    public FractalForkJoinTask(int offset, int tasks, FractalPars fp, Graphics2D g2d, ApplicationContext.CalculationMonitor monitor) {
        this.offset = offset;
        this.tasks = tasks;
        this.fp = fp;
        this.g2d = g2d;
        this.monitor = monitor;
    }

    @Override
    public Integer getRawResult() {
        return null;
    }

    @Override
    protected void setRawResult(Integer value) {

    }

    @Override
    protected boolean exec() {
        int maxx = fp.getMaxx();
        int maxy = fp.getMaxy();
        int maxit = fp.getMaxit();
        Fractal f = fp.getFractal();

        ColorModel cm = fp.getColorModel();
        double d = fp.getD();
        double aspect = ((double)maxx)/((double)maxy);
        double d2 = d*aspect;

        // Obere linke Ecke
        double ulx = fp.getCenterX()-d2/2.;
        double uly = fp.getCenterY()-d/2.;


        for(int i=offset;i<maxx;i+=tasks) {
            if (this.isCancelled()) break;

            double x = ulx+d2*((double)i)/maxx;
            for(int j=0;j<maxy;++j) {
                double y = uly+d*((double)j)/maxy;
                Complex c = new Complex(x, y);
                Result r = f.calc(c, maxit);
                g2d.setColor(cm.getColor(r));
                g2d.drawLine(i, j, i, j);
            }
            if (monitor!=null) {
                int perc = (int)(100.*i/maxx);
                monitor.setProgress(perc);
            }
        }
        return false;
    }
}
