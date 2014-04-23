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
    private Map<String, Image> imgMap;
    
    public ImageLibrary() {
        imgMap = new HashMap<>();
    }
    
    public void loadImage(String key, String filename) {
        if(imgMap.containsKey(key)) {
            System.out.println("WARNING! Attempted to load a an extra image with key " + key);
            return;
        }
        try {
            Image img = new Image(filename);
            imgMap.put(key, img);
        } catch (SlickException ex) {
            Logger.getLogger(ImageLibrary.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Image getImage(String key) {
        return imgMap.get(key);
    }
}
