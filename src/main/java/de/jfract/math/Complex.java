package de.jfract.math;

import java.io.Serializable;

/**
 * Simple complex data type with fundamental operations.
 * User: kesper
 * Date: 22.02.13
 */
public class Complex implements Serializable {

	private static final long serialVersionUID = -3254336492636374618L;
	
	private final double re;
	private final double im;
	
	public Complex(double re, double im) {
		this.re = re;
		this.im = im;
	}
	
	public Complex multiply(Complex a) {
		return new Complex(re*a.re-im*a.im, re*a.im+im*a.re);
	}
	
	public Complex multiply(double a) {
		return new Complex(re*a, im*a);
	}

    public Complex divide(Complex a) {
        double n = (a.re*a.re+a.im*a.im);
        return new Complex((re*a.re+im*a.im)/n,(im*a.re-re*a.im)/n);
    }

    public Complex strangeDivide(Complex a) {
        double n = (im*im+a.im*a.im);
        return new Complex((re*im+a.re*a.im)/n, (im*a.re-re*a.im)/n);
    }

	public Complex add(Complex a) {
		return new Complex(re+a.re, im+a.im);
	}

	public Complex subtract(Complex a) {
		return new Complex(re-a.re, im-a.im);
	}
	
	public Complex square() {
		return new Complex(re*re-im*im, 2.*re*im);
	}

    public double abs() {
        return Math.sqrt(re*re+im*im);
    }

    public double abs2() {
        return re*re+im*im;
    }

	public Complex conjugate() {
		return new Complex(re, -im);
	}
	
	public double real() {
		return re;
	}
	
	public double imaginary() {
		return im;
	}
	
	public String toString() {
		return "("+re+" + i"+im+")";
	}
}
