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