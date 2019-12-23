PFont f;
  GridSquare[][] mineField = new GridSquare[20][20];

boolean mouseClicked = false;

void setup() {
  int fieldLength = 600;
  int fieldWidth = 600;

  size(600, 600);
  fill(255, 255);
  f = createFont("Arial", 16, true);

  //Declare variables
  int length /*Length of the board*/, width /*Width of the board*/, numBombs /*Number of boms*/;

  //Create the grid
  length = 20;
  width = 20;
  numBombs = 50;
  mineField = makeGrid.makeGrid(mineField, numBombs); //Done
}

static boolean bombClicked = false;
static int bomb_i = -1;
static int bomb_j = -1;
static boolean lostGame = false;
static boolean wonGame = false;
static int numOfSquares = 0;

void draw() {
  textFont(f, 16);
  fill(0);

//draw the board
  if(bombClicked == false){
    for (int j = 0; j < 20; j++) {
      for (int i = 0; i < 20; i++) {
          fill(255);
          rect(30 * j, 30 * i, 30, 30);
      }
    }
  }
  
  //draw all shown tiles and flags after losing
  else
  {
    if(!lostGame || !wonGame){
      for (int k = 0; k < 20; k++) {
         for (int l = 0; l < 20; l++) {
           
           //draw out bombs
           if(mineField[k][l].getBombStatus()){
              fill(0);
              rect(30 * l, 30 * k, 30, 30);
           }
           
           //draw shown tiles and number of bombs
           else if(mineField[k][l].getShownStatus()){
             fill(100);
             rect(30 * l, 30 * k, 30, 30);
             if(mineField[k][l].getBombsNearby() != 0){
               fill(0);
               text(mineField[k][l].getBombsNearby(), 30 * l + 11, 30 * k + 21);
             }
             lostGame = true;
           }
         }
      }
      
      
      fill(255);
      text("X", 30 * bomb_j + 11, 30 * bomb_i + 21);
    }

  }
  

//update gameboard with shown tiles and flags
  for (int j = 0; j < mineField.length && !bombClicked; j++) {
    for (int i = 0; i < mineField[j].length && !bombClicked; i++) {
      
      // if clicked on bomb, set bombClicked to true
      if (mineField[i][j].getBombStatus() && mineField[i][j].getShownStatus())
      {
          bombClicked = true;
          bomb_i = i;
          bomb_j = j;
      }
      
      //draw shown tiles
      else if (mineField[i][j].getShownStatus()){
        fill(100);
        rect(30 * j, 30 * i, 30, 30);
        if(mineField[i][j].getBombsNearby() == 0){
          expand.expand(mineField, i * mineField.length + j);
        }
        else{
          fill(0);
          text(mineField[i][j].getBombsNearby(), 30 * j + 11, 30 * i + 21);
        }
      }
      
      //draw flags
      if(mineField[i][j].getFlagStatus()){
        fill(255, 0, 0);
        rect(30 * j, 30 * i, 30, 30);
      }
    }
  }
  
  //check to see if the player has won yet
  loop:
    for (int j = 0; j < mineField.length && !bombClicked; j++) {
      for (int i = 0; i < mineField[j].length && !bombClicked; i++) {
        if(mineField[i][j].getFlagStatus() || mineField[i][j].getShownStatus()){
          numOfSquares++;
        }
        else{
          numOfSquares = 0;
          break loop;
        }
      }
    }
    
  if(numOfSquares == 400){
    background(0);
    text("You Win!", 300, 300);
  }

}

void mousePressed() {
  nextMove(mouseX, mouseY, mouseButton, mineField);
}

public static void nextMove(int mouseX, int mouseY, int mouseButton, GridSquare[][] mineField) {
  //Gets the user input and input location and stores them in that order in a list of ints
  //Declare variables
  String nextMove /*Stores the next move in the game, either "lose" or "safe"*/;
  int userInput = 0 /*Store the user input as either 0 (step) or 1 (flag)*/, 
  location = 0 /*Stores the location of the last square the player clicked*/, 
  squaresLeft = 400 /*Stores the number of blank squares left*/, 
  xVal = 0 /*Stores the x-coordinate of the mouse click*/, yVal = 0 /*Stores the y-coordinate of the mouse click*/,
  length = mineField.length, width = mineField[0].length;
  boolean inputReady = true /*Ready to take input*/;

  //Get user input
  xVal = mouseX;
  yVal = mouseY;
  
  if (mouseButton == LEFT) {//Left Click
    userInput = 0;
  }
  else if (mouseButton == RIGHT) { //Right Click
    userInput = 1;
  }
  
  //set location of mouse cursor
  location = (yVal / 30) * width + (xVal / 30);
  inputReady = false;
  System.out.println(location);

  //Run game logic on their choice
  nextMove = getResult.getResult(mineField, userInput, location); //Done
  if (nextMove.equals("safe")) {
    squaresLeft--;
  }

  //Update board and return as mineField
  mineField = updateBoard.updateBoard(mineField, userInput, location); //Done?

  if (nextMove.equals("lost")) {
    //End game
    GameOver.gameOver(0);
  } else if (squaresLeft == 0) {
    //End game
    GameOver.gameOver(1);
  }
}
