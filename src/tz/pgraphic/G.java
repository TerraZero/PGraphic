package tz.pgraphic;

import java.util.ArrayList;
import java.util.List;

import tz.pgraphic.render.GFrame;
import tz.pgraphic.render.GLoop;
import tz.pgraphic.render.GCanvas;
import tz.pgraphic.render.GState;

/**
 * 
 * @author terrazero
 * @created Jun 4, 2015
 * 
 * @file PGraphic.java
 * @project PGraphic
 * @identifier tz.pgraphic
 *
 */
public class G {
	
	public static GLoop loop;
	public static GCanvas canvas;
	public static GFrame frame;
	public static List<GState> states;
	
	static {
		System.setProperty("sun.java2d.opengl", "true");
	}

	public static void init() {
		G.loop = new GLoop();
		G.frame = new GFrame();
		G.canvas = new GCanvas();
		G.states = new ArrayList<GState>();
		G.states.add(new GState("main"));
	}
	
	public static void show() {
		G.frame.add(G.canvas);
		G.frame.setVisible(true);
		
		G.canvas.createBuffer();
		G.canvas.setSize(G.frame.getWidth(), G.frame.getHeight());
	}
	
	public static GState state() {
		return G.states.get(G.states.size() - 1);
	}
	
	public static void setState(String name) {
		int pos = 0;
		for (GState state : G.states) {
			if (state.name == name) break;
			pos++;
		}
		while (pos + 1 < G.states.size()) {
			G.states.remove(G.states.size() - 1);
		}
	}
	
}
