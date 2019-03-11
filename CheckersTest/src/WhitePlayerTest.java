import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WhitePlayerTest {
	WhitePlayer p = new WhitePlayer();
	Board b = new Board();
	Coordinate c1 = new Coordinate(3,2);//1,0 on board
	Coordinate c2 = new Coordinate(2,2);//0,0 on board
	Coordinate c3 = new Coordinate(2,4);//0,2 on board
	Coordinate kaboom = new Coordinate(3,5);//1,3 on board
	
	@Test
	void testStartup() {
		assertTrue(p.isWhite);
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
		WhitePiece check = p.getPiece(c2);
		assertSame(check,p.pieces[0]);
		assertNotSame(check,p.pieces[1]);
	}
	
	@Test
	void testMovePiece() {
		p.setPieces();
		b.populateBoard(p.pieces);
		b.print();
		p.movePiece(c3, kaboom, b);
		b.populateBoard(p.pieces);
		b.print();
		assertEquals(b.getValue(kaboom),"1");
		assertEquals(b.getValue(c3)," ");
	}
}