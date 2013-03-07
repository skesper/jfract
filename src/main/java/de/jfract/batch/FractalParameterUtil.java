package de.jfract.batch;

import de.jfract.math.Complex;
import de.jfract.math.Fractal;
import de.jfract.math.FractalPars;

import java.util.Properties;

/**
 * User: kesper
 * Date: 07.03.13
 * Time: 10:37
 */
public class FractalParameterUtil {
    private Properties props;

    private Complex startPointStart;
    private Complex startPointEnd;
    private int itStart;
    private int itEnd;
    private Complex centerStart;
    private Complex centerEnd;
    private double sizeStart;
    private double sizeEnd;
    private int width;
    private int height;
    private int frames;

    public FractalParameterUtil(Properties props) throws Exception {
        this.props = props;
        startPointStart = getComplex(props.getProperty(ConfigurationParameters.MV_START_POINT_START));
        startPointEnd = getComplex(props.getProperty(ConfigurationParameters.MV_START_POINT_END));
        itStart = Integer.parseInt(props.getProperty(ConfigurationParameters.MV_ITERATIONS_START));
        itEnd = Integer.parseInt(props.getProperty(ConfigurationParameters.MV_ITERATIONS_END));
        centerStart = getComplex(props.getProperty(ConfigurationParameters.MV_CENTER_START));
        centerEnd = getComplex(props.getProperty(ConfigurationParameters.MV_CENTER_END));
        sizeStart = Double.parseDouble(props.getProperty(ConfigurationParameters.MV_SIZE_START));
        sizeEnd = Double.parseDouble(props.getProperty(ConfigurationParameters.MV_SIZE_END));
        width = Integer.parseInt(props.getProperty(ConfigurationParameters.MV_CLIP_RECT_WIDTH));
        height = Integer.parseInt(props.getProperty(ConfigurationParameters.MV_CLIP_RECT_HEIGHT));
        frames = Integer.parseInt(props.getProperty(ConfigurationParameters.MV_FRAMES_OVERALL));
    }

    public FractalPars getPars(int current) throws Exception {
        FractalPars pars = new FractalPars();
        pars.setFractal((Fractal)Class.forName(props.getProperty(ConfigurationParameters.FRACTAL)).newInstance());

        pars.setD(getInterpolatedValue(current, frames, sizeStart, sizeEnd));
        pars.setMaxit(getCurrentValue(current, frames, itStart, itEnd));
        pars.setStartPoint(getCurrentValue(current,frames, startPointStart, startPointEnd));
        Complex center = getCurrentValue(current, frames, centerStart, centerEnd);
        pars.setCenterX(center.real());
        pars.setCenterY(center.imaginary());
        pars.setMaxx(width);
        pars.setMaxy(height);

        return pars;
    }

    public int getFrames() {
        return frames;
    }

    public int getCurrentValue(int step, int max, int start, int end) {
        return (int)getCurrentValue(step, max, (double)start, (double)end);
    }

    public Complex getCurrentValue(int step, int max, Complex start, Complex end) {
        double re = getCurrentValue(step,max, start.real(), end.real());
        double im = getCurrentValue(step,max, start.imaginary(), end.imaginary());
        return new Complex(re, im);
    }

    public Complex getInterpolatedValue(int step, int max, Complex start, Complex end) {
        double re = getInterpolatedValue(step, max, start.real(), end.real());
        double im = getInterpolatedValue(step, max, start.imaginary(), end.imaginary());
        return new Complex(re, im);
    }

    public double getCurrentValue(int step, int max, double start, double end) {
        double ds = (double)step;
        double dm = (double)max;
        return start+ds*(end-start)/dm;
    }

    public double getInterpolatedValue(int step, int max, double start, double end) {
        double a = Math.exp((Math.log(end)-Math.log(start))/((double)max));
        double v = start*Math.pow(a, step);
        return v;
    }

    public Complex getComplex(String val) {
        val = val.trim();
        val = val.substring(1, val.length()-1);
        String[] splits = val.split(",");
        try {
            return new Complex(Double.parseDouble(splits[0]), Double.parseDouble(splits[1].substring(1)));
        } catch(Exception e) {
            System.out.println("Error parsing: "+val);
            throw new RuntimeException(e);
        }
    }
}
