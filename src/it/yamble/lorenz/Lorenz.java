package it.yamble.lorenz;


public class Lorenz extends MathFunction {
	private double resizeRatio = 0.01d;
	private PBPoint3d lastPoint = new PBPoint3d(-10d,10d,25d);
	private Double prandtlNumber = 10d;
	private Double rayleighNumber = 28.0d;
	private Double thirdConstant =  new Double(8.0d/3.0d);
	
	
	public Lorenz() {
		//uso i valori classici utilizzati da Lorenz 
	}
	
	public Lorenz(Double prandtlNumber, Double rayleighNumber, Double thirdConstant){
		this.prandtlNumber = prandtlNumber;
		this.rayleighNumber = rayleighNumber;
		this.thirdConstant = thirdConstant;		
	}
	
	@Override
	Boolean hasMorePoints() {
		if((this.currentIteration + 1) > this.maxIterations){
			return false;
		}
		return true;
	}
	
	@Override
	PBPoint3d getNextPoint() {
		if( ! this.hasMorePoints() ){
			return null;
		}
		this.currentIteration++;
		PBPoint3d newPoint = new PBPoint3d(
				this.getNextX(),
				this.getNextY(),
				this.getNextZ()
				);
		lastPoint = newPoint;
		return lastPoint;
	}
		
	PBPoint3d getLastPoint() {
		return lastPoint;
	}
	
	
	private Double getNextX(){
		return lastPoint.getX() + resizeRatio * prandtlNumber * (lastPoint.getY() - lastPoint.getX());
	}  
	
	private Double getNextY(){
		return lastPoint.getY() + resizeRatio * (lastPoint.getX() * (rayleighNumber - lastPoint.getZ()) - lastPoint.getY());

	}

	private Double getNextZ(){
		return lastPoint.getZ() + resizeRatio *  (lastPoint.getX() * lastPoint.getY() - thirdConstant * lastPoint.getZ());
	}  
	
}
