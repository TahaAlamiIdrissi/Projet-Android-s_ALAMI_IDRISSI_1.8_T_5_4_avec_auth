package com.example.newSpriteGame.dummygame;


import com.example.emobadaragaminglib.Base.Graphics;
import com.example.emobadaragaminglib.Base.Screen;
import com.example.emobadaragaminglib.Implementation.AndroidGame;
import com.example.newSpriteGame.dummygame.Database.GameAssets;
import com.example.newSpriteGame.dummygame.GameViews.MainScreen;
import com.example.newSpriteGame.dummygame.assets.BackGroundMusic;
import com.example.newSpriteGame.dummygame.assets.BackgroundImage;
import com.example.newSpriteGame.dummygame.assets.Bar;
import com.example.newSpriteGame.dummygame.assets.Icons;
import com.example.newSpriteGame.dummygame.assets.Ring;
import com.example.newSpriteGame.dummygame.assets.Score;

public class MainActivity2 extends AndroidGame {
    @Override
    public Screen getInitScreen() {
       /* BackgroundImage.bg_image = getGraphics().newImage(R.drawable.bg,Graphics.ImageFormat.ARGB8888,getResources());
        BackgroundImage.play_image = getGraphics().newImage(R.drawable.play,Graphics.ImageFormat.ARGB8888,getResources());
        BackgroundImage.cross_error = getGraphics().newImage(R.drawable.crosserror,Graphics.ImageFormat.ARGB8888,getResources());



        Icons.back_img = getGraphics().newImage(R.drawable.back,Graphics.ImageFormat.ARGB8888,getResources());
        Icons.menu_img = getGraphics().newImage(R.drawable.menu,Graphics.ImageFormat.ARGB8888,getResources());
        Icons.win_img = getGraphics().newImage(R.drawable.win,Graphics.ImageFormat.ARGB8888,getResources());

        Ring.fourRings = getGraphics().newImage(R.drawable.fourrings,Graphics.ImageFormat.ARGB8888,getResources());
        Ring.threeRings = getGraphics().newImage(R.drawable.threerings,Graphics.ImageFormat.ARGB8888,getResources());
        Ring.verticalRing = getGraphics().newImage(R.drawable.verticalring,Graphics.ImageFormat.ARGB8888,getResources());
        Ring.twoRings = getGraphics().newImage(R.drawable.tworings,Graphics.ImageFormat.ARGB8888,getResources());
        Ring.barRing = getGraphics().newImage(R.drawable.barering,Graphics.ImageFormat.ARGB8888,getResources());
        Ring.horizontalRing = getGraphics().newImage(R.drawable.horizontalring,Graphics.ImageFormat.ARGB8888,getResources());

        Bar.drawbare = getGraphics().newImage(R.drawable.drawbare,Graphics.ImageFormat.ARGB8888,getResources());
*/
        clearAssets();
        BackgroundImage.home_image = getGraphics().newImage(R.drawable.home,Graphics.ImageFormat.ARGB8888,getResources());
        BackGroundMusic.bg_music = getAudio().createMusic(R.raw.kids);
        BackGroundMusic.success_sound = getAudio().createMusic(R.raw.bravo);
        BackGroundMusic.failSound = getAudio().createMusic(R.raw.ohreessaye);
        BackGroundMusic.successfull = getAudio().createMusic(R.raw.continuee);
        BackGroundMusic.winingSound = getAudio().createMusic(R.raw.wining);

        if(Score.game == null){
            Score.game = new GameAssets("taha_id","exercice1.8","3","none",String.valueOf(Score.successful_attempt),String.valueOf(Score.failure_attempt),"none","none","none","none","device1","flag1");
        }
        //The method is going to
        return new MainScreen(this);
    }


    void clearAssets(){
        BackgroundImage.bg_image = null;
        BackgroundImage.play_image = null;
        BackgroundImage.cross_error = null;



        Icons.back_img = null;
        Icons.menu_img = null;
        Icons.win_img = null;

        Ring.fourRings = null;
        Ring.threeRings = null;
        Ring.verticalRing = null;
        Ring.twoRings = null;
        Ring.barRing = null;
        Ring.horizontalRing = null;

        Bar.drawbare = null;

        BackgroundImage.home_image = null;
        BackGroundMusic.bg_music = null;
        BackGroundMusic.success_sound = null;
        BackGroundMusic.successfull = null;
        BackGroundMusic.winingSound = null;
    }
}
