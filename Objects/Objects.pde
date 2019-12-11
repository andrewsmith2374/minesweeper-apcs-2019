import java.lang.*;
public class GridSquare {
  int squareLength = 0;
  int squareWidth = 0;
  boolean bomb = false;
  public GridSquare(){
    this.bomb = false;
    this.squareLength = 50;
    this.squareWidth = 50;
  }
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
  public boolean getBombStatus(){
    return bomb;
  }
}
public static void main(String[] args){
  GridSquare[][] mineField = new GridSquare[20][20];
  for(int i = 0; i < 30; i++){
    boolean test = false;
    int x = (int)Math.random();
    while(test){
      if(x < mineField.length && x > 0){
        
      }
    }
  }
}
