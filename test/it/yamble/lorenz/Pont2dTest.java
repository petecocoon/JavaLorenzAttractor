package it.yamble.lorenz;

import static org.junit.Assert.*;

import java.awt.geom.Point2D;
import java.util.Random;

import org.junit.Test;


public class Pont2dTest {
	@Test
	public void newPointIsAZeroCentredPoint() throws Exception {
		PBPoint3d newPoint = new PBPoint3d();
		assertEquals(new Double(0d), newPoint.getX());
		assertEquals(new Double(0d), newPoint.getY());		
	}
	
	@Test
	public void newPointWithGivenCoordsIsNotEmpty() throws Exception {
		Double x = new Random().nextDouble();
		Double y = new Random().nextDouble();
		
		PBPoint2d newPoint = new PBPoint2d(x, y);
		assertEquals(x, newPoint.getX());
		assertEquals(y, newPoint.getY());
	}
	
	@Test
	public void aPointCanBeModified() throws Exception {
		PBPoint3d newPoint = new PBPoint3d();
		newPoint.setX( newPoint.getX() + 1);
		assertEquals( new Double(1d), newPoint.getX());
		newPoint.setY( newPoint.getY() + 1);
		assertEquals( new Double(1d), newPoint.getY());
	}	
	
	@Test
	public void testEquals() throws Exception {
		assertEquals(new PBPoint3d(),new PBPoint3d());
	}
	
	@Test
	public void aPbPoint2dCanBeConvertedToawtPoint2d() throws Exception {
		PBPoint2d newPoint = new PBPoint2d(10d,10d);
		assertTrue(newPoint.toPoint2D() instanceof Point2D);
		assertEquals((Double) newPoint.getX(), (Double)newPoint.toPoint2D().getX());
		assertEquals((Double) newPoint.getY(), (Double)newPoint.toPoint2D().getY());
	}
	
	@Test
	public void toStringShouldReturnAWellFormattedString() throws Exception {
		assertEquals("PBPoint2D[100.0, 100.0]", new PBPoint2d(100d,100d).toString());
	}
	
	@Test
	public void minusZeroIsZero() throws Exception {
		assertEquals(new PBPoint2d(-0d,-0d), new PBPoint2d(0d,0d));
	}

}
