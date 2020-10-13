package pacman;

public class Main {

	public static void main(String[] args) {
		System.out.println("PacMan");
		
		ViewCommand vc = new ViewCommand();
		ViewSimpleGame vsg = new ViewSimpleGame();

		SimpleGame g = new SimpleGame(7);
		g.addObserver(vc);
		g.addObserver(vsg);
		g.changeNotify();
//		g.setMaxturn(7);
	}

}
