public class Turn{
	String playerTurn = "1";

	public String getTurn() {
		System.out.println("It is player " + playerTurn + "'s turn");
		return playerTurn;
	}
	
	public String getSilentTurn() {
		return playerTurn;
	}

	public void changeTurn() {
		if (playerTurn == "1") {
			playerTurn = "2";
		} else {
			playerTurn = "1";
		}
	}

}
