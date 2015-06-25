package tz.pgraphic.render;

import java.util.ArrayList;
import java.util.List;

import tz.pgraphic.components.api.GComponent;

/**
 * 
 * @author terrazero
 * @created Jun 5, 2015
 * 
 * @file GState.java
 * @project PGraphic
 * @identifier tz.pgraphic.render
 *
 */
public class GState {

	public String name;
	private List<GComponent> components;
	public int translateX;
	public int translateY;
	
	public GState(String name) {
		this.name = name;
		this.translateX = 0;
		this.translateY = 0;
		this.components = new ArrayList<GComponent>();
	}
	
	public void add(GComponent comp) {
		this.components.add(comp);
	}
	
	public void remove(GComponent comp) {
		this.components.remove(comp);
	}
	
	public List<GComponent> components() {
		return this.components;
	}
	
}
