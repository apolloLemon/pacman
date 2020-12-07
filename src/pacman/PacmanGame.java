package pacman;

import java.util.ArrayList;

import motor.Game;

public class PacmanGame extends Game {

	String path2Maze;
	Maze maze;	
	ArrayList<PacmanAgent> agents;
	
	public PacmanGame(int t, String m) {
		super(t);
		path2Maze = m;
		initializeGame();
		
	}
	
	Boolean isLegalMove(PacmanAgent agnt, AgentAction actn) {
		int x = agnt.getXy().getX() + actn.get_vx();
		int y = agnt.getXy().getY() + actn.get_vy();
		if(maze.isWall(x, y)) return false;
		return true;
	}
	
	void moveAgent(PacmanAgent agnt, AgentAction actn) {
		int x = agnt.getXy().getX() + actn.get_vx();
		int y = agnt.getXy().getY() + actn.get_vy();
		agnt.getXy().setX(x);
		agnt.getXy().setY(y);
	}
	
	@Override
	public void initializeGame() {
		agents= new ArrayList<PacmanAgent>();
		try {
			maze = new Maze(path2Maze);
			
			//replace with factory
			for(PositionAgent pos : maze.getGhosts_start()) {
				agents.add(new Ghost(pos));
			}
			for(PositionAgent pos : maze.getPacman_start()) {
				agents.add(new Pacman(pos));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void TakeTurn() {
		for(PacmanAgent a : agents) {
			AgentAction act = a.getIa().action(this);
			if(isLegalMove(a,act)) {
				moveAgent(a,act);
			}
		}
		
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

	public ArrayList<PacmanAgent> getAgents() {
		return agents;
	}

	public void setAgents(ArrayList<PacmanAgent> agents) {
		this.agents = agents;
	}

}
