package pacman;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class ViewCommand implements ActionListener{
	
	public static void main(String[] args) {
		
		//Création de la fenêtre
		JFrame jFrame = new JFrame();
		jFrame.setTitle("Game");
		jFrame.setSize(new Dimension(700, 350));
		Dimension windowSize = jFrame.getSize();
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		java.awt.Point centerPoint = ge.getCenterPoint();
		int dx = centerPoint.x - windowSize.width /2;
		int dy = centerPoint.y - windowSize.height /2;
		jFrame.setLocation(dx,dy);
		
		//Panel pour les boutons
		JPanel jPanel1 = new JPanel();
		jPanel1.setLayout(new GridLayout(1,4));
		jFrame.add("North",jPanel1);
		
		Icon restartIcon = new ImageIcon("icones/icon_restart.png");
		JButton restartButton = new JButton(restartIcon);
		jPanel1.add(restartButton);
		
		Icon runIcon = new ImageIcon("icones/icon_run.png");
		JButton runIconButton = new JButton(runIcon);
		jPanel1.add(runIconButton);
		
		Icon stepIcon = new ImageIcon("icones/icon_step.png");
		JButton stepIconButton = new JButton(stepIcon);
		jPanel1.add(stepIconButton);
		
		Icon pauseIcon = new ImageIcon("icones/icon_pause.png");
		JButton pauseIconButton = new JButton(pauseIcon);
		jPanel1.add(pauseIconButton);
		
		
		//Panel pour le jslide
		JPanel jPanel2 = new JPanel();
		jPanel2.setLayout(new GridLayout(1,2));
		jFrame.add("South",jPanel2);
		
		JSlider slider = new JSlider(1, 10, 1);
		jPanel2.add(slider);
		// Configurer le composant
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setPaintTrack(true); 
        
        JLabel label = new JLabel();
        label.setText("Turn: "); 
        jPanel2.add(label);
        
		jFrame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}	
}
