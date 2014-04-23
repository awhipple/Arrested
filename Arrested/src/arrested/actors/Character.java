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
    private String[] moveNames, standNames;
    
    protected double x, y;
    protected double speed;
    protected int dir;
    
    protected CharacterActions act;
    
    public Character() {
        sprite = new Sprite();
        
        this.x = 0;
        this.y = 0;
        this.speed = 100d;
        this.dir = 3;
        
        act = new CharacterActions();
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
        
        moveNames = new String[] {"move", "moveUp", "moveRight", "moveDown", "moveLeft"};
        standNames = new String[] {"stand", "standUp", "standRight", "standDown", "standLeft"};
    }

    protected void updateActions(double delta) {
        double curSpeed = (act.moveHorizontal != 0 && act.moveVertical != 0) ? speed * 0.71d : speed;
        x += curSpeed * delta * act.moveHorizontal;
        y += curSpeed * delta * act.moveVertical;

        if(act.changeDir != 0) {
            dir = act.changeDir;
            act.changeDir = 0;
        }
        
        if(dir != 0) {
            if(act.moveVertical != 0 || act.moveHorizontal != 0) {
                sprite.setAnimation(moveNames[dir]);
            } else {
                sprite.setAnimation(standNames[dir]);
            }
            dir = 0;
        }
    }
    public void draw() {
        sprite.draw((int)x, (int)y);
    }
}
