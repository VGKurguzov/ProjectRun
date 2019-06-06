package com.mygdx.gamerun.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.gamerun.GameRun;

public class GameOverState extends State {

    private Texture background;
    private Texture gameOver;

    public GameOverState(GameStateManager manager) {
        super(manager);
        camera.setToOrtho(false,GameRun.WIDTH/PlayState.FOCUS,
                GameRun.HEIGHT/PlayState.FOCUS);
        background = new Texture("backgrounds.png");
        gameOver = new Texture("gameover.png");
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            manager.set(new PlayState(manager));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(background,camera.position.x - (camera.viewportWidth / 2), 0);
        sb.draw(gameOver,camera.viewportWidth / 2 - (gameOver.getWidth() / 2),
                camera.viewportHeight / 2 - (gameOver.getHeight() / 2));
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        gameOver.dispose();
    }
}

