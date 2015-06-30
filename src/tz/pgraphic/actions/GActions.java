package tz.pgraphic.actions;

import java.awt.AWTEvent;
import java.awt.event.AWTEventListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import tz.pgraphic.sio.GSIO;

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
	
	public GMouseActions mouse;
	
	public GActions() {
		GSIO.global.add(this, AWTEvent.KEY_EVENT_MASK + AWTEvent.MOUSE_EVENT_MASK + AWTEvent.MOUSE_MOTION_EVENT_MASK);
	}

	/* 
	 * @see java.awt.event.AWTEventListener#eventDispatched(java.awt.AWTEvent)
	 */
	@Override
	public void eventDispatched(AWTEvent event) {
		if (event instanceof KeyEvent) {
			
		} else if (event instanceof MouseEvent) {
			this.mouse.set((MouseEvent)event);
		}
	}
	
}
