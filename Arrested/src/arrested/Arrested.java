/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arrested;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Aaron
 */
public class Arrested extends BasicGame {
        
    private static final int SCREEN_W = 1600, SCREEN_H = 900;
    private static final int TARGET_FPS = 60;
    
    private GameState gs;
    
    @Override
    public void init(GameContainer gc) throws SlickException {
        gs = new GameState(SCREEN_W, SCREEN_H, TARGET_FPS);
    }
    
    @Override
    public void update(GameContainer gc, int i) throws SlickException {
        Input input = gc.getInput();
        gs.update(input);
        if(input.isKeyDown(Input.KEY_ESCAPE)) gc.exit();
    }

    @Override
    public void render(GameContainer gc, Graphics grphcs) throws SlickException {
        gs.render();
    }
    
    public static void main(String[] args) {
        try {
            AppGameContainer app = new AppGameContainer(new Arrested());
            app.setDisplayMode(SCREEN_W, SCREEN_H, false);
            app.setTargetFrameRate(TARGET_FPS);
            app.start();
        } catch (SlickException ex) {
            ex.printStackTrace();
        }
    }
    
    public Arrested() {
        super("Arrested");
    }
    
    private class TrominoOverlapException extends Exception {}
}
