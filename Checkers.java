import java.util.Arrays;
import java.util.Scanner;

abstract class Player {
	boolean isWhite;
}

class WhitePlayer extends Player {

	public WhitePlayer() {
		this.isWhite = true;
	}

	WhitePiece[] pieces = new WhitePiece[12];

	public void setPieces() {
		int i = 0;
		for (int y = 2; y < 5; y++) {
			if (y % 2 == 0) {
				for (int x = 2; x < 9; x = x + 2) {
					Coordinate c = new Coordinate(x, y);
					pieces[i] = new WhitePiece(c);
					i++;
				}
			} else {
				for (int x = 3; x < 10; x = x + 2) {
					Coordinate c = new Coordinate(x, y);
					pieces[i] = new WhitePiece(c);
					i++;
				}
			}
		}
	}

	public boolean checkPiece(Coordinate c, Board b) {
		if (b.getValue(c) == "1") {
			return true;
		} else {
			System.out.println("Please select one of your pieces");
			return false;
		}
	}

	public WhitePiece getPiece(Coordinate c) {
		for (WhitePiece p : this.pieces) {
			if (p.getCoordinates().equals(c)) {
				return p;
			}
		}
		return null;
	}

	public void movePiece(Coordinate piecetomove, Coordinate c,Board b) {
		this.getPiece(piecetomove).moveTo(c);
		b.setValue(piecetomove, " ");
	}

}

class BlackPlayer extends Player {
	public BlackPlayer() {
		this.isWhite = false;
	}

	BlackPiece[] pieces = new BlackPiece[12];

	public void setPieces() {
		int i = 0;
		for (int y = 9; y > 6; y--) {
			if (y % 2 == 0) {
				for (int x = 2; x < 9; x = x + 2) {
					Coordinate c = new Coordinate(x, y);
					pieces[i] = new BlackPiece(c);
					i++;
				}
			} else {
				for (int x = 3; x < 10; x = x + 2) {
					Coordinate c = new Coordinate(x, y);
					pieces[i] = new BlackPiece(c);
					i++;
				}
			}
		}
	}

	public boolean checkPiece(Coordinate c, Board b) {
		if (b.getValue(c) == "2") {
			return true;
		} else {
			System.out.println("Please select one of your pieces");
			return false;
		}
	}

	public BlackPiece getPiece(Coordinate c) {
		for (BlackPiece p : this.pieces) {
			if (p.getCoordinates().equals(c)) {
				return p;
			}
		}
		return null;
	}

	public void movePiece(Coordinate piecetomove, Coordinate c, Board b) {
		this.getPiece(piecetomove).moveTo(c);
		b.setValue(piecetomove, " ");
	}
}

abstract class Piece {
	boolean isWhite;
	Coordinate c;
	String value;

	public void moveTo(Coordinate moveto) {
		this.c = moveto;
	}

	public Coordinate getCoordinates() {
		return c;
	}
	
	public String toString() {
		return this.value;
	}
}

class WhitePiece extends Piece {
	public WhitePiece(Coordinate cord) {
		this.isWhite = true;
		this.value = "1";
		this.c = new Coordinate(cord.xcoord, cord.ycoord);
	}



	public boolean canMove(Board b) {
		boolean canMove = false;
		Coordinate[] posscord = new Coordinate[2];
		posscord[0] = new Coordinate(c.xcoord + 1, c.ycoord + 1);
		posscord[1] = new Coordinate(c.xcoord -1 , c.ycoord + 1);
		if ((b.getValue(posscord[0])==" ") | (b.getValue(posscord[1])== " ")) {
			canMove = true;
		}
		if (canMove == false) {
			System.out.println("That piece can't move");
		}
		return canMove;
	}
	
	public boolean isMove(Board b, Coordinate moveto) {
		if (((moveto.xcoord ==this.c.xcoord+1||moveto.xcoord == this.c.xcoord-1)&&(moveto.ycoord == this.c.ycoord+1))&&b.getValue(moveto)== " ") {
			return true;
		} else {
			System.out.println("That's not a move you can make");
			return false;
		}
	}
}

class BlackPiece extends Piece {
	public BlackPiece(Coordinate cord) {
		this.isWhite = false;
		this.value = "2";
		this.c = new Coordinate(cord.xcoord, cord.ycoord);
	}

	public boolean canMove(Board b) {
		boolean canMove = false;
		Coordinate[] posscord = new Coordinate[2];
		posscord[0] = new Coordinate(c.xcoord + 1, c.ycoord - 1);
		posscord[1] = new Coordinate(c.xcoord - 1, c.ycoord - 1);

		if (b.getValue(posscord[0])==" " | b.getValue(posscord[1])== " ") {
			canMove = true;
		}
		if (canMove == false) {
			System.out.println("That piece can't move");
		}
		return canMove;
	}
	
	public boolean isMove(Board b, Coordinate moveto) {
		if (((moveto.xcoord ==this.c.xcoord+1||moveto.xcoord == this.c.xcoord-1)&&(moveto.ycoord == this.c.ycoord-1))&&b.getValue(moveto)== " ") {
			return true;
		} else {
			System.out.println("That's not a move you can make");
			return false;
		}
	}
}

class Coordinate {
	int xcoord;
	int ycoord;

	public Coordinate(int x, int y) {
		this.xcoord = x;
		this.ycoord = y;
	}

	public boolean checkCoordinate() {
		if (((this.xcoord >= 2) && (this.xcoord <= 10)) && ((this.ycoord >= 2) && (this.ycoord <= 9))) {
			return true;
		} else {
			System.out.println("Please select a valid coordinate");
			return false;
		}
	}

	public boolean equals(Coordinate c) {
		if ((this.xcoord == c.xcoord) && (this.ycoord == c.ycoord)) {
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		return Integer.toString(xcoord)+","+Integer.toString(ycoord);
	}

}

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

class InputHandler {
	Scanner s = new Scanner(System.in);

	public Coordinate getPiece() {
		System.out.println(
				"Please select a piece to move by entering the x coordinate, followed by a space, then the y coordinate \n");
		String line = s.nextLine();
		String[] coord = line.split(" ");
		Coordinate c = new Coordinate(Integer.valueOf(coord[0]) + 2, Integer.valueOf(coord[1]) + 2);
		return c;
	}

	public Coordinate getMovePosition() {
		System.out.println("Please enter the coordinate to which you want to move that piece by entering the x coordinate, followed by a space, then the y coordinate \n");
		String line = s.nextLine();
		String[] coord = line.split(" ");
		System.out.println(coord[0]+" "+coord[1]);
		int xcoord = Integer.valueOf(coord[0]);
		int ycoord = Integer.valueOf(coord[1]);
		Coordinate c = new Coordinate(xcoord+2,ycoord+2);
		return c;
	}
}

class Turn {
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

public class Checkers {
	public static void main(String[] args) {
		System.out.println("Benjamin Jepsen s184374 - Agile Object-Oriented Software Development - Mandatory Assignment 3 \n");
		System.out.println("Welcome to Checkers \n");
		Board b = new Board();
		WhitePlayer white = new WhitePlayer();
		white.setPieces();
		BlackPlayer black = new BlackPlayer();
		black.setPieces();
		InputHandler I = new InputHandler();
		Turn t = new Turn();
		  while(true) {
			  b.populateBoard(white.pieces);
			  b.populateBoard(black.pieces);
			  b.print(); 
			  switch (t.getTurn()) { 
			  case "1":
				  while (t.getSilentTurn()== "1") {
				  Coordinate piecetomove = I.getPiece();
				  if (piecetomove.checkCoordinate()) {
					  if(white.checkPiece(piecetomove, b)) {
						  if(white.getPiece(piecetomove).canMove(b)) {
							  Coordinate moveto = I.getMovePosition();
							  if (moveto.checkCoordinate()) {
								  if (white.getPiece(piecetomove).isMove(b,moveto)) {
									  white.movePiece(piecetomove, moveto,b);
									  t.changeTurn();
								  }
								  }
						   }
					  }
				  	}
				  }
			  break; 
			  case "2":
				  while (t.getSilentTurn()=="2") {
				  Coordinate piecetomov = I.getPiece();
				  if (piecetomov.checkCoordinate()) {
					  if(black.checkPiece(piecetomov, b)) {
						  if(black.getPiece(piecetomov).canMove(b)) { 
							  Coordinate moveto = I.getMovePosition();
							  if (moveto.checkCoordinate()) {
								  if (black.getPiece(piecetomov).isMove(b,moveto)) {
									  black.movePiece(piecetomov, moveto,b);
									  t.changeTurn();
								  }
								  }
							  }
						  }
					  }
				  }
				  break;
				  }
		  
		  }
		 
	}
}
