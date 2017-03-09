package it.yamble.lorenz;
import static org.junit.Assert.*;

import org.junit.Test;

public class PerspectiveProjectionTest {
	
	@Test
	public void aZero3DPointShouldBeProjectedInZero2dPoint() throws Exception {
		PerspectiveProjection perspective = new PerspectiveProjection();
		PBPoint3d pointToProject = new PBPoint3d();
		PBPoint2d projectedPoint = new PBPoint2d();
		assertEquals(projectedPoint, perspective.project(pointToProject));
	}
	
	@Test
	public void theViewerCantStayAtTheOrigin() throws Exception {
		Exception eOutOfBounds = null;
		PerspectiveProjection perspective = new PerspectiveProjection();
		try{
			perspective.setViewerPosition(0d, 0d, 0d);
		}catch(ViewerCantStayAtOriginException e){
			eOutOfBounds = e;
		}
		assertNotNull("Non e' stata sollevata l'eccezione", eOutOfBounds);
	}
	

	
	@Test
	public void aRotatedCamereShouldNotGiveTheSameResultAsADifferentRotatedCamera() throws Exception {
		PerspectiveProjection perspective = new PerspectiveProjection();
		PBPoint3d pointToProject = new PBPoint3d(20d, 20d, 20d);
		perspective.setCameraRotation(0d, 0d, 0d);
		PBPoint2d projectedPoint = perspective.project(pointToProject);
		perspective.setCameraRotation(10d, 10d, 10d);
		PBPoint2d projectedPointFromAnotherAngle = perspective.project(pointToProject);
		assertFalse(projectedPoint.equals(projectedPointFromAnotherAngle));		
	}
	
	@Test
	public void aPojectionWithARotatedCameraShouldGiveDifferentXandY() throws Exception {
		PerspectiveProjection perspective = new PerspectiveProjection();
		PBPoint3d pointToProject = new PBPoint3d(-1d, 2d, 34d);
		PBPoint2d projectedPoint = new PBPoint2d(-1d, 2d);
		perspective.setCameraRotation(90d, 90d, 90d);
		assertFalse(projectedPoint.equals(perspective.project(pointToProject)));		
	}
	
	@Test
	public void transactionPointIsNotTheSamePoint() throws Exception {
		PerspectiveProjection perspective = new PerspectiveProjection();
		PBPoint3d pointToProject = new PBPoint3d(-2d, 2d, 34d);
		perspective.setCameraLocation(90d, 90d, 90d);
		assertFalse(pointToProject.equals(perspective.getTranslationPoint(pointToProject)));
		
	}
	
	
	
}
