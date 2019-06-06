package com.mygdx.gamerun.sprites;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Player {
    public static final int GRAVITY = -12;
    private int movement;
    private Vector3 position;
    private Vector3 speed;
    private Texture player;
    private Rectangle bounds;
    private int countJump;

    public void setCountJump() {
        this.countJump++;
    }



    public Player(int x, int y){
        position = new Vector3(x, y,0);
        speed = new Vector3(0,0,0);
        player = new Texture("hero.png");
        bounds = new Rectangle(x , y, player.getWidth(), player.getHeight());
        countJump = 0;
    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getPlayer() {
        return player;
    }

    public void update(float dt){
        movement = (countJump/5)*6 + 90 ;
        speed.add(0,GRAVITY,0);
        speed.scl(dt);
        position.add(movement*dt, speed.y, 0);
        if(position.y < 21)
            position.y = 21;
        speed.scl(1/dt);
        bounds.setPosition(position.x, position.y);
    }

    public void jump(){
        speed.y = 285;
    }

    public Rectangle getBounds(){
        return bounds;
    }

    public void dispose() {
        player.dispose();
    }
}



