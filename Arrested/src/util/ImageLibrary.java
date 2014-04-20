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
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Aaron
 */
public class ImageLibrary {
    private Map<String, Image> imageMap;
    
    public ImageLibrary() {
        imageMap = new HashMap<>();
    }
    
    public void loadImage(String key, String filename) {
        if(imageMap.containsKey(key)) return;
        try {
            imageMap.put(key, new Image(filename));
        } catch (SlickException ex) {
            Logger.getLogger(ImageLibrary.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Image getImage(String key) {
        return imageMap.get(key);
    }
}
