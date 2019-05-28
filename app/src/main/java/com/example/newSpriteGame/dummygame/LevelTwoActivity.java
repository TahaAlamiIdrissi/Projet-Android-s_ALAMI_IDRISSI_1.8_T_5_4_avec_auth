package com.example.newSpriteGame.dummygame;

import com.example.emobadaragaminglib.Base.Graphics;
import com.example.emobadaragaminglib.Base.Screen;
import com.example.emobadaragaminglib.Implementation.AndroidGame;
import com.example.newSpriteGame.dummygame.GameViews.LevelTwoGameScreen;
import com.example.newSpriteGame.dummygame.assets.BackGroundMusic;
import com.example.newSpriteGame.dummygame.assets.BackgroundImage;
import com.example.newSpriteGame.dummygame.assets.Bar;
import com.example.newSpriteGame.dummygame.assets.Ring;

public class LevelTwoActivity extends AndroidGame {
    @Override
    public Screen getInitScreen() {
        BackGroundMusic.winingSound.stop();

        BackgroundImage.home_image = getGraphics().newImage(R.drawable.bg,Graphics.ImageFormat.ARGB8888,getResources());
        BackgroundImage.cross_error = getGraphics().newImage(R.drawable.crosserror,Graphics.ImageFormat.ARGB8888,getResources());
        Ring.barRing = getGraphics().newImage(R.drawable.barering,Graphics.ImageFormat.ARGB8888,getResources());
        Ring.horizontalRing = getGraphics().newImage(R.drawable.horizontalring,Graphics.ImageFormat.ARGB8888,getResources());

        Bar.drawbare = getGraphics().newImage(R.drawable.drawbare,Graphics.ImageFormat.ARGB8888,getResources());
        return new LevelTwoGameScreen(this);
    }
}
