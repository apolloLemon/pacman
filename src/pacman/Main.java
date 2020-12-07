package pacman;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String path2Maze = "layout/tinyMaze.lay";
		
		PacmanGame pg = new PacmanGame(9999, path2Maze);
		ControleurPacmanGame cpg = new ControleurPacmanGame(pg);

	}

}
