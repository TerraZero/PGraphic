package tz.pgraphic.render;

import java.awt.Graphics;

import tz.pgraphic.G;
import tz.pgraphic.components.api.GComponent;

/**
 * 
 * @author Terra
 * @created 10.12.2014
 * 
 * @file GLoop.java
 * @project G7C
 * @identifier TZ.G7
 *
 */
public class GLoop {
	
	protected float deltaTime;
	
	protected boolean stop;
	
	public GLoop() {
		this.deltaTime = 1000f / 60f;
	}
	
	public void start() {
		this.loop();
		this.exit();
	}
	
	public void exit() {
		
	}

	public void loop() {
		long nextTime = 0;
		long frameTime = 0;
		long current = System.currentTimeMillis();
		float delta = 0;
		
		while (!this.stop) {
			nextTime = System.currentTimeMillis();
			frameTime = nextTime - current;
			current = nextTime;
			
			while (frameTime > 0) {
				delta = (frameTime > this.deltaTime ? this.deltaTime : frameTime);
				this.update(delta);
				frameTime -= delta;
			}
			this.render();
		}
	}
	
	public void stop() {
		this.stop = true;
	}
	
	public void update(float delta) {
		for (GComponent c : G.state().components()) {
			c.update(delta);
		}
	}
	
	public void render() {
		Graphics g = G.canvas.getShowGraphics();
		for (GComponent c : G.state().components()) {
			c.render(g);
		}
		G.canvas.show();
	}
	
}
