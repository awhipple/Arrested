/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arrested.actors;

import arrested.GameState;

/**
 *
 * @author Aaron
 */
public interface Actor {
    public void init(GameState gs);
    public void update(GameState gs);
    public void render();
}
