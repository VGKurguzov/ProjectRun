package com.mygdx.gamerun;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.gamerun.states.GameStateManager;
import com.mygdx.gamerun.states.MenuState;

public class GameRun extends ApplicationAdapter {
	private SpriteBatch batch;
	public static final int WIDTH = 480;
	public static final int HEIGHT = 320;
	public static final String TITLE = "GameRun";
	private GameStateManager manager;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		manager = new GameStateManager();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		manager.push(new MenuState(manager));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		manager.update(Gdx.graphics.getDeltaTime());
		manager.render(batch);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}


