import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TurnTest {
	Turn t = new Turn();
	@Test
	void testSetup() {
		assertNotNull(t.playerTurn);
		assertEquals(t.playerTurn,"1");
	}
	@Test
	void testGetTurnandSilent() {
		assertEquals(t.getSilentTurn(),"1");
		assertEquals(t.getTurn(),"1");
	}
	
	@Test
	void testChangeTurn() {
		assertEquals(t.getTurn(),"1");
		t.changeTurn();
		assertEquals(t.getTurn(), "2");
		t.changeTurn();
		assertEquals(t.getTurn(),"1");
	}
}
