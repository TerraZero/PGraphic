package tz.pgraphic.render;

import javax.swing.JFrame;
import javax.swing.JPanel;

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
	}

}
