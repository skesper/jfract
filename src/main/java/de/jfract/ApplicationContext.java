package de.jfract;

import de.jfract.gui.DrawPanel;
import de.jfract.gui.MainFrame;
import de.jfract.gui.fx.FXGraphics2D;
import de.jfract.math.ColumnSynchronizer;
import de.jfract.math.DrawingQueue;
import de.jfract.math.FractalPars;
import de.jfract.math.Worker;
import de.jfract.math.worker.FractalForkJoinPool;
import de.jfract.math.worker.FractalForkJoinTask;
import javafx.scene.canvas.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Stack;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ForkJoinTask;

/**
 * User: kesper
 * Date: 22.02.13
 * Time: 15:18
 */
public class ApplicationContext {

    public static String version = "jFract v1.0 alpha";

    private DrawPanel panel;
    private MainFrame mainFrame;
    private volatile FractalPars fractalParameters;
    private volatile Stack<Thread> threadStack = new Stack<Thread>();
    private volatile boolean calculationFinished = true;

    private volatile FractalForkJoinPool fractalForkJoinPool;

    private ApplicationContext() {
        fractalParameters = new FractalPars();
        panel = new DrawPanel();
        mainFrame = new MainFrame(panel);
    }

    private static final ApplicationContext me = new ApplicationContext();

    public static ApplicationContext getInstance() {
        return me;
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public DrawPanel getPanel() {
        return panel;
    }

    public FractalPars getFractalParameters() {
        return fractalParameters;
    }

    public void setFractalParameters(FractalPars fractalParameters) {
        this.fractalParameters = fractalParameters;
    }

    public boolean isCalculationFinished() {
        return calculationFinished;
    }

    public void recalculate() {
        recalculate((Graphics2D)ApplicationContext.getInstance().getPanel().getGraphics(),
                this.getPanel().getWidth(), this.getPanel().getHeight());
    }

    public void recalculate(final Graphics2D g2d, final int width, final int height) {
        recalculate(g2d, width, height, null);
    }

    public void recalculate(final GraphicsContext gcfx, int width, int height) {
        recalculate(new FXGraphics2D(gcfx), width, height, null);
    }

    public void recalculate(final Graphics2D g2d, final int width, final int height, final CalculationMonitor calculationMonitor) {
        // Implement for online drawing during calculation
        throw new RuntimeException("Not implemented.");
    }

    public void recalculate(final BufferedImage bi, final int width, final int height, final CalculationMonitor calculationMonitor) {

        if (fractalParameters==null || fractalParameters.getFractal()==null) return;

        cancelCalculation();

        final FractalPars fp = this.getFractalParameters();

        fp.setMaxx(width);
        fp.setMaxy(height);
        fp.getFractal().setFixPoint(fp.getFixPoint());

        calculationFinished = false;

        int numProc = Runtime.getRuntime().availableProcessors();

        if (fractalForkJoinPool!=null) {
            fractalForkJoinPool.shutdownNow();
        }
        fractalForkJoinPool = new FractalForkJoinPool();
        for(int i=0;i<numProc;++i) {
            FractalForkJoinTask ffjt = new FractalForkJoinTask(i, numProc, fp, (Graphics2D)bi.getGraphics(), i==0 ? calculationMonitor : null);
            fractalForkJoinPool.execute(ffjt);
        }

        fractalForkJoinPool.execute(new ForkJoinTask<Object>() {
            @Override
            public Object getRawResult() {
                return null;
            }

            @Override
            protected void setRawResult(Object value) {

            }

            @Override
            protected boolean exec() {
                while(fractalForkJoinPool.getActiveThreadCount()>1) {
                    try {
                        Thread.sleep(10);
                    } catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("DEBUG: calculation finished.");
                calculationMonitor.calculationFinished();
                return false;
            }
        });

    }

    public void cancelCalculation() {
        while(!threadStack.isEmpty()) {
            Thread t = threadStack.pop();
            t.interrupt();
        }
    }

    public static interface CalculationMonitor {
        public void setProgress(int percent);

        public void calculationFinished();

        public void setCalculationCanceled();

        public boolean isCanceled();
    }
}
