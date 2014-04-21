/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arrested.actors;

import org.newdawn.slick.Animation;
import util.Sprite;

/**
 *
 * @author Aaron
 */
public class Character {
    private Sprite sprite;
    
    protected double x, y;
    protected double speed;
    protected int dir;
    
    public Character() {
        sprite = new Sprite();
        
        this.x = 0;
        this.y = 0;
        this.speed = 100d;
        this.dir = 3;
    }
    
    public void setAnimations(Animation moveUp, Animation moveDown, Animation moveLeft, Animation moveRight, 
                              Animation standUp, Animation standDown, Animation standLeft, Animation standRight) {
        sprite.addAnimation("moveUp", moveUp);
        sprite.addAnimation("moveDown", moveDown);
        sprite.addAnimation("moveLeft", moveLeft);
        sprite.addAnimation("moveRight", moveRight);
        sprite.addAnimation("standUp", standUp);
        sprite.addAnimation("standDown", standDown);
        sprite.addAnimation("standLeft", standLeft);
        sprite.addAnimation("standRight", standRight);
        sprite.setAnimation("standRight");
    }
    
    public void moveUp(double delta) {
        y -= speed * delta;
        if(dir != 1) {
            dir = 1;
            sprite.setAnimation("moveUp");
        }
    }
    public void moveDown(double delta) {
        y += speed * delta;
        if(dir != 3) {
            dir = 3;
            sprite.setAnimation("moveDown");
        }
    }
    public void moveLeft(double delta) {
        x -= speed * delta;
        if(dir != 4) {
            dir = 4;
            sprite.setAnimation("moveLeft");
        }
    }
    public void moveRight(double delta) {
        x += speed * delta;
        if(dir != 2) {
            dir = 2;
            sprite.setAnimation("moveRight");
        }
    }
    public void stopMoving() {
        switch(dir) {
            case 1: sprite.setAnimation("standUp");
                    break;
            case 2: sprite.setAnimation("standRight");
                    break;
            case 3: sprite.setAnimation("standDown");
                     break;
            case 4: sprite.setAnimation("standLeft");
                    break;
        }
        dir = 0;
    }
    public void draw() {
        sprite.draw((int)x, (int)y);
    }
}