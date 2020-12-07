package pacman;

import java.util.concurrent.ThreadLocalRandom;

public class RandomStrat implements PacmanStrategy {

	@Override
	public AgentAction action(PacmanGame m) {
		int r = ThreadLocalRandom.current().nextInt(0,5);
		return new AgentAction(r);
	}

}
