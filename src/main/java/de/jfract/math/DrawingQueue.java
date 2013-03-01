package de.jfract.math;

import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: kesper
 * Date: 25.02.13
 * Time: 13:29
 * To change this template use File | Settings | File Templates.
 */
public class DrawingQueue {
    
    private Stack<DrawItem> list = new Stack<DrawItem>();
    private Color[] cols;
    private int maxx;
    private int maxy;

    public DrawingQueue(int maxx, int maxy) {
        cols = new Color[maxx*maxy];
        this.maxx = maxx;
        this.maxy = maxy;
    }

    public void set(int i, int j, Color c) {
        cols[i*maxy+j] = c;
    }

    public Color get(int i, int j) {
        return cols[i*maxy+j];
    }
//    public void add(DrawItem di) {
//        synchronized (list) {
//            list.push(di);
//        }
//    }

//    public DrawItem pop() {
//        if (list.isEmpty()) return null;
//        synchronized (list) {
//            return list.pop();
//        }
//    }

    
    public static class DrawItem {
        public int x;
        public int y;
        public Color col;
    }
}
