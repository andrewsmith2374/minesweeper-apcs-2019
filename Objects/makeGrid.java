import java.util.Random;

//Generates a mineField, 20 by 20 out of object GridSquare, returns as GridSquare[][]
public class makeGrid {
	public static GridSquare[][] makeGrid(GridSquare[][] mineField, int numBombs) {
		//Declare variables
		GridSquare tile /*Individual mine*/;
		
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
