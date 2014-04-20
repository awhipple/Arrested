/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arrested.actors;

import arrested.GameState;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

/**
 *
 * @author Aaron
 */
public class Player implements Actor {

    private float x, y;
    private double speed;
    
    private Image img;
    
    public Player() {}
    
    @Override
    public void init(GameState gs) {
        x = gs.getScreenWidth() / 2;
        y = gs.getScreenHeight() / 2;
        speed = 300d;
        
        img = gs.getResLib().getImage("player");
    }
    
    @Override
    public void update(GameState gs) {
        Input input = gs.getInput();
        double delta = gs.getDelta();

        if(input.isKeyDown(Input.KEY_W)) y -= speed * delta;
        if(input.isKeyDown(Input.KEY_S)) y += speed * delta;
        
        if(input.isKeyDown(Input.KEY_A)) x -= speed * delta;
        if(input.isKeyDown(Input.KEY_D)) x += speed * delta;
    }

    @Override
    public void render() {
        img.draw(x - img.getWidth()/2, y - img.getHeight()/2);
    }
}
