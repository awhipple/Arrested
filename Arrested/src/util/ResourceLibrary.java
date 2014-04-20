/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import org.newdawn.slick.Image;

/**
 *
 * @author Aaron
 */
public class ResourceLibrary {
    private ImageLibrary imgLib;
    
    public ResourceLibrary() {
        imgLib = new ImageLibrary();
        
        imgLib.loadImage("player", "res/images/player.png");
    }
    
    public Image getImage(String key) {
        return imgLib.getImage(key);
    }
}
