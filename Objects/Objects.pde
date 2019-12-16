PFont f;
void setup(){
  size(600, 600);
  fill(255, 255);
  f = createFont("Arial",16,true);

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
    numBombs = 159;
    mineField = makeGrid.makeGrid(mineField, numBombs); //Done
        
    squaresLeft = length * width;
    
    for(int i = 0; i < mineField.length; i++) {
      for(int j = 0; j < mineField[i].length; j++ ) {
        System.out.println(mineField[i][j]);
      }
    }
    
    System.out.println("Stop");
  
  
    int x = 0;
    
    //Loop through and run game logic
    while(x < 1) {
      //Gets the user input and input location and stores them in that order in a list of ints
      //inputAndLocation = getUserInputAndLocation();
      //userInput = inputAndLocation[0];
      //location = inputAndLocation[1];
      
      userInput = 0;
      location = 1;
    
      //Run game logic on their choice
      nextMove = getResult.getResult(mineField, userInput, location); //Done
      if(nextMove.equals("safe")) {
        squaresLeft--;
      }
    
      //Update board and return as mineField
      mineField = updateBoard.updateBoard(mineField, nextMove, userInput, location); //Done?
      draw();
    
      if(nextMove.equals("lost")) {
        //End game
        GameOver.gameOver(0);
      }
      else if(squaresLeft == 0) {
        //End game
        GameOver.gameOver(1);
      }
      x++;
    }
  
}
void draw(){
  fill(255);
  for(int i = 0; i < 20; i++){
    for(int j = 0; j < 20; j++){
      rect(30 * i, 30 * j, 30, 30);
    }
  }
  textFont(f,16);
  fill(0);
  text("1", 11, 21);
}/*
public class Objects {
	public static void main(String[] args){
		
	}
}*/
