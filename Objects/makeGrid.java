import java.util.Random;
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
	
	for(int row = 0; i < mineField.length; row++) {
		for(int col = 0; col < mineField[0].length; col++) {
			mineField[row][col].setCoordinates(row, col);
			mineField[row][col].assignNumber(mineField);
		//Go through grid, creating new tiles
		for(int row = 0; row < mineField.length; row++) {
			for(int col = 0; col < mineField[row].length; col++) {
				mineField[row][col] = new GridSquare(20, 20, col, row);
			}
		}
		
		System.out.println("Making minefield");
		
		//Adds in numBombs number of bombs
		Random rand = new Random();
		
		for(int i = 0; i < numBombs; i++) {			
			tile = mineField[rand.nextInt(mineField.length - 1)][rand.nextInt(mineField[0].length - 1)];
			if(tile.getBombStatus()) {
				i--;
			}
			else {
				tile.setBombStatus(true);
			}
		}
		
		//Sets the number of bombs nearby
		for(int row = 0; row < mineField.length; row++) {
			for(int col = 0; col < mineField[0].length; col++) {
				mineField[row][col].setCoordinates(row, col);
				mineField[row][col].assignNumber(mineField);
			}
		}
		
		return mineField;
	}
}
