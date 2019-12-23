//Takes the GridSquare[][] mineField, the user input, and location of input and returns a String either saying "lose" or "safe".

public class getResult {
	public static String getResult(GridSquare[][] mineField, int input, int location) {
		//Declare variables
		int xCoord = 0 /*The x coordinate of the location*/, yCoord /*The y coordinate of the location*/;
		GridSquare tile /*Individual mine*/;

    String gameStatus = "safe"; //Whether the player is safe or lost
	    
		//Get the x and y coordinates of the location

		yCoord = location / mineField.length;
    xCoord = location % mineField.length;
    //xCoord = location;
    //xCoord /= mineField[0].length;
	  
		//Store the mine pressed

		tile = mineField[yCoord][xCoord];
    
	
		//Find what happens! This is where the fun begins
    if(input == 1) { //Right click
      if(tile.getFlagStatus()){
        tile.takeAwayFlag();
        tile.hide();
      }
      else{
        tile.flag();
      }
    }
    else { //Left click
      tile.show();
      if(tile.getBombStatus()) {
        gameStatus = "lose";
      }
    }
    return gameStatus;
	}
}
