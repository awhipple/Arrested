/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arrested.actors;

import arrested.GameState;
import org.newdawn.slick.Input;
import util.ResourceLibrary;

/**
 *
 * @author Aaron
 */
public class Player extends Character implements Actor {
       
    public Player() {}
    
    @Override
    public void init(GameState gs) {
        x = gs.getScreenWidth() / 2;
        y = gs.getScreenHeight() / 2;
        speed = 220d;

        ResourceLibrary resLib = gs.getResLib();
        
        this.setAnimations(resLib.getAnim("playerWalkUp"), 
                           resLib.getAnim("playerWalkDown"),
                           resLib.getAnim("playerWalkLeft"),
                           resLib.getAnim("playerWalkRight"),
                           resLib.getAnim("playerStandUp"),
                           resLib.getAnim("playerStandDown"),
                           resLib.getAnim("playerStandLeft"),
                           resLib.getAnim("playerStandRight"));
    }
    
    @Override
    public void update(GameState gs) {
        Input input = gs.getInput();
        double delta = gs.getDelta();

        boolean moved = false;
        
        if(input.isKeyDown(Input.KEY_W)) {
            moveUp(delta);
            moved = true;
        }
        else if(input.isKeyDown(Input.KEY_S)) {
            moveDown(delta);
            moved = true;
        }
        
        if(input.isKeyDown(Input.KEY_A)) {
            moveLeft(delta);
            moved = true;
        }
        else if(input.isKeyDown(Input.KEY_D)) {
            moveRight(delta);
            moved = true;
        }
        
        if(!moved) stopMoving();
    }

    @Override
    public void render() {
        draw();
    }
}
