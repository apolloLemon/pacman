package pacman;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import motor.InterfaceGameInput;
import motor.KeyBinds;

public class ViewPacmanGame extends JFrame implements Observer {

	PanelPacmanGame ppg;
	InterfaceGameInput parent;
	
	public ViewPacmanGame(PacmanGame pg, InterfaceGameInput parent) {
		this.parent = parent;
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
		
		jFrame.addKeyListener( new KeyBinds(parent));
		
		jFrame.setVisible(true);
		
	}
	
	@Override
	public void update(Observable o, Object arg) {
		PacmanGame g = (PacmanGame)o;
		
		ArrayList<PositionAgent> pacmans_pos = new ArrayList<PositionAgent>();
		ArrayList<PositionAgent> ghosts_pos = new ArrayList<PositionAgent>();
		for (PacmanAgent a : g.getAgents()) {
			if(a instanceof Pacman) {
				pacmans_pos.add(a.getXy());
			}
			if(a instanceof Ghost) {
				ghosts_pos.add(a.getXy());
			}
		}
		ppg.setPacmans_pos(pacmans_pos);
		ppg.setGhosts_pos(ghosts_pos);
		ppg.setMaze(g.getMaze());
		ppg.repaint();
	}

}
