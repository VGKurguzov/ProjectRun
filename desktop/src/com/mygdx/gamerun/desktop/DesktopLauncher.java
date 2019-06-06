package com.mygdx.gamerun.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.gamerun.GameRun;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = GameRun.WIDTH;
		config.height = GameRun.HEIGHT;
		config.title = GameRun.TITLE;
		new LwjglApplication(new GameRun(), config);
	}
}
