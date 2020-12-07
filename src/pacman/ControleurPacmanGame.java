package pacman;

import motor.Game;
import motor.InterfaceControleur;
import motor.ViewCommand;
import simplegame.ViewSimpleGame;

public class ControleurPacmanGame implements InterfaceControleur {
	private PacmanGame g;
	private ViewCommand vc;
	private ViewPacmanGame vg;

	public ControleurPacmanGame(PacmanGame g) {
		this.g = g;
		vc = new ViewCommand(this);
		vg = new ViewPacmanGame(g);
		g.addObserver(vc);
		g.addObserver(vg);
	}
	
	
	@Override
	public void start() {
		// TODO Auto-generated method stub

	}

	@Override
	public void step() {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTime(double time) {
		// TODO Auto-generated method stub

	}

}
