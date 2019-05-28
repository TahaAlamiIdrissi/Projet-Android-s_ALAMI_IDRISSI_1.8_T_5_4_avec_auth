package com.example.newSpriteGame.dummygame.GameViews;

import com.example.emobadaragaminglib.Base.Game;
import com.example.emobadaragaminglib.Base.Screen;
import com.example.emobadaragaminglib.Components.Sprite;
import com.example.newSpriteGame.dummygame.assets.Icons;

public class HelpScreen extends Screen {
    private Sprite helpImage;
    int X = game.getScreenWidth();
    int Y = game.getScreenHeight();
    public HelpScreen(Game game) {
        super(game);
        helpImage = new Sprite(Icons.help_img,X/6,Y/6,1000,1600);
        addSprite(helpImage);
    }

    @Override
    public void render(float deltaTime) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void backButton() {

    }
}
