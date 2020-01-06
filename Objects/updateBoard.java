//Update board with inputs mineField, nextMove, userInput, location and return as updated mineField
public class updateBoard {
  public static GridSquare[][] updateBoard(GridSquare[][] mineField, int userInput, int location) {
    int xCoord = 0 /*The x coordinate of the location*/, yCoord /*The y coordinate of the location*/;
    GridSquare tile /*Individual mine*/;

    //Get the x and y coordinates of the location
    yCoord = location / mineField.length;
    xCoord = location % mineField.length;
    //xCoord = location;
    //xCoord /= mineField[0].length;

    //Store the mine pressed
    tile = mineField[yCoord][xCoord];

    if(userInput == 0) { //Left click
      if (tile.getBombsNearby() == 0 && !tile.getBombStatus()) {
        expand.expand(mineField, location);
      }
      tile.show();
    }
    return mineField;
  }
}
