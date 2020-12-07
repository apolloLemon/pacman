package pacman;

public class PacmanAgent {
	PositionAgent xy;
	PacmanStrategy ia;
	Boolean alive;
	
	PacmanAgent(PositionAgent xy){
		this.xy = xy;
		alive = true;
	}

	public PacmanStrategy getIa() {
		return ia;
	}

	public void setIa(PacmanStrategy ia) {
		this.ia = ia;
	}

	public PositionAgent getXy() {
		return xy;
	}

	public void setXy(PositionAgent xy) {
		this.xy = xy;
	}
	
}
