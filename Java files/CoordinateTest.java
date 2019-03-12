import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CoordinateTest {
	Coordinate c = new Coordinate(0,1);
	Coordinate c2 = new Coordinate(0,1);
	Coordinate outofbounds1 = new Coordinate(0,0);//-2,-2 on board
	Coordinate outofbounds2 = new Coordinate(10,10);//8, 8 on board
	Coordinate semiin1 = new Coordinate(2,1);//0,-1 on board
	Coordinate semiin2 = new Coordinate(1,2);//-1,0 on board
	Coordinate semiin3 = new Coordinate(10,0);//8,-2 on board
	Coordinate semiin4 = new Coordinate(0,10);//-2, 8 on board
	Coordinate inbounds = new Coordinate (7,7);//5,5 on board
	@Test
	void testCreateCoordinate() {
		assertNotNull(c);
		assertEquals(c.xcoord,0);
		assertEquals(c.ycoord,1);
	}
	
	@Test
	void testCheckCoordinate() {
		assertFalse(outofbounds1.checkCoordinate());
		assertFalse(outofbounds2.checkCoordinate());
		assertFalse(semiin1.checkCoordinate());
		assertFalse(semiin2.checkCoordinate());
		assertFalse(semiin3.checkCoordinate());
		assertFalse(semiin4.checkCoordinate());
		assertTrue(inbounds.checkCoordinate());
	}
	
	@Test
	void testEquals() {
		assertTrue(c.equals(c2));
		assertFalse(c.equals(inbounds));
	}

}
