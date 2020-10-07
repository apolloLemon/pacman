package pacman;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ViewCommand {
	
	public static void main(String[] args) {
		JFrame jFrame = new JFrame();
		jFrame.setTitle("Game");
		jFrame.setSize(new Dimension(700, 700));
		Dimension windowSize = jFrame.getSize();
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		java.awt.Point centerPoint = ge.getCenterPoint();
		int dx = centerPoint.x - windowSize.width /2;
		int dy = centerPoint.y - windowSize.height /2 -350;
		jFrame.setLocation(dx,dy);
		
		Icon restartIcon = new ImageIcon("icon_restart.png");
		JButton restartButton = new JButton(restartIcon);
		
		jFrame.setVisible(true);
		
	}	
}
