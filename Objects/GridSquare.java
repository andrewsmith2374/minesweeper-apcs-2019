//Each individual square
public class GridSquare {
	//squareLength and squareWidth are how big the square will be in pixels
	int squareLength = 0;
	int squareWidth = 0;
	int bombsNearby; //Number of bombs directly adjacent to this tile
	
	boolean bomb = false; //Status of the square, whether it is a bomb or not
	
	//Default constructor
	public GridSquare(){
		this.bomb = false;
		this.squareLength = 50;
		this.squareWidth = 50;
	}
	
	//Constructor
	public GridSquare(boolean bomb, int squareLength, int squareWidth){
		this.bomb = bomb;
		this.squareLength = squareLength;
		this.squareWidth = squareWidth;
	}
	
	public int getWidth(){
		return squareWidth;
	}
	
	public int getLength(){
		return squareLength;
	}
	
	public int getBombsNearby() {
		return bombsNearby;
	}
	
	public boolean getBombStatus(){
		return bomb;
	}
	
	public void changeBombStatus(boolean bomb){
		this.bomb = bomb;
	}
}
