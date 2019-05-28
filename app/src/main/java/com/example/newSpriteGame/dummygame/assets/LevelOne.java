package com.example.newSpriteGame.dummygame.assets;

import com.example.emobadaragaminglib.Base.Image;
import com.example.emobadaragaminglib.Components.Sprite;

public class LevelOne extends Sprite {
    /**
     * Constructor
     *
     * @param image  Bitmap of the Sprite
     * @param x      LeftTop Corner X-coordinate from where to start drawing
     * @param y      LeftTop Corner Y-coordinate from where to start drawing
     * @param height Height of the Sprite
     * @param width  Width of the sprite
     */
    public static Image level1;

    public LevelOne(Image image, int x, int y, int height, int width) {
        super(image, x, y, height, width);
    }

}
