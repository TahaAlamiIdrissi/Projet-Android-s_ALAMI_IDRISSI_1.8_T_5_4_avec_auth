package com.example.newSpriteGame.dummygame;

import com.example.emobadaragaminglib.Base.Graphics;
import com.example.emobadaragaminglib.Base.Screen;
import com.example.emobadaragaminglib.Implementation.AndroidGame;
import com.example.newSpriteGame.dummygame.GameViews.MenuScreen;
import com.example.newSpriteGame.dummygame.assets.BackGroundMusic;
import com.example.newSpriteGame.dummygame.assets.BackgroundImage;
import com.example.newSpriteGame.dummygame.assets.Icons;

public class MenuActivity extends AndroidGame {
    @Override
    public Screen getInitScreen() {

        Icons.help_img =  getGraphics().newImage(R.drawable.helpimage,Graphics.ImageFormat.ARGB8888,getResources());
        BackgroundImage.home_image = getGraphics().newImage(R.drawable.newbackimg,Graphics.ImageFormat.ARGB8888,getResources());
        Icons.table_img = getGraphics().newImage(R.drawable.tableau,Graphics.ImageFormat.ARGB8888,getResources());
        Icons.desc_img = getGraphics().newImage(R.drawable.descfr,Graphics.ImageFormat.ARGB8888,getResources());
        Icons.back_img = getGraphics().newImage(R.drawable.back,Graphics.ImageFormat.ARGB8888,getResources());
        BackGroundMusic.helpSound = getAudio().createMusic(R.raw.helpsong);
        return new MenuScreen(this);
    }

    @Override
    public void onBackPressed() {

    }
}
