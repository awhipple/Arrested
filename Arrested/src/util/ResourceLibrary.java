/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;

/**
 *
 * @author Aaron
 */
public class ResourceLibrary {
    private AnimationLibrary animLib;
    private ImageLibrary imgLib;
    
    public ResourceLibrary() {
        imgLib = new ImageLibrary();
        animLib = new AnimationLibrary();
        
        imgLib.loadImage("cursor", "res/images/cursor.png");
        
        animLib.loadAnim("playerWalkUp", "res/images/playerWalkUp.png");
        animLib.loadAnim("playerWalkDown", "res/images/playerWalkDown.png");
        animLib.loadAnim("playerWalkLeft", "res/images/playerWalkLeft.png");
        animLib.flipAnim("playerWalkRight", "playerWalkLeft");
        
        animLib.loadAnim("playerStandUp", "res/images/playerStandUp.png");
        animLib.loadAnim("playerStandDown", "res/images/playerStandDown.png");
        animLib.loadAnim("playerStandLeft", "res/images/playerStandLeft.png");
        animLib.flipAnim("playerStandRight", "playerStandLeft");
    }
    
    public Image getImg(String key) {
        return imgLib.getImage(key);
    }
    
    public Animation getAnim(String key) {
        return animLib.getAnim(key);
    }
}
