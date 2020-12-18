package pacman;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path2Maze = "layout/smallClassic.lay";
		File workingDirectory = new File(System.getProperty("user.dir")+"/layout");
		JFileChooser jfc = new JFileChooser();
		jfc.setCurrentDirectory(workingDirectory);
		jfc.setDialogTitle("Choose a  file: ");
		jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int returnValue = jfc.showSaveDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
		    if (jfc.getSelectedFile().isFile()) {
		        System.out.println("You selected the directory: " + jfc.getSelectedFile());
		        path2Maze=jfc.getSelectedFile().getAbsolutePath();
		    }
		}
		
		
		PacmanGame pg = new PacmanGame(9999, path2Maze);
		ControleurPacmanGame cpg = new ControleurPacmanGame(pg);

	}

}
