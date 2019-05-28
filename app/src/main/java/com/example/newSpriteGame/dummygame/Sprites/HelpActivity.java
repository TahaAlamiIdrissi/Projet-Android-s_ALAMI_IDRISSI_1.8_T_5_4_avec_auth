package com.example.newSpriteGame.dummygame.Sprites;

import com.example.emobadaragaminglib.Base.Graphics;
import com.example.emobadaragaminglib.Base.Screen;
import com.example.emobadaragaminglib.Implementation.AndroidGame;
import com.example.newSpriteGame.dummygame.GameViews.HelpScreen;
import com.example.newSpriteGame.dummygame.R;
import com.example.newSpriteGame.dummygame.assets.Icons;

public class HelpActivity extends AndroidGame {
    @Override
    public Screen getInitScreen() {
        Icons.help_img = getGraphics().newImage(R.drawable.helpimage,Graphics.ImageFormat.ARGB8888,getResources());

        return new HelpScreen(this);
    }
}
