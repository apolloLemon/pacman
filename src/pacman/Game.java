package pacman;

abstract public class Game implements Runnable {
	
	protected int turn;
	protected int maxturn;
	protected boolean isRunning;
	private long sleeptime = 1000;
	
	Thread thread;
	
	public Game(int maxturn) {
		this.maxturn = maxturn;
	}
	
	public void init() {
		turn = 0;
		isRunning = true;
		initializeGame();
	}

	abstract public void initializeGame();
	
	abstract public void TakeTurn();
	abstract public void GameOver();
	abstract public boolean gameContinue();
	
	public void step() {
		if(turn < maxturn && gameContinue()) {
			this.TakeTurn();
		} else {
			this.isRunning = false;
			this.GameOver();
		}
		turn++;
	}
	
	public void run() {
		while(this.isRunning) {
			this.step();
			try {
				Thread.sleep(sleeptime);
			} catch(Exception e){}
		}
	}
	
	public void pause() {
		this.isRunning=false;
	}

	public void launch() {
		this.isRunning=true;
		thread = new Thread(this);
		this.thread.start();
	}
}
