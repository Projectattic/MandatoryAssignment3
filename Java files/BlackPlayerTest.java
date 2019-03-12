import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BlackPlayerTest {
	BlackPlayer p = new BlackPlayer();
	Board b = new Board();
	Coordinate c1 = new Coordinate(9,8);//7,6 on board
	Coordinate c2 = new Coordinate(9,9);//7,7 on board
	Coordinate c3 = new Coordinate(7,7);//5,7 on board
	Coordinate kaboom = new Coordinate(6,6);
	
	@Test
	void testStartup() {
		assertFalse(p.isWhite);
	}
	
	@Test
	void testLengthPiecesArray() {
		assertNotNull(p.pieces);
		assertEquals(p.pieces.length,12);
	}
	
	@Test
	void testCheckPiece() {
		p.setPieces();
		b.populateBoard(p.pieces);
		b.print();
		assertFalse(p.checkPiece(c1, b));
		assertTrue(p.checkPiece(c2,b));
		}

	@Test
	void testGetPiece() {
		p.setPieces();
		BlackPiece check = p.getPiece(c2);
		assertSame(check,p.pieces[3]);
		assertNotSame(check,p.pieces[2]);
	}
	
	@Test
	void testMovePiece() {
		p.setPieces();
		b.populateBoard(p.pieces);
		b.print();
		p.movePiece(c3, kaboom, b);
		b.populateBoard(p.pieces);
		b.print();
		assertEquals(b.getValue(kaboom),"2");
		assertEquals(b.getValue(c3)," ");
	}
}
