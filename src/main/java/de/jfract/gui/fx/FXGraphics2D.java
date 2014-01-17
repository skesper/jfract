package de.jfract.gui.fx;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.*;

import java.awt.*;
import java.awt.Color;
import java.awt.Paint;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.text.AttributedCharacterIterator;
import java.util.Map;

/**
 * User: kesper
 * Date: 16.01.14
 * Time: 14:49
 */
public class FXGraphics2D extends Graphics2D {

    private final GraphicsContext gcfx;

    public FXGraphics2D(GraphicsContext gcfx) {
        this.gcfx = gcfx;
    }

    @Override
    public void draw(Shape s) {
        throw new RuntimeException("Not implemented yet!");
    }

    @Override
    public boolean drawImage(Image img, AffineTransform xform, ImageObserver obs) {
        throw new RuntimeException("Not implemented yet!");
    }

    @Override
    public void drawImage(BufferedImage img, BufferedImageOp op, int x, int y) {
        throw new RuntimeException("Not implemented yet!");

    }

    @Override
    public void drawRenderedImage(RenderedImage img, AffineTransform xform) {
        throw new RuntimeException("Not implemented yet!");

    }

    @Override
    public void drawRenderableImage(RenderableImage img, AffineTransform xform) {
        throw new RuntimeException("Not implemented yet!");

    }

    @Override
    public void drawString(String str, int x, int y) {
        throw new RuntimeException("Not implemented yet!");

    }

    @Override
    public void drawString(String str, float x, float y) {
        throw new RuntimeException("Not implemented yet!");

    }

    @Override
    public void drawString(AttributedCharacterIterator iterator, int x, int y) {
        throw new RuntimeException("Not implemented yet!");

    }

    @Override
    public boolean drawImage(Image img, int x, int y, ImageObserver observer) {
        throw new RuntimeException("Not implemented yet!");
    }

    @Override
    public boolean drawImage(Image img, int x, int y, int width, int height, ImageObserver observer) {
        throw new RuntimeException("Not implemented yet!");
    }

    @Override
    public boolean drawImage(Image img, int x, int y, Color bgcolor, ImageObserver observer) {
        throw new RuntimeException("Not implemented yet!");
    }

    @Override
    public boolean drawImage(Image img, int x, int y, int width, int height, Color bgcolor, ImageObserver observer) {
        throw new RuntimeException("Not implemented yet!");
    }

    @Override
    public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, ImageObserver observer) {
        throw new RuntimeException("Not implemented yet!");
    }

    @Override
    public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, Color bgcolor, ImageObserver observer) {
        throw new RuntimeException("Not implemented yet!");
    }

    @Override
    public void dispose() {
        throw new RuntimeException("Not implemented yet!");

    }

    @Override
    public void drawString(AttributedCharacterIterator iterator, float x, float y) {
        throw new RuntimeException("Not implemented yet!");

    }

    @Override
    public void drawGlyphVector(GlyphVector g, float x, float y) {
        throw new RuntimeException("Not implemented yet!");

    }

    @Override
    public void fill(Shape s) {
        throw new RuntimeException("Not implemented yet!");

    }

    @Override
    public boolean hit(Rectangle rect, Shape s, boolean onStroke) {
        throw new RuntimeException("Not implemented yet!");
    }

    @Override
    public GraphicsConfiguration getDeviceConfiguration() {
        throw new RuntimeException("Not implemented yet!");
    }

    @Override
    public void setComposite(Composite comp) {
        throw new RuntimeException("Not implemented yet!");

    }

    @Override
    public void setPaint(Paint paint) {
        throw new RuntimeException("Not implemented yet!");

    }

    @Override
    public void setStroke(Stroke s) {
        throw new RuntimeException("Not implemented yet!");

    }

    @Override
    public void setRenderingHint(RenderingHints.Key hintKey, Object hintValue) {
        throw new RuntimeException("Not implemented yet!");

    }

    @Override
    public Object getRenderingHint(RenderingHints.Key hintKey) {
        throw new RuntimeException("Not implemented yet!");
    }

    @Override
    public void setRenderingHints(Map<?, ?> hints) {
        throw new RuntimeException("Not implemented yet!");

    }

    @Override
    public void addRenderingHints(Map<?, ?> hints) {
        throw new RuntimeException("Not implemented yet!");

    }

    @Override
    public RenderingHints getRenderingHints() {
        throw new RuntimeException("Not implemented yet!");
    }

    @Override
    public Graphics create() {
        throw new RuntimeException("Not implemented yet!");
    }

    @Override
    public void translate(int x, int y) {
        throw new RuntimeException("Not implemented yet!");

    }

    @Override
    public Color getColor() {
        throw new RuntimeException("Not implemented yet!");
    }

    @Override
    public void setColor(Color c) {
        javafx.scene.paint.Color col = new javafx.scene.paint.Color(toCol(c.getRed()),toCol(c.getGreen()),toCol(c.getBlue()),toCol(c.getAlpha()));
        gcfx.setFill(col);
        gcfx.setStroke(col);
    }

    private double toCol(int c) {
        double cc = (double)c;
        return cc/256.;
    }

    @Override
    public void setPaintMode() {
        throw new RuntimeException("Not implemented yet!");

    }

    @Override
    public void setXORMode(Color c1) {
        throw new RuntimeException("Not implemented yet!");

    }

    @Override
    public Font getFont() {
        throw new RuntimeException("Not implemented yet!");
    }

    @Override
    public void setFont(Font font) {
        throw new RuntimeException("Not implemented yet!");

    }

    @Override
    public FontMetrics getFontMetrics(Font f) {
        throw new RuntimeException("Not implemented yet!");
    }

    @Override
    public Rectangle getClipBounds() {
        throw new RuntimeException("Not implemented yet!");
    }

    @Override
    public void clipRect(int x, int y, int width, int height) {
        throw new RuntimeException("Not implemented yet!");

    }

    @Override
    public void setClip(int x, int y, int width, int height) {
        throw new RuntimeException("Not implemented yet!");

    }

    @Override
    public Shape getClip() {
        throw new RuntimeException("Not implemented yet!");
    }

    @Override
    public void setClip(Shape clip) {
        throw new RuntimeException("Not implemented yet!");

    }

    @Override
    public void copyArea(int x, int y, int width, int height, int dx, int dy) {
        throw new RuntimeException("Not implemented yet!");

    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        gcfx.moveTo(x1,y1);
        gcfx.lineTo(x2,y2);
    }

    @Override
    public void fillRect(int x, int y, int width, int height) {
        gcfx.fillRect(x,y,width,height);
    }

    @Override
    public void clearRect(int x, int y, int width, int height) {
        throw new RuntimeException("Not implemented yet!");

    }

    @Override
    public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
        throw new RuntimeException("Not implemented yet!");

    }

    @Override
    public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
        throw new RuntimeException("Not implemented yet!");

    }

    @Override
    public void drawOval(int x, int y, int width, int height) {
        throw new RuntimeException("Not implemented yet!");

    }

    @Override
    public void fillOval(int x, int y, int width, int height) {
        throw new RuntimeException("Not implemented yet!");

    }

    @Override
    public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
        throw new RuntimeException("Not implemented yet!");

    }

    @Override
    public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
        throw new RuntimeException("Not implemented yet!");

    }

    @Override
    public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) {
        throw new RuntimeException("Not implemented yet!");

    }

    @Override
    public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints) {
        throw new RuntimeException("Not implemented yet!");

    }

    @Override
    public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {
        throw new RuntimeException("Not implemented yet!");

    }

    @Override
    public void translate(double tx, double ty) {
        throw new RuntimeException("Not implemented yet!");

    }

    @Override
    public void rotate(double theta) {
        throw new RuntimeException("Not implemented yet!");

    }

    @Override
    public void rotate(double theta, double x, double y) {
        throw new RuntimeException("Not implemented yet!");

    }

    @Override
    public void scale(double sx, double sy) {
        throw new RuntimeException("Not implemented yet!");

    }

    @Override
    public void shear(double shx, double shy) {
        throw new RuntimeException("Not implemented yet!");

    }

    @Override
    public void transform(AffineTransform Tx) {
        throw new RuntimeException("Not implemented yet!");

    }

    @Override
    public void setTransform(AffineTransform Tx) {
        throw new RuntimeException("Not implemented yet!");

    }

    @Override
    public AffineTransform getTransform() {
        throw new RuntimeException("Not implemented yet!");
    }

    @Override
    public Paint getPaint() {
        throw new RuntimeException("Not implemented yet!");
    }

    @Override
    public Composite getComposite() {
        throw new RuntimeException("Not implemented yet!");
    }

    @Override
    public void setBackground(Color color) {
        throw new RuntimeException("Not implemented yet!");

    }

    @Override
    public Color getBackground() {
        throw new RuntimeException("Not implemented yet!");
    }

    @Override
    public Stroke getStroke() {
        throw new RuntimeException("Not implemented yet!");
    }

    @Override
    public void clip(Shape s) {
        throw new RuntimeException("Not implemented yet!");

    }

    @Override
    public FontRenderContext getFontRenderContext() {
        throw new RuntimeException("Not implemented yet!");
    }
}
