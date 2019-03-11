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