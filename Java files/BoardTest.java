import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BoardTest {
	Board b = new Board();
	Coordinate c1 = new Coordinate(1,1);//"+" on board
	Coordinate c2 = new Coordinate(2,2);//" " on board
	WhitePlayer p = new WhitePlayer();
	@Test
	void testGetValue() {
		assertEquals(b.getValue(c1),"+");
		assertFalse(b.getValue(c2)=="+");
		
	}
	
	@Test
	void testSetValue() {
		b.setValue(c2,"test");
		assertEquals(b.getValue(c2),"test");
		assertFalse(b.getValue(c2) == null|b.getValue(c2)==" ");
	}
	
	@Test
	void testPopulateBoard() {
		p.setPieces();
		b.populateBoard(p.pieces);
		b.print();
		assertEquals(b.getValue(c2),"1");
		assertFalse(b.getValue(c2)== null|b.getValue(c2)==" ");
	}

}
