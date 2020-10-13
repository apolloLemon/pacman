package pacman;

public class ControleurSimpleGame implements InterfaceControleur {
	private Game g;
	private ViewCommand vc;
	private ViewSimpleGame vg;

	public ControleurSimpleGame(Game og) {
		this.g = og;
		ViewCommand vc = new ViewCommand();
		ViewSimpleGame vsg = new ViewSimpleGame();
		g.addObserver(vc);
		g.addObserver(vsg);

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
