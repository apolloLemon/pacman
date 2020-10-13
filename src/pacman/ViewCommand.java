package pacman;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

@SuppressWarnings("deprecation")
public class ViewCommand extends JFrame implements Observer{
	
	private int tour;
	private InterfaceControleur ic;
	JLabel label;
	
	JButton restartButton;
	JButton runButton;
	JButton stepButton;
	JButton pauseButton;
	
	public ViewCommand(InterfaceControleur parent) {
		ic = parent;
		
		//Création de la fenêtre
		this.setTitle("Game");
		this.setSize(new Dimension(700, 350));
		Dimension windowSize = this.getSize();
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		java.awt.Point centerPoint = ge.getCenterPoint();
		int dx = centerPoint.x - windowSize.width /2;
		int dy = centerPoint.y - windowSize.height /2;
		this.setLocation(dx,dy);
		
		//Panel pour les boutons
		JPanel jPanel1 = new JPanel();
		jPanel1.setLayout(new GridLayout(1,4));
		this.add("North",jPanel1);
		
		Icon restartIcon = new ImageIcon("icones/icon_restart.png");
		restartButton = new JButton(restartIcon);
		restartButton.addActionListener(new ActionListener() { 
		    public void actionPerformed(ActionEvent e) { 
		        ic.start();
		    } 
		});
		jPanel1.add(restartButton);
		
		Icon runIcon = new ImageIcon("icones/icon_run.png");
		runButton = new JButton(runIcon);
		runButton.addActionListener(new ActionListener() { 
		    public void actionPerformed(ActionEvent e) { 
		        ic.run();
		    } 
		});
		jPanel1.add(runButton);
		
		Icon stepIcon = new ImageIcon("icones/icon_step.png");
		stepButton = new JButton(stepIcon);
		stepButton.addActionListener(new ActionListener() { 
		    public void actionPerformed(ActionEvent e) { 
		        ic.step();
		    } 
		});
		jPanel1.add(stepButton);
		
		Icon pauseIcon = new ImageIcon("icones/icon_pause.png");
		pauseButton = new JButton(pauseIcon);
		pauseButton.addActionListener(new ActionListener() { 
		    public void actionPerformed(ActionEvent e) { 
		       ic.pause();
		    } 
		});
		jPanel1.add(pauseButton);
		
		
		//Panel pour le jslide
		JPanel jPanel2 = new JPanel();
		jPanel2.setLayout(new GridLayout(1,2));
		this.add("South",jPanel2);
		
		JSlider slider = new JSlider(1, 10, 1);
		jPanel2.add(slider);
		// Configurer le composant
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setPaintTrack(true); 
        
        label = new JLabel();
        label.setText("Turn: "+tour); 
        jPanel2.add(label);
        
		this.setVisible(true);
		
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.print("ha");
		Game g = (Game)o;
		tour = g.getMaxturn();
		label.setText("Turn: "+tour);
	}	
}
