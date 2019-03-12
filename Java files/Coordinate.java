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