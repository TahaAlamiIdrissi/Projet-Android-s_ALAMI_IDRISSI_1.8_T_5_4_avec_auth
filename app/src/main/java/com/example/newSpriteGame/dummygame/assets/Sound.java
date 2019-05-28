package com.example.newSpriteGame.dummygame.assets;

import com.example.emobadaragaminglib.Base.Image;
import com.example.emobadaragaminglib.Components.Sprite;

public class Sound extends Sprite {
    public static Image sound_icon;
    /**
     * Constructor
     *
     * @param image  Bitmap of the Sprite
     * @param x      LeftTop Corner X-coordinate from where to start drawing
     * @param y      LeftTop Corner Y-coordinate from where to start drawing
     * @param height Height of the Sprite
     * @param width  Width of the sprite
     */
    public Sound(Image image, int x, int y, int height, int width) {
        super(image, x, y, height, width);
    }
}
