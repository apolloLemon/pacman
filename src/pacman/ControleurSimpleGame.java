package pacman;

public class ControleurSimpleGame implements InterfaceControleur {
	private Game g;
	private ViewCommand vc;
	private ViewSimpleGame vg;

	public ControleurSimpleGame(Game og) {
		this.g = og;
		ViewCommand vc = new ViewCommand(this);
		ViewSimpleGame vsg = new ViewSimpleGame();
		g.addObserver(vc);
		g.addObserver(vsg);

	}
	
	
	@Override
	public void start() {
		System.out.println(this.getClass().getName()+": start");
		
	}

	@Override
	public void step() {
		System.out.println(this.getClass().getName()+": step");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		System.out.println(this.getClass().getName()+": run");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		System.out.println(this.getClass().getName()+": pause");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTime(double time) {
		System.out.println(this.getClass().getName()+": setTime");
		// TODO Auto-generated method stub
		
	}

}
