package pacman;

public class Ghost extends PacmanAgent {

	Boolean scared;
	PacmanStrategy flee;
	PacmanStrategy hunt;
	PacmanStrategy home;
	
	Ghost(PositionAgent xy) {
		super(xy);
		scared = false;
		flee = new Strat_Random();
		hunt = new Strat_AStar(this);
		home = new Strat_AStar(this,xy);
		StrategyUpdate();
	}

	void StrategyUpdate() {
		if(scared) ia = flee;
		else ia = hunt;
	}
	
	void  SetScared(Boolean b) {
		scared = b;
		StrategyUpdate();
	}
	
	@Override
	public void Die() {
		scared=false;
		alive=false;
		ia=home;
	}
}
