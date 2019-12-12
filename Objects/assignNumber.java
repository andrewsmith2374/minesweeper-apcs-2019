public class AssignNumber() {
	public static GridSquare assignNumber(GridSquare[][] mineField, int yCoord, int xCoord) {
		//Declare variables
		int startingX /*The starting column*/, endingX /*The ending column*/, startingY/*The starting row*/, endingY /*The ending row*/,
		GridSquare tile /*Individual mine*/;

		//Establish variables
		startingX = xCoord - 1;
		startingY = yCoord - 1;
		endingX = xCoord + 1;
		endingY = yCoord + 1;
		if(startingX <= 0) {
			startingX = 0;
		}
		if(startingY <= 0) {
			startingY = 0;
		}
		if(endingX >= mineField.length) {
			endingX = mineField.length - 1;
		}
		if(endingY >= mineField.length) {
			endingY = mineField.length - 1;
		}
	
		//Go through top and bottom
		for(int row = startingX; row < endingX; row++) {
			for(int column = startingY; column < endingY; column++) {
				tile = mineField[row][column];
				
			}
		}
	}
}