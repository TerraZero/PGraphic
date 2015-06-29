package tz.pgraphic;

import tz.pgraphic.components.GField;

/**
 * 
 * @author terrazero
 * @created Jun 4, 2015
 * 
 * @file GExample.java
 * @project PGraphic
 * @identifier tz.pgraphic
 *
 */
public class GExample {

	public static void main(String[] args) {
		G.init();
		G.frame.setTitle("Test");
		GField c = new GField();
		c.x.set(50).ani(250).speed(0.01f);
		c.y.set(50).ani(250).speed(0.01f);
		c.width.set(400).ani(0).speed(-0.02f);
		c.height.set(400).ani(0).speed(-0.02f);
		G.state().add(c);
		G.show();
	}
	
}
