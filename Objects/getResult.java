//Takes the GridSquare[][] mineField, the user input, and location of input and returns a String either saying "lose" or "safe".
public class getResult {
	public static String getResult(GridSquare[][] mineField, int input, int location) {
		//Declare variables
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
	
		//Find what happens! This is where the fun begins
    if(input == 0) { //Right click
      tile.flag();
      return "safe";
    }
    else { //Left click
      if(tile.getBombStatus()) {
      return "lose";
      }
      return "safe";
    }
	}
}
