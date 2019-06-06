package com.mygdx.gamerun.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.gamerun.GameRun;

public class MenuState extends State {

    private Texture background;
    private Texture playbtn;

    public MenuState(GameStateManager manager) {
        super(manager);
        camera.setToOrtho(false,GameRun.WIDTH/PlayState.FOCUS,
                GameRun.HEIGHT/PlayState.FOCUS);
        background = new Texture("backgrounds.png");
        playbtn = new Texture("playbtn.png");
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
        sb.draw(playbtn,camera.viewportWidth / 2 - (playbtn.getWidth() / 2),
                camera.viewportHeight / 2 - (playbtn.getHeight() / 2));
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playbtn.dispose();
    }
}



