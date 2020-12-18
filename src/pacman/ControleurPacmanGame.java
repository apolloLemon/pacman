package pacman;

import motor.InterfaceControleur;
import motor.InterfaceGameInput;
import motor.KeyBinds;
import motor.ViewCommand;

public class ControleurPacmanGame implements InterfaceControleur, InterfaceGameInput {
	private PacmanGame g;
	private ViewCommand vc;
	private ViewPacmanGame vg;
	private KeyBinds keybinds;

	public ControleurPacmanGame(PacmanGame g) {
		this.g = g;
		vc = new ViewCommand(this);
		vg = new ViewPacmanGame(g,this);
		keybinds = new KeyBinds(this);
		g.addObserver(vc);
		g.addObserver(vg);
	}
	
	
	@Override
	public void start() {
		System.out.println(this.getClass().getName()+": start");
		vc.runButton.setEnabled(true);
		vc.stepButton.setEnabled(true);
		g.init();
		assignControllers();

	}

	@Override
	public void step() {
		System.out.println(this.getClass().getName()+": step");
		// TODO Auto-generated method stub
		g.step();
	}

	@Override
	public void run() {
		System.out.println(this.getClass().getName()+": run");
		vc.stepButton.setEnabled(false);
		vc.runButton.setEnabled(false);
		vc.pauseButton.setEnabled(true);
		// TODO Auto-generated method stub
		g.launch();
		
	}

	@Override
	public void pause() {
		System.out.println(this.getClass().getName()+": pause");
		vc.stepButton.setEnabled(true);
		vc.runButton.setEnabled(true);
		// TODO Auto-generated method stub
		g.pause();
		
	}

	@Override
	public void setTime(double time) {
		System.out.println(this.getClass().getName()+": setTime = "+time);
		// TODO Auto-generated method stub
		g.setTurnspersec((long) time);
	}


	@Override
	public void assignControllers() {
		g.findPlayerAgents();
	}


	@Override
	public void input(PLAYER_INPUT i) {
		System.out.println("HEEEELLLP");
		switch (i) {
			case P1_UP:
				((Strat_UserInput) g.agents.get(g.playeragents.get(0)).getIa()).action = new AgentAction(0);
				break;
			case P1_DOWN:
				((Strat_UserInput) g.agents.get(g.playeragents.get(0)).getIa()).action = new AgentAction(1);
				break;
			case P1_RIGHT:
				((Strat_UserInput) g.agents.get(g.playeragents.get(0)).getIa()).action = new AgentAction(2);
				break;
			case P1_LEFT:
				((Strat_UserInput) g.agents.get(g.playeragents.get(0)).getIa()).action = new AgentAction(3);
				break;
		}
		
	}
}
