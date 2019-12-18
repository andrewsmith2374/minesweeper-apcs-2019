//Each individual square
public class GridSquare {
	//squareLength and squareWidth are how big the square will be in pixels
	int squareLength = 0;
	int squareWidth = 0;
	int xCoord; //The x coordinate of the tile
	int yCoord; //The y coordinate of the tile
	int bombsNearby; //Number of bombs directly adjacent to this tile
	
	boolean bomb = false; //Status of the square, whether it is a bomb or not
	boolean shown = true; //The shown state of the bomb
  boolean flagged = false;
	
	//Default constructor
	public GridSquare(){
		this.bomb = false;
	}
	
	//Constructors
	public GridSquare(int squareLength, int squareWidth, int xCoord, int yCoord){
		this.squareLength = squareLength;
		this.squareWidth = squareWidth;
		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}
	
	public GridSquare(boolean bomb, int squareLength, int squareWidth, int xCoord, int yCoord){
		this.bomb = bomb;
		this.squareLength = squareLength;
		this.squareWidth = squareWidth;
		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}
	
	//Printing object
	public String toString() {
		if(this.bomb) {
			return "Bomb";
		}
		return "" + this.bombsNearby;
	}
	
	//Return the width of the tile
	public int getWidth(){
		return this.squareWidth;
	}
	
	//Return the length of the tile
	public int getLength(){
		return this.squareLength;
	}
	
	//Changes the length of the tile
	public void changeLength(int squareLength){
		this.squareLength = squareLength;
	}
  	
	//Changes the width of the tile
	public void changeWidth(int squareWidth){
		this.squareWidth = squareWidth;
	}
	
	//Sets the coordinates of the tile
	public void setCoordinates(int yCoord, int xCoord) {
		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}
	
	//Returns whether the tile is a bomb or not
	public boolean getBombStatus(){
		return this.bomb;
	}
	
	//Sets the bomb status
	public void setBombStatus(boolean bomb){
		this.bomb = bomb;
	}
	
	//Shows the tile
	public void show() {
		this.shown = true;
	}

	//Return the number of bombs nearby
	public int getBombsNearby() {
		return this.bombsNearby;
	}

  public boolean getShownStatus(){
    return this.shown;
  }

  //Flags the tile
  public void flag() {
    this.flagged = true;
  }

	//Sets the number of bombs around the tile
	public void assignNumber(GridSquare[][] mineField) {
		//Declare variables
		int startingX /*The starting column*/, endingX /*The ending column*/, startingY/*The starting row*/, endingY /*The ending row*/, bombsNearby /*The number of bombs nearby*/;
		GridSquare tile /*Individual mine*/;

		//Establish variables
		startingX = this.xCoord - 1;
		startingY = this.yCoord - 1;
		endingX = this.xCoord + 1;
		endingY = this.yCoord + 1;
		if(startingX <= 0) {
			startingX = 0;
		}
		if(startingY <= 0) {
			startingY = 0;
		}
		if(endingX >= mineField.length) {
			endingX = mineField.length - 1;
		}
		if(endingY >= mineField.length) {
			endingY = mineField.length - 1;
		}
    	bombsNearby = 0;
		
		if(this.getBombStatus()) {
			this.bombsNearby = 9;
		}
		else {
			//Go through top and bottom
			for(int row = startingX; row < endingX; row++) {
				for(int column = startingY; column < endingY; column++) {
					tile = mineField[row][column];
					if(tile.getBombStatus()) {
						bombsNearby++;
					}
				}
			}
		}
		this.bombsNearby = bombsNearby;
	}
}
