package pacman;

public class Strat_UserInput implements PacmanStrategy {

	PacmanAgent body;
	int controller;
	int action;
	
	@Override
	public AgentAction action(PacmanGame m) {
		return new AgentAction(action);
	}

}
