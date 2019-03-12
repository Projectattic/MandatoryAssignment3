import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BlackPieceTest {
	Board b = new Board();
	Coordinate c1 = new Coordinate(9,9);//7,7 on board
	Coordinate c2 = new Coordinate(8,8);//6,6 on board
	Coordinate c3 = new Coordinate(7,9); //5, 7 on board
	Coordinate moveto1 = new Coordinate(8,8);
	Coordinate moveto2 = new Coordinate(6,8); //4,6 on board
	BlackPiece p1 = new BlackPiece(c1);
	BlackPiece p2 = new BlackPiece(c2);
	BlackPiece p3 = new BlackPiece(c3);
	BlackPiece[] pieces = new BlackPiece[] {p1,p2,p3};
	
	
	@Test 
	void testStartup(){
		assertEquals(p2.isWhite, false);
		assertEquals(p2.value, "2");
	}
	@Test
	void testcanMove() {
		b.populateBoard(pieces);
		b.print();
		assertTrue(p2.canMove(b));
		assertTrue(p3.canMove(b));
		assertFalse(p1.canMove(b));
	}
	
	@Test
	void testisMove() {
		b.populateBoard(pieces);
		b.print();
		assertTrue(p3.isMove(b,moveto2));
		assertFalse(p3.isMove(b,moveto1));
		
	}

}
