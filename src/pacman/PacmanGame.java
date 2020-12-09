package pacman;

import java.util.ArrayList;

import motor.Game;

public class PacmanGame extends Game {

	String path2Maze;
	static Maze maze;
	ArrayList<PacmanAgent> agents;
	boolean pacmanAlive;
	
	int edible;
	int eaten;
	
	int capsuleTime;
	int capsuleTimer;
	Boolean capsuleActive;
	
	public PacmanGame(int t, String m) {
		super(t);
		path2Maze = m;
		initializeGame();
		eaten=0;
		capsuleTimer=0;
		capsuleTime=20;
		capsuleActive=false;
		
	}
	
	static Boolean isLegalMove(PacmanAgent agnt, AgentAction actn) {
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
		agnt.getXy().setDir(actn.get_direction());
	}
	
	void CapsuleToggle(Boolean b) {
		for(PacmanAgent a : agents) {
			if (a instanceof Ghost) ((Ghost) a).SetScared(b);
		}
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
				pacmanAlive = true;
				agents.add(new Pacman(pos));
			}
			
			int X = maze.getSizeX();
			int Y = maze.getSizeY();
			edible=0;
			for(int x=0;x<X;x++) {
				for(int y=0;y<Y;y++) {
					if(maze.isFood(x, y) || maze.isCapsule(x, y)) edible++;
				}
			}
			
			
			System.out.println("**********************");
			System.out.println("      GAME READY"      );
			System.out.println("**********************");
			System.out.println(maze.getInitNumberOfPacmans()+" vs  "+ maze.getInitNumberOfGhosts()+" ghosts" );
			System.out.println("things to eat: "+ edible);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void TakeTurn() {
		capsuleTimer--;
		if (capsuleTimer==0) {
			capsuleActive=false;
			CapsuleToggle(capsuleActive);
		}
		if(capsuleTimer<0) capsuleTimer=0;
		
		for(PacmanAgent a : agents) {
			AgentAction act = a.getIa().action(this);
			if(isLegalMove(a,act)) {
				moveAgent(a,act);
				System.out.println("moveagent to: "+a.getXy().toString());
			}
			int x = a.getXy().getX();
			int y = a.getXy().getY();
			
			//Pacman Collisions
			if(a instanceof Pacman) {
				if(maze.isFood(x, y)) {
					System.out.println("Pacman on food");
					maze.setFood(x, y, false);
					//TODO food mechanic
					eaten++;
				}
				if(maze.isCapsule(x, y)) {
					System.out.println("Pacman on capsule");
					maze.setCapsule(x, y, false);
					//TODO Capsule mechanic
					capsuleTimer+=capsuleTime;
					if(!capsuleActive) {
						capsuleActive=true;
						CapsuleToggle(capsuleActive);
					}
				}
				//Agent Collisions
				for(PacmanAgent b : agents) {
					if(b instanceof Ghost) {
						if(a.getXy().equals(b.getXy()))
						if (capsuleActive) {
							b.Die();
						} else {
							a.Die();
						}
					}
				}
			}
		}
		
	}

	@Override
	public void GameOver() {
		System.out.println("**********************");
		System.out.println("      GAME OVER!"      );
		System.out.println("**********************");
		// TODO Auto-generated method stub
		System.out.println("food: "+(eaten < edible));
		System.out.println("pacmanAlive: "+pacmanAlive);
	}

	@Override
	public boolean gameContinue() {
		boolean still_wants_to_eat = ( eaten < edible );
		
		pacmanAlive=false;
		for(PacmanAgent a : agents) {
			if(a instanceof Pacman &&  a.isAlive()) {
				pacmanAlive=true;
				return (pacmanAlive && still_wants_to_eat);
			}
		}
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
