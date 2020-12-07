package pacman;

import java.util.concurrent.ThreadLocalRandom;

public class ValidRandomMoveStrat implements PacmanStrategy {

	PacmanAgent body;
	
	ValidRandomMoveStrat(PacmanAgent body){
		this.body = body;
	}
	
	@Override
	public AgentAction action(PacmanGame m) {
		System.out.println("validaction from "+body.getXy().toString());
		int r = ThreadLocalRandom.current().nextInt(0,4);
		int rn = r;
		AgentAction actn;
		
		do {
			System.out.print("rn = "+ rn + ", ");
			actn = new AgentAction(rn);
			rn = (rn+1)%4;
		}
		while(!PacmanGame.isLegalMove(body, actn) && rn!=r);
		System.out.println();
		System.out.println("move "+actn.get_vx()+","+actn.get_vy());
		return actn;
	}

}
