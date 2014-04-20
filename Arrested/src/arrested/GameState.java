/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arrested;

import arrested.actors.Actor;
import arrested.actors.Player;
import java.util.LinkedList;
import java.util.List;
import org.newdawn.slick.Input;
import util.ResourceLibrary;

/**
 *
 * @author Aaron
 */
public class GameState {
    
    private final int screenWidth, screenHeight;
    private final double delta;
    
    private final List<Actor> actorList, actorsToBeAdded;
    
    private final ResourceLibrary resLib;

    private Input input;
    
    public GameState(int screenWidth, int screenHeight, int fps) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        
        this.delta = 1d/fps;
        
        resLib = new ResourceLibrary();
        
        actorList = new LinkedList<>();
        actorsToBeAdded = new LinkedList<>();
        
        addNewActor(new Player());
        updateActorList();
    }
    
    public void update(Input input) {
        this.input = input;
        for(Actor actor : actorList) {
            actor.update(this);
        }
    }
    
    public void render() {
        for(Actor actor : actorList) {
            actor.render();
        }
    }

    public int getScreenWidth() { return screenWidth; }
    public int getScreenHeight() { return screenHeight; }
    public double getDelta() { return delta; }
    public Input getInput() { return input; }
    public ResourceLibrary getResLib() { return resLib; }
    
    private void addNewActor(Actor actor) {
        actor.init(this);
        actorsToBeAdded.add(actor);
    }
    
    private void updateActorList() {
        while(actorsToBeAdded.size() > 0) {
            actorList.add(actorsToBeAdded.remove(0));
        }
    }
}
