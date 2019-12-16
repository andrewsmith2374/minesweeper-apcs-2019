//Used when the game ends, results in either a win or a loss
public class GameOver() {
	public static void gameOver(int gameResult) {
		//Loss
		if(gameResult == 0) {
			displayLoss();
		}
		else if(gameResult == 1) {
			displayWin();
		}
	}
}
