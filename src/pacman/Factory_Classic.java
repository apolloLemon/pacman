package pacman;

public class Factory_Classic implements AgentFactory {
	
	@Override
	public Pacman createPacMan(PositionAgent pos) {
		return new Pacman(pos);
	}

	@Override
	public Ghost createGhost(PositionAgent pos) {
		Ghost result = new Ghost(pos);
		result.setHunt(new Strat_AStar(result));
		result.setHome(new Strat_AStar(result, pos));
		result.setFlee(new Strat_Random() );
		return result;
	}
}
