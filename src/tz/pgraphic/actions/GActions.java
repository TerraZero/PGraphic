package tz.pgraphic.actions;

import java.awt.AWTEvent;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * 
 * @author terrazero
 * @created Jun 25, 2015
 * 
 * @file GActions.java
 * @project PGraphic
 * @identifier tz.pgraphic.actions
 *
 */
public class GActions implements AWTEventListener {
	
	public GActions() {
		Toolkit.getDefaultToolkit().addAWTEventListener(this, AWTEvent.KEY_EVENT_MASK + AWTEvent.MOUSE_EVENT_MASK + AWTEvent.MOUSE_MOTION_EVENT_MASK);
	}

	/* 
	 * @see java.awt.event.AWTEventListener#eventDispatched(java.awt.AWTEvent)
	 */
	@Override
	public void eventDispatched(AWTEvent event) {
		if (event instanceof KeyEvent) {
			
		} else if (event instanceof MouseEvent) {
			
		}
	}
	
}
