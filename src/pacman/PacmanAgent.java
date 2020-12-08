package pacman;

public class PacmanAgent {
	PositionAgent xy;
	PacmanStrategy ia;
	Boolean alive;
	
	PacmanAgent(PositionAgent xy){
		this.xy = xy;
		alive = true;
		ia = new ValidRandomMoveStrat(this);
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

	public Boolean getAlive() {
		return alive;
	}

	public void setAlive(Boolean alive) {
		this.alive = alive;
	}
	
	public void Die() {
		this.setAlive(false);
	}
}
