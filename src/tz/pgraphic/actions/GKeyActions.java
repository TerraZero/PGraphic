package tz.pgraphic.actions;

import java.awt.event.KeyEvent;
import java.util.List;

/**
 * 
 * @author terrazero
 * @created Jun 29, 2015
 * 
 * @file GKeyActions.java
 * @project PGraphic
 * @identifier tz.pgraphic.actions
 *
 */
public class GKeyActions {
	
	//tmp

	private List<KeyEvent> pressed;
	private List<KeyEvent> released;
	
	public void set(KeyEvent event) {
		switch (event.getID()) {
			case KeyEvent.KEY_PRESSED : 
				this.pressed.add(event);
				break;
			case KeyEvent.KEY_RELEASED :
				this.released.add(event);
				break;
		}
	}
	
	public boolean anyPress(char... keys) {
		for (char key : keys) {
			if (this.isPress(key)) return true;
		}
		return false;
	}
	
	public boolean allPress(char... keys) {
		for (char key : keys) {
			if (!this.isPress(key)) return false;
		}
		return true;
	}
	
	public boolean isPress(char key) {
		for (KeyEvent event : this.pressed) {
			if (event.getKeyChar() == key) return true;
		}
		return false;
	}
	
	public void clear() {
		this.pressed.clear();
		this.released.clear();
	}
	
}
