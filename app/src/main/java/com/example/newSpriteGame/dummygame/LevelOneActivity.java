package com.example.newSpriteGame.dummygame;

import com.example.emobadaragaminglib.Base.Graphics;
import com.example.emobadaragaminglib.Base.Screen;
import com.example.emobadaragaminglib.Implementation.AndroidGame;
import com.example.newSpriteGame.dummygame.GameViews.LevelOneGameScreen;
import com.example.newSpriteGame.dummygame.assets.BackGroundMusic;
import com.example.newSpriteGame.dummygame.assets.BackgroundImage;
import com.example.newSpriteGame.dummygame.assets.Bar;
import com.example.newSpriteGame.dummygame.assets.Icons;
import com.example.newSpriteGame.dummygame.assets.NoSound;
import com.example.newSpriteGame.dummygame.assets.Ring;
import com.example.newSpriteGame.dummygame.assets.Sound;

public class LevelOneActivity extends AndroidGame {

    @Override
    public Screen getInitScreen() {
        BackGroundMusic.winingSound.stop();
        BackgroundImage.home_image = getGraphics().newImage(R.drawable.bg,Graphics.ImageFormat.ARGB8888,getResources());
        BackgroundImage.cross_error = getGraphics().newImage(R.drawable.crosserror,Graphics.ImageFormat.ARGB8888,getResources());
        Ring.barRing = getGraphics().newImage(R.drawable.barering,Graphics.ImageFormat.ARGB8888,getResources());
        Ring.horizontalRing = getGraphics().newImage(R.drawable.horizontalring,Graphics.ImageFormat.ARGB8888,getResources());

        Bar.drawbare = getGraphics().newImage(R.drawable.drawbare,Graphics.ImageFormat.ARGB8888,getResources());
        Sound.sound_icon = getGraphics().newImage(R.drawable.sound,Graphics.ImageFormat.ARGB8888,getResources());
        NoSound.no_sound = getGraphics().newImage(R.drawable.nosound,Graphics.ImageFormat.ARGB8888,getResources());
        Icons.help = getGraphics().newImage(R.drawable.help,Graphics.ImageFormat.ARGB8888,getResources());
        Icons.help_img = getGraphics().newImage(R.drawable.helpimage,Graphics.ImageFormat.ARGB8888,getResources());
        Icons.back_img = getGraphics().newImage(R.drawable.back,Graphics.ImageFormat.ARGB8888,getResources());

        return new LevelOneGameScreen(this);
    }

    @Override
    public void onBackPressed() {

    }
}
