package de.jfract.gui.actions;

import de.jfract.ApplicationContext;
import de.jfract.gui.ExportFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * User: kesper
 * Date: 11.03.13
 * Time: 10:05
 */
public class ExportCalculationAction extends AbstractAction implements ApplicationContext.CalculationMonitor {
    private ExportFrame exportFrame = null;

    private ProgressMonitor pm;
    private BufferedImage bufferedImage;
    private String fileName;
    private long startTime;
    private long endTime;

    public ExportCalculationAction(ExportFrame exportFrame) {
        super("do it!");
        this.exportFrame = exportFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        final int xres = exportFrame.getXRes();
        final int yres = exportFrame.getYRes();
        fileName = exportFrame.getExportFileName();

        bufferedImage = new BufferedImage(xres, yres, BufferedImage.TYPE_INT_RGB);

        pm = new ProgressMonitor(null, "Calculating ...", "0% done", 0, 100);

        startTime = System.currentTimeMillis();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ApplicationContext.getInstance().recalculate((Graphics2D)bufferedImage.getGraphics(), xres, yres, ExportCalculationAction.this);
            }
        });
        exportFrame.dispose();
    }

    @Override
    public void calculationFinished() {
        pm.close();
        endTime = System.currentTimeMillis();
        System.out.println("elapsed time: "+(endTime-startTime)/1000+" s");
        try {
            ImageIO.write(bufferedImage, "PNG", new File(fileName));
            JOptionPane.showMessageDialog(null, "Image successfully exported.");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error during export: " + e.getMessage());
        }
    }

    @Override
    public void setProgress(int percent) {
        pm.setProgress(percent);
        pm.setNote(percent+"% done");
    }

    @Override
    public void setCalculationCanceled() {
        pm.close();
    }

    @Override
    public boolean isCanceled() {
        return pm.isCanceled();
    }
}
