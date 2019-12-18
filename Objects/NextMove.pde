/*public class NextMove {
  public static void nextMove() {
    //Gets the user input and input location and stores them in that order in a list of ints
    //Get user input
    xVal = mouseX;
    yVal = mouseY;
    if (mouseButton == LEFT) {
      userInput = 0;
    }
    if (mouseButton == RIGHT) {
      userInput = 1;
    }
    location = (yVal / length) * width + (xVal / width);
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
}*/
