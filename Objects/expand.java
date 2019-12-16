//Goes through adjacent tiles and looks for tiles with no bombs nearby
public class Expand() {
	public static void expand(GridSquare[][] mineField, int location) {
		//Declare variables
		int startingX /*The starting column*/, endingX /*The ending column*/, startingY/*The starting row*/, endingY /*The ending row*/,
			xCoord /*The x coordinate of the location*/, yCoord /*The y coordinate of the location*/;
		GridSquare tile /*Individual mine*/;

		//Get the x and y coordinates of the location
		yCoord = location / mineField.length;
		xCoord = location % yCoord;

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
				if(tile.getBombsNearby() == 0) {
					expand(mineField, location);
				}
				else {
					tile.show();
				}
			}
		}
	}
}