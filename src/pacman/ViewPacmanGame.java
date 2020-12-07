package pacman;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ViewPacmanGame extends JFrame implements Observer {

	PanelPacmanGame ppg;
	
	public ViewPacmanGame(PacmanGame pg) {
		JFrame jFrame = new JFrame();
		jFrame.setTitle("Pacman");
		jFrame.setSize(new Dimension(700, 700));
		Dimension windowSize = jFrame.getSize();
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		java.awt.Point centerPoint = ge.getCenterPoint();
		int dx = centerPoint.x - windowSize.width /2;
		int dy = centerPoint.y - windowSize.height /2 -350;
		jFrame.setLocation(dx,dy);
		
		ppg = new PanelPacmanGame(pg.getMaze());
		jFrame.add(ppg);
		jFrame.setVisible(true);
		
	}
	
	@Override
	public void update(Observable o, Object arg) {
		PacmanGame g = (PacmanGame)o;
		ppg.setMaze(g.getMaze());
	}

}
