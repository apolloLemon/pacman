package pacman;

public class SimpleGame extends Game{

	public SimpleGame(int maxturn) {
		super(maxturn);
	}
	
	public void TakeTurn() {
		System.out.println("------------------------------------------------");
		System.out.println("Tour " + this.turn + "du jeu en cours.");
		System.out.println("------------------------------------------------");
	}
	
	public boolean gameContinue() {
		return true;
	}

	public void GameOver() {
		System.out.println("*********************");
		System.out.println("GAME OVER!");
		System.out.println("*********************");
		
	}

}
