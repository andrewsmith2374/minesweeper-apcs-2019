PFont f;

boolean mouseClicked = false;

void setup() {
  int fieldLength = 600;
  int fieldWidth = 600;

  size(600, 600);
  fill(255, 255);
  f = createFont("Arial", 16, true);

  //Declare variables
  String nextMove /*Stores the next move in the game, either "lose" or "safe"*/;
  int length /*Length of the board*/, width /*Width of the board*/, numBombs /*Number of boms*/, 
    userInput = 0 /*Store the user input as either 0 (step) or 1 (flag)*/, 
    location = 0 /*Stores the location of the last square the player clicked*/, 
    squaresLeft /*Stores the number of blank squares left*/, 
    xVal = 0 /*Stores the x-coordinate of the mouse click*/, yVal = 0 /*Stores the y-coordinate of the mouse click*/;
  boolean inputReady = true /*Ready to take input*/;

  System.out.println("Start");

  //Create the grid
  length = 20;
  width = 20;
  numBombs = 159;
  GridSquare[][] mineField = new GridSquare[length][width];
  mineField = makeGrid.makeGrid(mineField, numBombs); //Done

  squaresLeft = length * width;

  for (int i = 0; i < mineField.length; i++) {
    for (int j = 0; j < mineField[i].length; j++ ) {
      System.out.println(mineField[i][j]);
    }
  }

  System.out.println("Stop");

  //Loop through and run game logic
  while (true) {
    //Gets the user input and input location and stores them in that order in a list of ints
    mouseClicked = false;
    inputReady = true;


    while (!mouseClicked) {
      mouseClicked = false;
    }


    //Get user input
    if (mouseClicked) {
      System.out.println("Input ready");
      xVal = mouseX;
      yVal = mouseY;
      if (mouseButton == LEFT) {
        userInput = 0;
      }
      if (mouseButton == RIGHT) {
        userInput = 1;
      }
    }
    location = (yVal / length) * width + (xVal / width);
    inputReady = false;

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
}

void draw() {
  fill(255);
  for (int i = 0; i < 20; i++) {
    for (int j = 0; j < 20; j++) {
      rect(30 * i, 30 * j, 30, 30);
    }
  }
  textFont(f, 16);
  fill(0);
  text("1", 11, 21);
}

void mousePressed() {
  mouseClicked = true;
  System.out.println("Click");
}
