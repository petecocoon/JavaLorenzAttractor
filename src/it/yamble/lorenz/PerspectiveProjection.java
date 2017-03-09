package it.yamble.lorenz;
import static java.lang.Math.*;

public class PerspectiveProjection {
	private PBPoint3d cameraLocation = new PBPoint3d(0d,0d,0d);
	private PBPoint3d cameraRotation = new PBPoint3d(0d,0d,0d); //i valori sono in gradi
	private PBPoint3d viewerPosition = new PBPoint3d(10d,10d,10d); //e' un buon valore di distanza

	public PBPoint2d project(PBPoint3d pointToProject) {
		PBPoint2d projectedPoint = new PBPoint2d();
		PBPoint3d translationPoint = getTranslationPoint(pointToProject);

		projectedPoint.setX(
				(translationPoint.getX() - viewerPosition.getX()) /
				(viewerPosition.getZ() / translationPoint.getZ()));
		
		projectedPoint.setY(
				(translationPoint.getY() - viewerPosition.getY()) /
				(viewerPosition.getZ() / translationPoint.getZ()));		
		
		return projectedPoint;
	}

	public void setCameraLocation(Double x, Double y, Double z) {
		this.cameraLocation = new PBPoint3d(x,y,z);		
	}

	public void setCameraRotation(Double x, Double y, Double z) {
		this.cameraRotation = new PBPoint3d(x,y,z);		
	}
	
	public PBPoint3d getTranslationPoint(PBPoint3d pointToProject){
		return new PBPoint3d(
				this.getTranslationPointX(pointToProject),
				this.getTranslationPointY(pointToProject),
				this.getTranslationPointZ(pointToProject)
				);
	}
	
	private Double getTranslationPointX(PBPoint3d pointToProject){
		return cos(this.cameraRotation.getY()) * 
				(sin(this.cameraRotation.getZ()) * (pointToProject.getY() - this.cameraLocation.getY()) + 
				 cos(this.cameraRotation.getZ()) * (pointToProject.getX() - this.cameraLocation.getX())) -
				(sin(this.cameraRotation.getY()) * (pointToProject.getZ() - this.cameraLocation.getZ()));
	}
	
	private Double getTranslationPointY(PBPoint3d pointToProject){
		return sin(this.cameraRotation.getX()) * partialTransition(pointToProject) + 
			   cos(this.cameraRotation.getX()) * partialTransition2(pointToProject);								
	}
	
	private Double getTranslationPointZ(PBPoint3d pointToProject){ 
		return cos(this.cameraRotation.getX()) * partialTransition(pointToProject) -
			   sin(this.cameraRotation.getX()) * partialTransition2(pointToProject);							
	}

	private double partialTransition2(PBPoint3d pointToProject) {
		return (cos(this.cameraRotation.getZ()) * (pointToProject.getY() - this.cameraLocation.getY()) -
				sin(this.cameraRotation.getZ()) * (pointToProject.getX() - this.cameraRotation.getX()));
	}

	private double partialTransition(PBPoint3d pointToProject) {
		return (cos(this.cameraRotation.getY()) * (pointToProject.getZ() - this.cameraLocation.getZ()) + 
				sin(this.cameraRotation.getY()) * (sin(this.cameraRotation.getZ()) * (pointToProject.getY() - this.cameraLocation.getY()) +
						cos(this.cameraRotation.getZ()) * (pointToProject.getX() - this.cameraLocation.getX())));
	}

	public void setViewerPosition(PBPoint3d viewerPosition) throws ViewerCantStayAtOriginException {
		if(viewerPosition.equals(new PBPoint3d(0d,0d,0d))){
			throw new ViewerCantStayAtOriginException();
		}
		this.viewerPosition = viewerPosition;
	}

	public PBPoint3d getViewerPosition() {
		return viewerPosition;
	}

	public void setViewerPosition(double x, double y, double z) throws ViewerCantStayAtOriginException {
		this.setViewerPosition(new PBPoint3d(x,y,z));
		
	}
		

}
