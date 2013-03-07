package de.jfract.batch;

import de.jfract.ApplicationContext;
import de.jfract.math.Complex;
import de.jfract.math.FractalPars;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * User: kesper
 * Date: 07.03.13
 * Time: 09:52
 */
public class MovieGenerator implements Runnable {

    private Properties props;

    public MovieGenerator() {
        System.out.println("Fractal movie generator v1.0 alpha");
    }

    @Override
    public void run() {
        try {
            FractalParameterUtil fpu = new FractalParameterUtil(props);
            int frames = fpu.getFrames();
            ApplicationContext ac = ApplicationContext.getInstance();
            for(int i=0;i<frames;++i) {
                FractalPars pars = fpu.getPars(i);
                ac.setFractalParameters(pars);
                BufferedImage img = new BufferedImage(pars.getMaxx(), pars.getMaxy(), BufferedImage.TYPE_INT_RGB);
                Graphics2D g2d = (Graphics2D)img.getGraphics();
                ac.recalculate(g2d, pars.getMaxx(), pars.getMaxy());
                while(ac.isCalculationFinished()==false) {
                    Thread.sleep(10);
                }
                write(i, img);
                System.out.println("wrote image "+i+"/"+frames);
            }
        } catch(Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Error in batch job.",e);
        }
    }

    public void write(int idx, BufferedImage img) throws Exception {

        File file = new File(props.getProperty(ConfigurationParameters.OUTPUT_DIR),
                props.getProperty(ConfigurationParameters.MV_FRAMES_FILE_PREFIX).concat(Integer.toString(idx)).concat(".jpg"));

        ImageIO.write(img, "JPG", file);
    }

    private void init(String filename) throws Exception {

        FileInputStream fis = new FileInputStream(filename);
        props = new Properties();
        props.load(fis);
        fis.close();

        props.list(System.out);
    }

    public static void main(String[] args) throws Exception {

        MovieGenerator mg = new MovieGenerator();

        mg.init(args[0]);

        mg.run();
    }
}
