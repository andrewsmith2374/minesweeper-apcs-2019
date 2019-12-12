//Each individual square
public class GridSquare {
	//squareLength and squareWidth are how big the square will be in pixels
	int squareLength = 0;
	int squareWidth = 0;
	int bombsNearby; //Number of bombs directly adjacent to this tile
	
	boolean bomb = false; //Status of the square, whether it is a bomb or not
	boolean shown = false; //The shown state of the bomb
	
	//Default constructor
	public GridSquare(){
		this.bomb = false;
	}
	
	//Constructor
	public GridSquare(boolean bomb, int squareLength, int squareWidth){
		this.bomb = bomb;
		this.squareLength = squareLength;
		this.squareWidth = squareWidth;
	}
	
	public int getWidth(){
		return this.squareWidth;
	}
	
	public int getLength(){
		return this.squareLength;
	}
	
	public int getBombsNearby() {
		return this.bombsNearby;
	}
	
	public boolean getBombStatus(){
		return this.bomb;
	}
	
	public void changeBombStatus(boolean bomb){
		this.bomb = bomb;
	}
	
	public void show() {
		this.shown = true;
	}

  public void changeLength(int squareLength){
    this.squareLength = squareLength;
  }
  
  public void changeWidth(int squareWidth){
    this.squareWidth = squareWidth;
  }
}
