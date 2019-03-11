import java.util.Arrays;

class Board {
	String[][] board = { { " ", " ", "0", "1", "2", "3", "4", "5", "6", "7", " " },
			{ " ", "+", "-", "-", "-", "-", "-", "-", "-", "-", "+" },
			{ "0", "|", " ", " ", " ", " ", " ", " ", " ", " ", "|" },
			{ "1", "|", " ", " ", " ", " ", " ", " ", " ", " ", "|" },
			{ "2", "|", " ", " ", " ", " ", " ", " ", " ", " ", "|" },
			{ "3", "|", " ", " ", " ", " ", " ", " ", " ", " ", "|" },
			{ "4", "|", " ", " ", " ", " ", " ", " ", " ", " ", "|" },
			{ "5", "|", " ", " ", " ", " ", " ", " ", " ", " ", "|" },
			{ "6", "|", " ", " ", " ", " ", " ", " ", " ", " ", "|" },
			{ "7", "|", " ", " ", " ", " ", " ", " ", " ", " ", "|" },
			{ " ", "+", "-", "-", "-", "-", "-", "-", "-", "-", "+" },
			{ " ", " ", "0", "1", "2", "3", "4", "5", "6", "7", " " } };

	public String getValue(Coordinate c) {
		return board[c.ycoord][c.xcoord];
	}

	public void setValue(Coordinate c, String s) {
		board[c.ycoord][c.xcoord] = s;
	}

	public void populateBoard(Piece[] pieces) {
		for (Piece p : pieces) {
			this.setValue(p.getCoordinates(), p.toString());
		}
	}

	public String toString() {
		return Arrays.deepToString(this.board).replace("], ", "\n").replace("[[", "").replace("]]", "").replace("[", "")
				.replace(",", "");
	}

	public void print() {
		System.out.println(this.toString());
	}
}