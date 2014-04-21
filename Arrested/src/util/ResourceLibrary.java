/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import org.newdawn.slick.Animation;

/**
 *
 * @author Aaron
 */
public class ResourceLibrary {
    private AnimationLibrary animLib;
    
    public ResourceLibrary() {
        animLib = new AnimationLibrary();
        
        animLib.loadAnim("playerWalkUp", "res/images/playerWalkUp.png");
        animLib.loadAnim("playerWalkDown", "res/images/playerWalkDown.png");
        animLib.loadAnim("playerWalkLeft", "res/images/playerWalkLeft.png");
        animLib.flipAnim("playerWalkRight", "playerWalkLeft");
        
        animLib.loadAnim("playerStandUp", "res/images/playerStandUp.png");
        animLib.loadAnim("playerStandDown", "res/images/playerStandDown.png");
        animLib.loadAnim("playerStandLeft", "res/images/playerStandLeft.png");
        animLib.flipAnim("playerStandRight", "playerStandLeft");
    }
    
    public Animation getAnim(String key) {
        return animLib.getAnim(key);
    }
}
