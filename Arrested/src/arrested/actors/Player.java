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

        act.moveVertical = 0;
        if(input.isKeyDown(Input.KEY_W)) {
            act.moveVertical--;
        }
        if(input.isKeyDown(Input.KEY_S)) {
            act.moveVertical++;
        }
        
        act.moveHorizontal = 0;
        if(input.isKeyDown(Input.KEY_A)) {
            act.moveHorizontal--;
        }
        if(input.isKeyDown(Input.KEY_D)) {
            act.moveHorizontal++;
        }
        
        double radToCursor = util.GameMath.pointsToRad(x, y, input.getMouseX(), input.getMouseY());
        
        if(radToCursor >= Math.PI*1.25 && radToCursor <= Math.PI*1.75) act.changeDir = 1;
        else if(radToCursor >= Math.PI*1.75 || radToCursor <= Math.PI*0.25) act.changeDir = 2;
        else if(radToCursor >= Math.PI*0.25 && radToCursor <= Math.PI*0.75) act.changeDir = 3;
        else act.changeDir = 4;
        
        updateActions(delta);
    }

    @Override
    public void render() {
        draw();
    }
}
