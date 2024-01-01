package org.bpm.engine.input;

import org.bpm.engine.core.GameEngine2;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInputHandler extends KeyAdapter {
	

	/**
	 * Notification from AWT that a key has been pressed. Note that
	 * a key being pressed is equal to being pushed down but *NOT*
	 * released. Thats where keyTyped() comes in.
	 *
	 * @param e The details of the key that was pressed 
	 */
	public void keyPressed(KeyEvent e) {
	
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			GameEngine2.leftPressed = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			GameEngine2.rightPressed = true;
		}
		
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			GameEngine2.upPressed = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			GameEngine2.downPressed = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			GameEngine2.spacePressed = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_I) {
			GameEngine2.inventoryPressed = true;
		}
		
		if (e.getKeyCode() == KeyEvent.VK_TAB) {
			GameEngine2.tabPressed = !GameEngine2.tabPressed;
		}
		
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			GameEngine2.enterPressed = true;
		}

		
		// if we hit escape, then quit the game
		if (e.getKeyChar() == 27) {
			GameEngine2.inventoryPressed = false;
		}
		
	} 
	
	/**
	 * Notification from AWT that a key has been released.
	 *
	 * @param e The details of the key that was released 
	 */
	public void keyReleased(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			GameEngine2.leftPressed = false;
			//System.out.println("LEFT RELEASE");
			//GameEngine2.xscroll += 60;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			GameEngine2.rightPressed = false;
		}
	
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			GameEngine2.upPressed = false;
		//	System.out.println("UP PUSH");
			
			
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			GameEngine2.downPressed = false;
		//	System.out.println("DOWN");
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			GameEngine2.spacePressed = false;
		}
		
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			GameEngine2.enterPressed = false;
		}
		
	}
}




