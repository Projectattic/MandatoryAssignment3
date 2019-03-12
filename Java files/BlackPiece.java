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
