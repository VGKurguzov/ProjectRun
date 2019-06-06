package com.mygdx.gamerun.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;


public class Box {

    public static final int BOX_WIDTH = 10;
    private Texture box;
    private Vector2 posBox;
    Rectangle bounds;

    public Box(float x){
        box = new Texture("box.png");
        posBox = new Vector2(x,21);
        bounds = new Rectangle(posBox.x,posBox.y,box.getWidth(),box.getHeight());
    }

    public Texture getBox() {
        return box;
    }

    public Vector2 getPosBox() {
        return posBox;
    }


    public void reposition(float x){
        posBox.set(x,21);
        bounds.setPosition(posBox.x,posBox.y);

    }

    public boolean collides(Rectangle enc){
        return enc.overlaps(bounds);
    }

    public void dispose() {
        box.dispose();
    }
}



