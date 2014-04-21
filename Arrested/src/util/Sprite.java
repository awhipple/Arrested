/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.util.HashMap;
import java.util.Map;
import org.newdawn.slick.Animation;

/**
 *
 * @author Aaron
 */
public class Sprite {
    private Map<String, Animation> aniMap;
    private Animation curAnim;
    private int halfWidth, halfHeight;
    
    public Sprite() {
        aniMap = new HashMap<>();
        curAnim = null;
    }
    
    public void addAnimation(String key, Animation anim) {
        aniMap.put(key, anim);
    }
    
    public void setAnimation(String key) {
        curAnim = aniMap.get(key);
        halfWidth = curAnim.getWidth()/2;
        halfHeight = curAnim.getHeight()/2;
    }
    
    public void draw(int x, int y) {
        if(curAnim != null) curAnim.draw(x-halfWidth, y-halfHeight);
    }
}
