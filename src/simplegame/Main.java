package simplegame;

public class Main {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		System.out.println("PacMan");
		
		SimpleGame g = new SimpleGame(7);
		ControleurSimpleGame CSG = new ControleurSimpleGame(g);
		
		g.changeNotify();
//		g.setMaxturn(7);
	}

}
