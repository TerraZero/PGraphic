package tz.pgraphic.sio;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;

import tz.pgraphic.G;

public class GScreen {
	
	private boolean isFullscreen;

	public void setFullscreen(boolean fullscreen) {
		if (fullscreen != this.isFullscreen) {
			G.loop.interrupt(true);
			if (fullscreen) {
				G.frame.dispose();
				G.frame.setAlwaysOnTop(true);
				G.frame.setUndecorated(true);
				G.frame.setVisible(true);
				this.getDefaultWindow().setFullScreenWindow(G.frame);
			} else {
				G.frame.dispose();
				G.frame.setUndecorated(false);
				G.frame.setAlwaysOnTop(false);
				G.frame.setVisible(true);
				G.frame.setState(JFrame.NORMAL);
			}
			this.isFullscreen = fullscreen;
			G.loop.interrupt(false);
		}
	}
	
	public GraphicsDevice getDefaultWindow() {
		return GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	}
	
	public boolean isFullscreen() {
		return this.isFullscreen;
	}

}
