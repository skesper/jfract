package de.jfract.math;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * User: kesper
 * Date: 25.02.13
 * Time: 13:29
 */
public class DrawingQueue {
    
    private int[] cols;
    private int maxy;

    public DrawingQueue(int maxx, int maxy) {
        cols = new int[maxx*maxy];
        Arrays.fill(cols,Integer.MIN_VALUE);
        this.maxy = maxy;
    }

    public void set(int i, int j, Color c) {
        cols[i*maxy+j] = c.getRGB();
    }

    public Color get(int i, int j) {
        int c = cols[i*maxy+j];
        if (c==Integer.MIN_VALUE) return null;
        return new Color(c);
    }
}
