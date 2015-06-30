package tz.pgraphic.render;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import tz.pgraphic.sio.GSIO;

/**
 * 
 * @author terrazero
 * @created Jun 4, 2015
 * 
 * @file GFrame.java
 * @project PGraphic
 * @identifier tz.pgraphic.render
 *
 */
public class GFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public JPanel cp;
	
	public GFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(860, 480);
		this.setLocationRelativeTo(null);
		
		this.cp = new JPanel();
		this.cp.setLayout(null);
		this.setContentPane(this.cp);
		
		GSIO.keyboard.addDispatcher(new KeyEventDispatcher() {
			
			@Override
			public boolean dispatchKeyEvent(KeyEvent e) {
				if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == 122) {
					GSIO.screen.setFullscreen(!GSIO.screen.isFullscreen());
				}
				return false;
			}
			
		});
	}

}
