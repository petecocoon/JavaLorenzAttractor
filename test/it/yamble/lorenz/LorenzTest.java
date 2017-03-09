package it.yamble.lorenz;

import static org.junit.Assert.*;

import org.junit.Test;


public class LorenzTest {
	@Test
	public void nextPointShouldReturnAPoint() throws Exception {
		Lorenz test = new Lorenz();
		assertTrue(test.getNextPoint() instanceof PBPoint3d);
	}
	
	@Test
	public void cantGetAPointIfmaxIterationsIsReached() throws Exception {
		Lorenz attractor = new Lorenz();
		attractor.setMaxIterations(2);
		assertTrue(attractor.hasMorePoints());
		assertTrue(attractor.getNextPoint() instanceof PBPoint3d);
		assertTrue(attractor.hasMorePoints());
		assertTrue(attractor.getNextPoint() instanceof PBPoint3d);
		assertFalse(attractor.hasMorePoints());
		assertFalse(attractor.getNextPoint() instanceof PBPoint3d);
			
	}
	
	@Test
	public void nextPointSouldReturnAValidPoint() throws Exception {
		Lorenz attractor = new Lorenz();
		attractor.setMaxIterations(30);
		PBPoint3d point;
		while (attractor.hasMorePoints()) {
			point = attractor.getNextPoint();
			assertTrue(point instanceof PBPoint3d);
			assertTrue(point.getX() instanceof Double);
			assertFalse("PBPoint3D[NaN, NaN, NaN]".equals(point.toString()));	
		}
	}
	
	@Test
	public void firstIterationXShouldBeMinus8() throws Exception {
		Lorenz attractor = new Lorenz();
		attractor.setMaxIterations(1);
		assertEquals(new Double(-8d), (Double)attractor.getNextPoint().getX());		
	}
	
	@Test
	public void fisrtIterationYShouldBe9dot6() throws Exception {
		Lorenz attractor = new Lorenz();
		attractor.setMaxIterations(1);
		assertEquals(new Double(9.6d), (Double)attractor.getNextPoint().getY());
	}
	
	@Test
	public void fisrtIterationZShouldBeTwentyThreeDotTreePeriodic() throws Exception {
		Lorenz attractor = new Lorenz();
		attractor.setMaxIterations(1);
		assertEquals(new Double(23.33d), (Double)attractor.getNextPoint().getZ(), 0.01d);
	}
}
