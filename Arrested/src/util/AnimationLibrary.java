/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

/**
 *
 * @author Aaron
 */
public class AnimationLibrary {
    private Map<String, Animation> aniMap;
    
    public AnimationLibrary() {
        aniMap = new HashMap<>();
    }
    
    public void loadAnim(String key, String filename) {
        if(aniMap.containsKey(key)) return;
        try {
            Image img = new Image(filename);
            img = img.getScaledCopy(img.getWidth()*2, img.getHeight()*2);
            SpriteSheet ss = new SpriteSheet(img, 60, 50);
            Animation anim = new Animation(ss, 100);
            aniMap.put(key, anim);
        } catch (SlickException ex) {
            Logger.getLogger(AnimationLibrary.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void flipAnim(String newKey, String key) {
        Animation oldAnim = aniMap.get(key),
                  newAnim = new Animation();
        for(int i = 0; i < oldAnim.getFrameCount(); i++) {
            newAnim.addFrame(oldAnim.getImage(i).getFlippedCopy(true, false), 100);
        }
        
        aniMap.put(newKey, newAnim);
    }
    
    public Animation getAnim(String key) {
        return aniMap.get(key);
    }
}
