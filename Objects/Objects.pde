import java.lang.*;
public static void main(String[] args){
	//Declare variables
	String nextMove /*Stores the next move in the game, either "win", "lose", or "safe"*/;
	int userInput /*Store the user input as either 0 (step) or 1 (flag)*/,
	location /*Stores the location of the last square the player clicked*/;
	int[] inputAndLocation /*Stores the variables userInput and location*/;
	GridSquare[][] mineField;
	
	//Create the grid
	mineField = new GridSquare[length][width
	mineField = makeGrid(20, 20, 30); //Done
	
	//Loop through and run game logic
	while(true) {
		//Gets the user input and input location and stores them in that order in a list of ints
		inputAndLocation = getUserInputAndLocation();
		userInput = inputAndLocation[0];
		location = inputAndLocation[1];
		
		//Run game logic on their choice
		nextMove = getResult(mineField, userInput, location);
		
		if(nextMove.equals("lost")) {
			//End game
			gameOver(0);
		}
		else if(nextMove.equals("win")) {
			//End game
			gameOver(1)
		}
	}
}
