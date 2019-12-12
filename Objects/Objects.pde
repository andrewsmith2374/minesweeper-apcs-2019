import java.lang.*;
void setup(){
  size(1000, 1000);
  fill(255, 204);
}
void draw(){
  
}
public static void main(String[] args){
	//Declare variables
	String nextMove /*Stores the next move in the game, either "lose" or "safe"*/;
	int length /*Length of the board*/, width /*Width of the board*/, numBombs /*Number of boms*/,
	userInput /*Store the user input as either 0 (step) or 1 (flag)*/,
	location /*Stores the location of the last square the player clicked*/,
	squaresLeft /*Stores the number of blank squares left*/;
	int[] inputAndLocation /*Stores the variables userInput and location*/;
	GridSquare[][] mineField;
	
	//Create the grid
	length = 20;
	width = 20;
	numBombs = 30
	mineField = makeGrid(mineField, length, width, numBombs); //Done
	squaresLeft = length * width;
	
	//Loop through and run game logic
	while(true) {
		//Gets the user input and input location and stores them in that order in a list of ints
		inputAndLocation = getUserInputAndLocation();
		userInput = inputAndLocation[0];
		location = inputAndLocation[1];
		
		//Run game logic on their choice
		nextMove = getResult(mineField, userInput, location);
		updateBoard(mineField, nextMove, userInput, location);
		drawBoard(mineField);
		
		if(nextMove.equals("lost")) {
			//End game
			gameOver(0);
		}
		else if(squaresLeft == 0) {
			//End game
			gameOver(1);
		}
	}
}
