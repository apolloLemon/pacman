package pacman;

public class AStarStrat implements PacmanStrategy {

	PacmanAgent body;
	PositionAgent target;
	
	boolean seekTarget;
	
	public AStarStrat (PacmanAgent body) {
		this.body=body;
		seekTarget=true; //must find a living pacman to go to
	}
	public AStarStrat (PacmanAgent body, PositionAgent target) {
		this.body=body;
		this.target=target;
		seekTarget=false; //if you only need to go one place
	}
	
	
	@Override
	public AgentAction action(PacmanGame m) {
		//TODO
		return null;
	}

}
