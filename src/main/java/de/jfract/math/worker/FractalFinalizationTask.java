package de.jfract.math.worker;

import de.jfract.ApplicationContext;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * User: kesper
 * Date: 09.04.2014
 * Time: 14:11
 */
public class FractalFinalizationTask extends ForkJoinTask<Object> {

    private final ApplicationContext.CalculationMonitor calculationMonitor;
    private final ForkJoinPool pool;

    public FractalFinalizationTask(final ApplicationContext.CalculationMonitor calculationMonitor, final ForkJoinPool pool) {
        this.calculationMonitor = calculationMonitor;
        this.pool = pool;
    }

    @Override
    public Object getRawResult() {
        return null;
    }

    @Override
    protected void setRawResult(Object value) {

    }

    @Override
    protected boolean exec() {
        while(pool.getActiveThreadCount()>1) {
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
}
