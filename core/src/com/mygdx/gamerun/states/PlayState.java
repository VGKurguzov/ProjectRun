package com.mygdx.gamerun.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.gamerun.GameRun;
import com.mygdx.gamerun.sprites.Box;
import com.mygdx.gamerun.sprites.Player;
import java.util.ArrayList;
import java.util.Random;

public class PlayState extends State {
    public static final float FOCUS = 1.7f;
    public static final int BOX_SPACING = 100;
    public static final int BOX_COUNT = 5;

    private Player player;
    private Texture background;
    private Texture floor;
    private Box box;
    private Random random;
    private Vector2 floorPos1, floorPos2;


    private ArrayList<Box> boxes;

    public PlayState(GameStateManager manager) {
        super(manager);
        camera.setToOrtho(false,GameRun.WIDTH/FOCUS,GameRun.HEIGHT/FOCUS);
        player = new Player(6, 21);
        background = new Texture("backgrounds.png");
        floor = new Texture("floor.png");
        floorPos1 = new Vector2(camera.position.x - camera.viewportWidth / 2, 0);
        floorPos2 = new Vector2((camera.position.x - camera.viewportWidth / 2) + floor.getWidth(), 0);
        box = new Box(20);
        boxes = new ArrayList<Box>();
        random = new Random();

        for(int i = 1;i <= BOX_COUNT;i++){
            boxes.add(new Box(i*(BOX_SPACING + BOX_SPACING + Box.BOX_WIDTH)));
        }
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched() && player.getPosition().y == 21){
            player.jump();
            player.setCountJump();
        }

    }

    @Override
    public void update(float dt) {
        handleInput();
        player.update(dt);
        updatefloor();
        camera.position.x = player.getPosition().x + 130;

        for(int j = 0 ;j < boxes.size(); j++){

            Box box = boxes.get(j);

            if(camera.position.x - (camera.viewportWidth / 2) > box.getPosBox().x + box.getPosBox().y){
                box.reposition(box.getPosBox().x + (box.BOX_WIDTH + BOX_SPACING * BOX_COUNT));
            }
            if(box.collides(player.getBounds())){
                manager.set(new GameOverState(manager));
            }

        }
        camera.update();

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(background,camera.position.x - (camera.viewportWidth / 2), 0);
        sb.draw(player.getPlayer(), player.getPosition().x, player.getPosition().y);
        for(Box box : boxes){
            sb.draw(box.getBox(),box.getPosBox().x,box.getPosBox().y);
        }
        sb.draw(floor,floorPos1.x, floorPos1.y);
        sb.draw(floor,floorPos2.x, floorPos2.y);
        sb.end();

    }

    @Override
    public void dispose() {
        background.dispose();
        player.dispose();
        for(Box box : boxes){
            box.dispose();
        }
        floor.dispose();
    }

    private void updatefloor(){
        if (camera.position.x - (camera.viewportWidth / 2) > floorPos1.x + floor.getWidth()){
                floorPos1.add(floor.getWidth() * 2, 0);
        }
        if (camera.position.x - (camera.viewportWidth / 2) > floorPos2.x + floor.getWidth()){
            floorPos2.add(floor.getWidth() * 2, 0);
        }
    }

}
