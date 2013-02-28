package de.jfract.math;

import java.io.Serializable;

public class Result implements Serializable {
	private static final long serialVersionUID = 2184717091217517061L;
	
	public int iteration;
	public Divergence divergence;
	
	public int toCompact() {
		return iteration*10+divergence.ordinal();
	}
	
	public void fromCompact(int compact) {
		iteration = compact/10;
		divergence = Divergence.values()[compact%10];
	}
}
