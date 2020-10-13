package pacman;

public class ControleurSimpleGame implements InterfaceControleur {
	private Game g;
	private ViewCommand vc;
	private ViewSimpleGame vsg;

	public ControleurSimpleGame(Game og) {
		this.g = og;
		vc = new ViewCommand(this);
		vsg = new ViewSimpleGame();
		g.addObserver(vc);
		g.addObserver(vsg);

	}
	
	
	@Override
	public void start() {
		System.out.println(this.getClass().getName()+": start");
		vc.runButton.setEnabled(true);
		vc.stepButton.setEnabled(true);
	}

	@Override
	public void step() {
		System.out.println(this.getClass().getName()+": step");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		System.out.println(this.getClass().getName()+": run");
		vc.stepButton.setEnabled(false);
		vc.runButton.setEnabled(false);
		vc.pauseButton.setEnabled(true);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		System.out.println(this.getClass().getName()+": pause");
		vc.stepButton.setEnabled(true);
		vc.runButton.setEnabled(true);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTime(double time) {
		System.out.println(this.getClass().getName()+": setTime");
		// TODO Auto-generated method stub
		
	}

}
