import java.lang.*;
public class GridSquare {
  //squareLength and squareWidth are how big the square will be in pixels
  int squareLength = 0;
  int squareWidth = 0;
  //status of the square, whether it is a bomb or not
  boolean bomb = false;
  public GridSquare(){//default constructor
    this.bomb = false;
    this.squareLength = 50;
    this.squareWidth = 50;
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
}
public static void main(String[] args){
  //generates a mineField, 20 by 20 out of object GridSquare
  GridSquare[][] mineField = new GridSquare[20][20];
  for(int i = 0; i < 30; i++){//randomly setting 30 squares to be bombs
    boolean test = true;
    int x = (int)Math.random();
    int y = (int)Math.random();
    while(test){
      if((x < mineField.length && x > 0) && (y < mineField[0].length && y > 0)){//making sure that the random number is in range of mineField
        if(mineField[x][y].getBombStatus() == false){//testing to see whether this square is already a bomb
          mineField[x][y].changeBombStatus(true);
          test = false;
        }
        else{
          x = (int)Math.random();
          y = (int)Math.random();
        }
      }
      else{
        x = (int)Math.random();
        y = (int)Math.random();
      }
    }
  }
  
}
