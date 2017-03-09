package it.yamble.lorenz;

public abstract class MathFunction {
	protected Integer maxIterations = 10000;
	protected Integer currentIteration = 0;

	public void setMaxIterations(Integer maxIterations) {
		this.maxIterations = maxIterations;
	}

	public Integer getMaxIterations() {
		return maxIterations;
	}

	public Integer getCurrentIteration() {
		return currentIteration;
	}
	
	abstract PBPoint3d getNextPoint();	
	abstract Boolean hasMorePoints();
	
}
