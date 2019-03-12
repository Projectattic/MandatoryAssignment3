import java.util.Scanner;
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
