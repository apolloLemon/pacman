package simplegame;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

public class ViewSimpleGame extends JFrame implements Observer{
	
	public ViewSimpleGame() {
		JFrame jFrame = new JFrame();
		jFrame.setTitle("Game");
		jFrame.setSize(new Dimension(700, 700));
		Dimension windowSize = jFrame.getSize();
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		java.awt.Point centerPoint = ge.getCenterPoint();
		int dx = centerPoint.x - windowSize.width /2;
		int dy = centerPoint.y - windowSize.height /2 -350;
		jFrame.setLocation(dx,dy);
		
		jFrame.setVisible(true);
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
