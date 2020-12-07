package pacman;

import motor.Game;
import motor.InterfaceControleur;
import motor.ViewCommand;
import simplegame.ViewSimpleGame;

public class ControleurPacmanGame implements InterfaceControleur {
	private Game g;
	private ViewCommand vc;
	private ViewPacmanGame vg;

	public ControleurPacmanGame(Game og) {
		this.g = og;
		vc = new ViewCommand(this);
		vg = new ViewPacmanGame();
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
