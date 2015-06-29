package tz.pgraphic.sio;

public class GSIO {
	
	public static GScreen screen;
	public static GKeyboard keyboard;

	public static void init() {
		GSIO.screen = new GScreen();
		GSIO.keyboard = new GKeyboard();
	}

}
