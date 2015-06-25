package tz.pgraphic.components;

import java.awt.Color;
import java.awt.Graphics;

import tz.pgraphic.components.api.GComponent;
import tz.pgraphic.components.api.GTransition;

/**
 * 
 * @author terrazero
 * @created Jun 5, 2015
 * 
 * @file GField.java
 * @project PGraphic
 * @identifier tz.pgraphic.components
 *
 */
public class GField extends GComponent {

	public GTransition width;
	public GTransition height;
	
	public GTransition loader;
	
	/* 
	 * @see tz.pgraphic.components.api.GComponent#init()
	 */
	@Override
	public void init() {
		super.init();
		
		this.width = new GTransition();
		this.height = new GTransition();
		this.loader = new GTransition(360);
	}
	
	/* 
	 * @see tz.pgraphic.components.api.GComponent#update(float)
	 */
	@Override
	public void update(float delta) {
		super.update(delta);
		
		this.width.update(delta);
		this.height.update(delta);
		this.loader.update(delta);
		if (this.loader.getInt() >= 360) {
			this.loader.set(0f).ani(360);
		}
	}
	
	/* 
	 * @see tz.pgraphic.components.api.GComponent#render(java.awt.Graphics)
	 */
	@Override
	public void render(Graphics g) {
		g.setColor(Color.CYAN);
		g.drawRect(this.x.getInt(), this.y.getInt(), this.width.getInt(), this.height.getInt());
		g.drawArc(this.x.getInt() + this.width.getInt() / 2 - this.width.getInt() / 8, this.y.getInt() + this.height.getInt() / 2 - this.height.getInt() / 8, this.width.getInt() / 4, this.height.getInt() / 4, 360 - this.loader.getInt(), 90);
	}
	
}
