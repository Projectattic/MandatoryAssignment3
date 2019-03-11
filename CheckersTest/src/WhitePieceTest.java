import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WhitePieceTest {
	Board b = new Board();
	Coordinate c1 = new Coordinate(2,2);//0,0 on board
	Coordinate c2 = new Coordinate(4,2);//2,0 on board
	Coordinate c3 = new Coordinate(3,3); //1, 1 on board
	Coordinate moveto1 = new Coordinate(3,3);
	Coordinate moveto2 = new Coordinate(5,3); //3,1 on board
	WhitePiece p1 = new WhitePiece(c1);
	WhitePiece p2 = new WhitePiece(c2);
	WhitePiece p3 = new WhitePiece(c3);
	WhitePiece[] pieces = new WhitePiece[] {p1,p2,p3};
	
	@Test 
	void testStartup(){
		assertEquals(p2.isWhite, true);
		assertEquals(p2.value, "1");
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
		assertTrue(p2.isMove(b,moveto2));
		assertFalse(p2.isMove(b,moveto1));
	}

}

