package motor;

import java.util.Observable;

@SuppressWarnings("deprecation")
abstract public class Game extends Observable implements Runnable {
	
	protected int turn;
	protected long turnspersec;
	
	protected int maxturn;
	protected boolean isRunning;
	
	public int getTurn() {
		return turn;
	}
	
	public int getMaxturn() {
		return maxturn;
	}

	public void setMaxturn(int maxturn) {
		this.maxturn = maxturn;
		this.setChanged();
		this.notifyObservers();
	}
	
	public void setTurnspersec(long l) {
		this.turnspersec = l;
		this.setChanged();
		this.notifyObservers();
	}
	
	private long sleeptime () {
		return 1000/turnspersec;
	}
	
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
		setChanged();
		notifyObservers();
		turn++;
	}
	
	public void run() {
		while(this.isRunning) {
			this.step();
			try {
				Thread.sleep(sleeptime());
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
	
	public void changeNotify() {
		this.setChanged();
		this.notifyObservers();
	}
}
