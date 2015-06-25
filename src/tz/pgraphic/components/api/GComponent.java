package tz.pgraphic.components.api;

import java.awt.Graphics;

/**
 * 
 * @author terrazero
 * @created Jun 4, 2015
 * 
 * @file GComponent.java
 * @project PGraphic
 * @identifier tz.pgraphic.component
 *
 */
public class GComponent {

	public GTransition x;
	public GTransition y;
	
	public GComponent() {
		this.init();
	}
	
	public void init() {
		this.x = new GTransition();
		this.y = new GTransition();
	}
	
	public void update(float delta) {
		this.x.update(delta);
		this.y.update(delta);
	}
	
	public void render(Graphics g) {
		
	}
	
}
