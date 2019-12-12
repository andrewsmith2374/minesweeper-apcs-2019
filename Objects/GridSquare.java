//Each individual square
public class GridSquare {
	//squareLength and squareWidth are how big the square will be in pixels
	int squareLength = 50;
	int squareWidth = 50;
	boolean bomb = false; //Status of the square, whether it is a bomb or not
	
	//Default constructor
	public GridSquare(){
		this.bomb = false;
	}
	
	public GridSquare(boolean bomb, int squareLength, int squareWidth){//constructor
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
	
	public boolean getBombStatus(){
		return bomb;
	}
	
	public void changeBombStatus(boolean bomb){
		this.bomb = bomb;
	}

  public void changeLength(int squareLength){
    this.squareLength = squareLength;
  }
  
  public void changeWidth(int squareWidth){
    this.squareWidth = squareWidth;
  }

}
