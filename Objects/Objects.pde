public class Objects {
	public static void main(String[] args){
		//Declare variables
		String nextMove /*Stores the next move in the game, either "lose" or "safe"*/;
		int length /*Length of the board*/, width /*Width of the board*/, numBombs /*Number of boms*/,
		userInput /*Store the user input as either 0 (step) or 1 (flag)*/,
		location /*Stores the location of the last square the player clicked*/,
		squaresLeft /*Stores the number of blank squares left*/;
		int[] inputAndLocation /*Stores the variables userInput and location*/;
		GridSquare[][] mineField = new GridSquare[20][20];
		
		System.out.println("Start");
	
		//Create the grid
		length = 20;
		width = 20;
		numBombs = 30;
		mineField = MakeGrid.makeGrid(mineField, numBombs); //Done
				
		squaresLeft = length * width;
		
		for(int i = 0; i < mineField.length; i++) {
			for(int j = 0; j < mineField[i].length; j++ ) {
				System.out.println(mineField[i][j]);
			}
		}
		
		System.out.println("Stop");
	
	/*
		//Loop through and run game logic
		while(true) {
			//Gets the user input and input location and stores them in that order in a list of ints
			inputAndLocation = getUserInputAndLocation();
			userInput = inputAndLocation[0];
			location = inputAndLocation[1];
		
			//Run game logic on their choice
			nextMove = getResult(mineField, userInput, location); //Done
			if(nextMove = "safe") {
				squaresLeft--;
			}
		
			//Update board and return as mineField
			mineField = updateBoard(mineField, nextMove, userInput, location); //Done?
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
	*/
	}
}