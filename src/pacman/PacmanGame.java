package pacman;

import java.util.ArrayList;

import motor.Game;

public class PacmanGame extends Game {

	String path2Maze;
	Maze maze;	
	ArrayList<Agent> agents;
	
	public PacmanGame(int t, String m) {
		super(t);
		path2Maze = m;
		initializeGame();
		
	}
	
	@Override
	public void initializeGame() {
		try {
			maze = new Maze(path2Maze);
			
			for(PositionAgent pos : maze.getGhosts_start()) {
				agents.add(new Ghost(pos));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

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
