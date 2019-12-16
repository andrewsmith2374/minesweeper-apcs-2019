//Update board with inputs mineField, nextMove, userInput, location and return as updated mineField
public class updateBoard {
	public static GridSquare[][] updateBoard(GridSquare[][] mineField, String nextMove, int userInput, int location) {
		int xCoord /*The x coordinate of the location*/, yCoord /*The y coordinate of the location*/;
		GridSquare tile /*Individual mine*/;
	
		//Get the x and y coordinates of the location
		yCoord = location / mineField.length;
    if(yCoord > 0) {
      xCoord = location % yCoord;
    }
    xCoord = location;
	
		//Store the mine pressed
		tile = mineField[yCoord][xCoord];
		
		if(tile.getBombsNearby() == 0) {
			expand.expand(mineField, location);
		}
		else {
			tile.show();
		}
    return mineField;
	}
}
