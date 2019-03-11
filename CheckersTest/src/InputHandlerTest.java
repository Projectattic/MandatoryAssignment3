import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;
import java.io.*;

import org.junit.jupiter.api.Test;

class InputHandlerTest {
	InputHandler I = new InputHandler();
	Coordinate c = new Coordinate(3,4);
	Coordinate c2 = new Coordinate(4,3);
	Coordinate c3 = new Coordinate(5,3);
	
	@Test
	void testGetPiece() {
		Coordinate p = I.getPiece();
		// to be tested with the input "1 2"
	    assertTrue(c.equals(p));
	    assertFalse(c2.equals(p));
	}
	
	@Test
	void testGetMovePosition() {
		Coordinate p = I.getMovePosition();
		//to be tested with the input "2 1"s
	    assertTrue(c2.equals(p));
	    assertFalse(c3.equals(p));
		
	}
	
}


