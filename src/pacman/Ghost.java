package pacman;

public class Ghost extends PacmanAgent {

	Boolean scared;
	PacmanStrategy flee;
	PacmanStrategy hunt;
	
	Ghost(PositionAgent xy) {
		super(xy);
		scared = false;
		flee = new RandomStrat();
		hunt = new ValidRandomMoveStrat(this);
	}

	void StrategyUpdate() {
		if(scared) ia = flee;
		else ia = hunt;
	}
	
	void  SetScared(Boolean b) {
		scared = b;
		StrategyUpdate();
	}
}
