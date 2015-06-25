package tz.pgraphic.actions;

import java.awt.event.MouseEvent;

/**
 * 
 * @author terrazero
 * @created Jun 25, 2015
 * 
 * @file GMouseActions.java
 * @project PGraphic
 * @identifier tz.pgraphic.actions
 *
 */
public class GMouseActions {

	private MouseEvent pressed;
	private MouseEvent released;
	private MouseEvent moved;
	
	public void set(MouseEvent event) {
		switch (event.getID()) {
			case MouseEvent.MOUSE_PRESSED :
				this.pressed = event;
				break;
			case MouseEvent.MOUSE_RELEASED :
				this.released = event;
				break;
			case MouseEvent.MOUSE_MOVED :
				this.moved = event;
				break;
		}
	}
	
	public void clear() {
		this.pressed = null;
		this.released = null;
		this.moved = null;
	}
	
}
