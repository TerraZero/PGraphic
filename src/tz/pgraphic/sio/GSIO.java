package tz.pgraphic.sio;


public class GSIO {
	
	public static GGlobalActions global;
	public static GScreen screen;
	public static GKeyboard keyboard;

	public static void init() {
		GSIO.global = new GGlobalActions();
		GSIO.screen = new GScreen();
		GSIO.keyboard = new GKeyboard();
	}

}
