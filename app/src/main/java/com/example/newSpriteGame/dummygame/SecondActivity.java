package com.example.newSpriteGame.dummygame;

import com.example.emobadaragaminglib.Base.Graphics;
import com.example.emobadaragaminglib.Base.Screen;
import com.example.emobadaragaminglib.Implementation.AndroidGame;
import com.example.newSpriteGame.dummygame.GameViews.StartingScreen;
import com.example.newSpriteGame.dummygame.assets.BackgroundImage;
import com.example.newSpriteGame.dummygame.assets.Icons;
import com.example.newSpriteGame.dummygame.assets.LevelOne;
import com.example.newSpriteGame.dummygame.assets.LevelThree;
import com.example.newSpriteGame.dummygame.assets.LevelTwo;
import com.example.newSpriteGame.dummygame.assets.NoSound;
import com.example.newSpriteGame.dummygame.assets.Sound;

public class SecondActivity extends AndroidGame {
    @Override
    public Screen getInitScreen() {
        clearAssets();
        BackgroundImage.home_image = getGraphics().newImage(R.drawable.newbackimg,Graphics.ImageFormat.ARGB8888,getResources());
        BackgroundImage.play_image = getGraphics().newImage(R.drawable.play,Graphics.ImageFormat.ARGB8888,getResources());

        LevelOne.level1 = getGraphics().newImage(R.drawable.level1,Graphics.ImageFormat.ARGB8888,getResources());
        LevelTwo.level2 = getGraphics().newImage(R.drawable.level2,Graphics.ImageFormat.ARGB8888,getResources());
        LevelThree.level3 = getGraphics().newImage(R.drawable.level3,Graphics.ImageFormat.ARGB8888,getResources());
        Sound.sound_icon = getGraphics().newImage(R.drawable.sound,Graphics.ImageFormat.ARGB8888,getResources());
        NoSound.no_sound = getGraphics().newImage(R.drawable.nosound,Graphics.ImageFormat.ARGB8888,getResources());
        Icons.settings = getGraphics().newImage(R.drawable.settings,Graphics.ImageFormat.ARGB8888,getResources());
        Icons.back_img = getGraphics().newImage(R.drawable.back,Graphics.ImageFormat.ARGB8888,getResources());
        Icons.menu_img = getGraphics().newImage(R.drawable.menu,Graphics.ImageFormat.ARGB8888,getResources());
        Icons.hand_img = getGraphics().newImage(R.drawable.hand,Graphics.ImageFormat.ARGB8888,getResources());
        return new StartingScreen(this);
    }

    @Override
    public void onBackPressed() {
    }

   void clearAssets(){
       BackgroundImage.home_image = null;
       BackgroundImage.play_image = null;

       LevelOne.level1 = null;
       LevelTwo.level2 = null;
       LevelThree.level3 = null;
       Sound.sound_icon = null;
       NoSound.no_sound = null;

       Icons.back_img = null;
       Icons.menu_img = null;
   }
}
