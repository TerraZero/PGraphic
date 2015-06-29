package tz.pgraphic.render;

import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

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
	
	public Thread thread;
	
	private float deltaTime;
	
	private boolean stop;
	
	private Object sync;
	private Object syncLoop;
	private boolean interrupt;
	
	public GLoop() {
		this.deltaTime = 1000f / 60f;
		this.sync = new Object();
		this.syncLoop = new Object();
		this.interrupt = false;
		G.frame.addComponentListener(new ComponentAdapter() {
			
			public void componentShown(ComponentEvent e) {
				GLoop.this.start();
			}
			
		});
	}
	
	public void start() {
		if (this.thread == null) {
			this.thread = new Thread(() -> {
				GLoop.this.loop();
				GLoop.this.exit();
			});
			this.thread.start();
		}
	}
	
	public void exit() {
		
	}

	public void loop() {
		long nextTime = 0;
		long frameTime = 0;
		long current = System.currentTimeMillis();
		float delta = 0;
		
		while (!this.stop) {
			synchronized (this.sync) {
				if (this.interrupt) {
					try {
						this.sync.wait();
					} catch (InterruptedException e) {
						System.out.println(e);
					}
				}
			}
			synchronized (this.syncLoop) {
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
	}
	
	public void interrupt(boolean interrupt) {
		if (this.interrupt != interrupt) {
			G.canvas.interruptHook(interrupt);
			synchronized (this.syncLoop) {
				this.interrupt = interrupt;
			}
			if (!this.interrupt) {
				synchronized (this.sync) {
					this.sync.notifyAll();
				}
			}
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
