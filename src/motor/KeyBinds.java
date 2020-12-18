package motor;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBinds implements KeyListener {

	static final int p1_up = KeyEvent.VK_E;
	static final int p1_down = KeyEvent.VK_D;
	static final int p1_right = KeyEvent.VK_F;
	static final int p1_left = KeyEvent.VK_S;
	
	
	
	InterfaceGameInput parent;
	
	public KeyBinds(InterfaceGameInput parent){
		this.parent = parent;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("keyPressed");
		
		if(e.getKeyCode() == p1_up) {
			parent.input(InterfaceGameInput.PLAYER_INPUT.P1_UP);
		}
		
		if(e.getKeyCode() == p1_down) {
			parent.input(InterfaceGameInput.PLAYER_INPUT.P1_DOWN);
		}
		
		if(e.getKeyCode() == p1_right) {
			parent.input(InterfaceGameInput.PLAYER_INPUT.P1_RIGHT);
		}
		
		if(e.getKeyCode() == p1_left) {
			parent.input(InterfaceGameInput.PLAYER_INPUT.P1_LEFT);
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
