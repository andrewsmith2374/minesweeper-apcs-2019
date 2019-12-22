//Goes through adjacent tiles and looks for tiles with no bombs nearby
public class expand {
  public static void expand(GridSquare[][] mineField, int location) {
    //Declare variables
    int startingX /*The starting column*/, endingX /*The ending column*/, startingY/*The starting row*/, endingY /*The ending row*/, 
      xCoord/*The x coordinate of the location*/, yCoord /*The y coordinate of the location*/;
    GridSquare tile /*Individual mine*/;

    //Get the x and y coordinates of the location
    yCoord = location / mineField.length;
    xCoord = location % mineField.length;

    //Establish variables
    startingX = xCoord - 1;
    startingY = yCoord - 1;
    endingX = xCoord + 1;
    endingY = yCoord + 1;
    
    //making sure the x and y coordinates are on the grid
    if (xCoord <= 0) {
      startingX = 0;
    }
    if (yCoord <= 0) {
      startingY = 0;
    }
    if (xCoord >= mineField.length - 1) {
      endingX = mineField.length - 1;
    }
    if (yCoord >= mineField.length - 1) {
      endingY = mineField.length - 1;
    }

    System.out.println("Location: " + location + "\nX-coordinate: " + xCoord + " Starting X: " + startingX + " Ending X: " + endingX + "\nY-coordinate: " + yCoord + " StartingY: " + startingY + " EndingY: " + endingY);

    //Go through top and bottom
    //Going through all tiles around it and exanding if there are no bombs nearby
    for (int row = startingY; row <= endingY; row++) {
      for (int column = startingX; column <= endingX; column++) {
        if (!(row == yCoord && column == xCoord)) {
          tile = mineField[row][column];
          tile.show();
          location = row * mineField.length + column;
          if (tile.getBombsNearby() == 0 && !tile.getShownStatus()) {
            expand(mineField, location);
          }
        }
      }
    }
  }
}
