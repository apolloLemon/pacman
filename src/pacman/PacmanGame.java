package pacman;

import motor.Game;

public class PacmanGame extends Game {

	Maze maze;
	
	public PacmanGame(int t, String m) {
		super(t);
		
		try {
			maze = new Maze(m);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void initializeGame() {
		// TODO Auto-generated method stub

	}

	@Override
	public void TakeTurn() {
		// TODO Auto-generated method stub

	}

	@Override
	public void GameOver() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean gameContinue() {
		// TODO Auto-generated method stub
		return false;
	}

	public Maze getMaze() {
		return maze;
	}

	public void setMaze(Maze maze) {
		this.maze = maze;
	}

}
