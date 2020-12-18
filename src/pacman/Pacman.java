package pacman;

public class Pacman extends PacmanAgent {
	
	Pacman(PositionAgent xy) {
		super(xy);
		this.ia = new Strat_UserInput();
	}

}
