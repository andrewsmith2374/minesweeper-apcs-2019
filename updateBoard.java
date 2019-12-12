//Update board with inputs mineField, nextMove, userInput, location and return as updated mineField
public class UpdateBoard() {
	public static GridSquare[][] updateBoard(GridSquare[][] mineField, String nextMove, int userInput, int location) {
		int xCoord /*The x coordinate of the location*/, yCoord /*The y coordinate of the location*/;
		GridSquare tile /*Individual mine*/;
	
		//Get the x and y coordinates of the location
		yCoord = location / mineField.length;
		xCoord = location % yCoord;
	
		//Store the mine pressed
		tile = mineField[yCoord][xCoord];
		
		if(tile.get()) {
			
		}
	}
}
