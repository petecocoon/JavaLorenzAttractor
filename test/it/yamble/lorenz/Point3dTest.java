package it.yamble.lorenz;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;


public class Point3dTest {
	@Test
	public void newPointIsAZeroCentredPoint() throws Exception {
		PBPoint3d newPoint = new PBPoint3d();
		assertEquals(new Double(0d), newPoint.getX());
		assertEquals(new Double(0d), newPoint.getY());
		assertEquals(new Double(0d), newPoint.getZ());
	}
	
	@Test
	public void newPointWithGivenCoordsIsNotEmpty() throws Exception {
		Double x = new Random().nextDouble();
		Double y = new Random().nextDouble();
		Double z = new Random().nextDouble();
		PBPoint3d newPoint = new PBPoint3d(x, y, z);
		assertEquals(x, newPoint.getX());
		assertEquals(y, newPoint.getY());
		assertEquals(z, newPoint.getZ());
	}
	
	@Test
	public void aPointCanBeModified() throws Exception {
		PBPoint3d newPoint = new PBPoint3d();
		newPoint.setX( newPoint.getX() + 1);
		assertEquals( new Double(1d), newPoint.getX());
		newPoint.setY( newPoint.getY() + 1);
		assertEquals( new Double(1d), newPoint.getY());
		newPoint.setZ( newPoint.getZ() + 1);
		assertEquals( new Double(1d), newPoint.getZ());
	}
	
	
	
	@Test
	public void testEquals() throws Exception {
		assertEquals(new PBPoint3d(),new PBPoint3d());
	}
	

	@Test
	public void toStringShouldReturnAWellFormattedString() throws Exception {
		assertEquals("PBPoint3D[10.0, 20.0, 30.0]", new PBPoint3d(10d,20d, 30d).toString());
	}

}
