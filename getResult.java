//Takes the GridSquare[][] mineField, the user input, and location of input and returns a String either saying "lose" or "safe".
public static String getResult(GridSquare[][] mineField, int input, int location) {
	//Declare variables
	int xCoord /*The x coordinate of the location*/, yCoord /*The y coordinate of the location*/;
	GridSquare mine /*Individual mine*/
	
	//Get the x and y coordinates of the location
	yCoord = location / mineField.length;
	xCoord = location % yCoord;
	
	//Store the mine pressed
	mine = mineField[yCoord][xCoord];
	
	//Find what happens! This is where the fun begins
	if(mine.getBombStatus) {
		return "lose";
	}
	return "safe";
}