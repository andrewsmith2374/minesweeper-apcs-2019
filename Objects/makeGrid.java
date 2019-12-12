//Generates a mineField, 20 by 20 out of object GridSquare, returns as GridSquare[][]
public static class Grid(){
  public static GridSquare[][] makeGrid(GridSquare[][] mineField, int numBombs) {
  	//randomly setting numBombs squares to be bombs
  	for(int i = 0; i < numBombs; i++){
  		boolean test = true;
  		int x = (int)Math.random();
  		int y = (int)Math.random();
  		while(test){
  			//Making sure that the random number is in range of mineField
  			if((x < mineField.length && x > 0) && (y < mineField[0].length && y > 0)){
  				//Testing to see whether this square is already a bomb
  				if(mineField[x][y].getBombStatus() == false){
  					mineField[x][y].changeBombStatus(true);
  					test = false;
  				}
  			}
  		  x = (int)Math.random();
  			y = (int)Math.random();
  		}
  	}
  	return mineField;
  }
}
