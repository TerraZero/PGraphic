package tz.pgraphic.sio;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;

public class GKeyboard {

	private KeyboardFocusManager manager;
	
	public GKeyboard() {
		this.manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
	}
	
	public void addDispatcher(KeyEventDispatcher dispatcher) {
		this.manager.addKeyEventDispatcher(dispatcher);
	}

}
