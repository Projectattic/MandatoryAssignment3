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