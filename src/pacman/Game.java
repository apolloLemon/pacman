package pacman;

public class Game {
	
	private int turn;
	private int maxturn;
	private boolean isRunning;
	
	public Game(int maxturn) {
		this.maxturn = maxturn;
	}
	
	public void init() {
		turn = 0;
		isRunning = true;
		initializeGame();
	}

	public void initializeGame() {}
	
	public void step() {
		//TODO
	}
	

}
