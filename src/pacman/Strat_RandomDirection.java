package pacman;

import java.util.concurrent.ThreadLocalRandom;

public class Strat_RandomDirection implements PacmanStrategy {

	PacmanAgent body;
	AgentAction current;
	
	Strat_RandomDirection(PacmanAgent body){
		this.body=body;
	}
	
	@Override
	public AgentAction action(PacmanGame m) {
		
		System.out.println("validaction from "+body.getXy().toString());
		int r = ThreadLocalRandom.current().nextInt(0,4);
		int rn = r;
		
		if(current==null || !PacmanGame.isLegalMove(body, current)) {
			do {
				System.out.print("rn = "+ rn + ", ");
				current = new AgentAction(rn);
				rn = (rn+1)%4;
			}
			while(!PacmanGame.isLegalMove(body, current) && rn!=r);
		}
		
		System.out.println();
		System.out.println("move "+current.get_vx()+","+current.get_vy());
		
		
		return current;
	}

}
