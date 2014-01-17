package de.jfract;

import de.jfract.gui.DrawPanel;
import de.jfract.gui.MainFrame;
import de.jfract.gui.fx.FXGraphics2D;
import de.jfract.math.ColumnSynchronizer;
import de.jfract.math.DrawingQueue;
import de.jfract.math.FractalPars;
import de.jfract.math.Worker;
import javafx.scene.canvas.GraphicsContext;

import javax.swing.*;
import java.awt.*;
import java.util.Stack;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

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

        if (fractalParameters==null || fractalParameters.getFractal()==null) return;

        cancelCalculation();

        final FractalPars fp = this.getFractalParameters();

        fp.setMaxx(width);
        fp.setMaxy(height);
        fp.getFractal().setFixPoint(fp.getFixPoint());

        calculationFinished = false;


        Runnable rr = new Runnable() {
            @Override
            public void run() {
            threadStack.push(Thread.currentThread());

            int processors = Runtime.getRuntime().availableProcessors();
            Thread[] cals = new Thread[processors];
            CyclicBarrier cb = null; //new CyclicBarrier(processors+1);
            ColumnSynchronizer cs = new ColumnSynchronizer(fp.getMaxx());

            DrawingQueue dq = new DrawingQueue(fp.getMaxx(), fp.getMaxy());
            for(int i=0;i<processors;++i) {
                cals[i] = new Thread(new Worker(cs,
                        dq,
                        cb, fp));
                cals[i].setDaemon(true);
                threadStack.push(cals[i]);
                cals[i].start();
            }

            g2d.setColor(Color.black);
            g2d.fillRect(0,0,width,height);
            Thread me = Thread.currentThread();
            for(int i=0;i<fp.getMaxx();++i) {
                if (calculationMonitor!=null) {
                    if (calculationMonitor.isCanceled()) {
                        cancelCalculation();
                        return;
                    }
                    if (i%10==0) {
                        calculationMonitor.setProgress(100*i/fp.getMaxx());
                    }
                }
                for(int j=0;j<fp.getMaxy();++j) {
                    Color c;

                    do {
                        c=dq.get(i,j);
                        if (c==null) {
                            try {
                                Thread.sleep(1);
                            } catch (InterruptedException e) {
                                return;
                            }
                        }
                    } while(c==null);

                    g2d.setColor(c);
                    g2d.drawLine(i,j,i,j);
                    if (me.isInterrupted()) break;
                }
            }
            if (calculationMonitor!=null) {
                calculationMonitor.calculationFinished();
            }
            calculationFinished=true;
            }
        };
        Thread t = new Thread(rr);
        t.setDaemon(true);
        t.start();

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
