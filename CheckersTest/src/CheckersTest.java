import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CheckersTest {
	Board b = new Board();
	WhitePlayer white = new WhitePlayer();
	BlackPlayer black = new BlackPlayer();
	Turn t = new Turn();
	
	@Test
	void testTurnSwitch() {
		int i = 0;
		while(i<3) {
		switch(t.getSilentTurn()) {
		case "1":
			assertEquals(t.getSilentTurn(),"1");
			t.changeTurn();
			i++;
		break;
		case "2":
			assertEquals(t.getSilentTurn(), "2");
			t.changeTurn();
			i++;
		break;
		
		}
		}
	}

}
