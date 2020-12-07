package pacman;

public class Ghost extends PacmanAgent {

	Boolean scared;
	
	Ghost(PositionAgent xy) {
		super(xy);
		scared = false;
	}
	
}
