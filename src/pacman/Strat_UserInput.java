package pacman;

public class Strat_UserInput implements PacmanStrategy {

	PacmanAgent body;
	int controller;
	AgentAction action;
	
	Strat_UserInput(){
		action = new AgentAction(4);
	}
	
	@Override
	public AgentAction action(PacmanGame m) {
		return action;
	}

}
