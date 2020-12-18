package pacman;

public interface AgentFactory {
	Pacman createPacMan(PositionAgent pos);
	Ghost createGhost(PositionAgent pos);
}
