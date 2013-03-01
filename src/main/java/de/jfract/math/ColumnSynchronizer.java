package de.jfract.math;

/**
 * Created with IntelliJ IDEA.
 * User: kesper
 * Date: 22.02.13
 * Time: 16:33
 * To change this template use File | Settings | File Templates.
 */
public class ColumnSynchronizer {
    private volatile int column = 0;
    private final int max;

    public ColumnSynchronizer(int max) {
        this.max = max;
    }

    public int getNextColumn() {
        if (column>=max) return -1;
        return column++;
    }

    public boolean isFinal() {
        return column>=max;
    }
}
