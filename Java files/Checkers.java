
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
