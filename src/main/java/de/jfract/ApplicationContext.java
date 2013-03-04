package de.jfract;

import de.jfract.gui.DrawPanel;
import de.jfract.gui.MainFrame;
import de.jfract.math.ColumnSynchronizer;
import de.jfract.math.DrawingQueue;
import de.jfract.math.FractalPars;
import de.jfract.math.Worker;

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

    public void recalculate() {

        while(!threadStack.isEmpty()) {
            Thread t = threadStack.pop();
            t.interrupt();
        }

        final FractalPars fp = this.getFractalParameters();
        final DrawPanel dp = this.getPanel();

        fp.setMaxx(dp.getWidth());
        fp.setMaxy(dp.getHeight());
        fp.getFractal().setFixPoint(fp.getFixPoint());
        //fp.getFractal().setStartPoint(fp.getStartPoint());

        Thread t = new Thread(new Runnable() {
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
                threadStack.push(cals[i]);
                cals[i].start();
            }

            Graphics2D g2d = (Graphics2D)ApplicationContext.getInstance().getPanel().getGraphics();
            g2d.setColor(Color.black);
            g2d.fillRect(0,0,dp.getWidth(), dp.getHeight());
            Thread me = Thread.currentThread();
            for(int i=0;i<fp.getMaxx();++i) {
                for(int j=0;j<fp.getMaxy();++j) {
                    Color c = null;

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
            }
        });
        t.start();
    }
}
