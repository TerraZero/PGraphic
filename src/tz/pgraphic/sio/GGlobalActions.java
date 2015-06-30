package tz.pgraphic.sio;

import java.awt.Toolkit;
import java.awt.event.AWTEventListener;

/**
 * 
 * @author terrazero
 * @created Jun 30, 2015
 * 
 * @file GGlobalActions.java
 * @project PGraphic
 * @identifier tz.pgraphic.sio
 *
 */
public class GGlobalActions {

	private Toolkit defaultToolkit;
	
	public GGlobalActions() {
		this.defaultToolkit = Toolkit.getDefaultToolkit();
	}
	
	public void add(AWTEventListener listener, long mask) {
		this.defaultToolkit.addAWTEventListener(listener, mask);
	}
	
}
