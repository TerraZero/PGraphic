package tz.pgraphic.render;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferStrategy;

/**
 * 
 * @author Terra
 * @created 03.12.2014
 * 
 * @file GCanvas.java
 * @project G7C
 * @identifier TZ.G7.Canvas
 *
 */
public class GCanvas extends Canvas {

	private static final long serialVersionUID = 1L;
	
	private static GCanvas singleton;

	protected BufferStrategy bs;
	
	public static GCanvas frame() {
		if (GCanvas.singleton == null) {
			GCanvas.singleton = new GCanvas();
		}
		return GCanvas.singleton;
	}
	
	public GCanvas() {
		this.init();
	}
	
	protected void init() {
		this.setBackground(Color.BLACK);
	}
	
	public void createBuffer() {
		this.createBufferStrategy(3);
		this.bs = this.getBufferStrategy();
	}
	
	public Graphics getShowGraphics() {
		Graphics g =  this.bs.getDrawGraphics();
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		return g2;
	}
	
	public void show() {
		this.bs.show();
	}
	
}
