package com.example.newSpriteGame.dummygame.GameViews;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.emobadaragaminglib.Base.Game;
import com.example.emobadaragaminglib.Base.Screen;
import com.example.emobadaragaminglib.Components.Sprite;
import com.example.newSpriteGame.dummygame.SecondActivity;
import com.example.newSpriteGame.dummygame.assets.Back;
import com.example.newSpriteGame.dummygame.assets.BackGroundMusic;
import com.example.newSpriteGame.dummygame.assets.BackgroundImage;
import com.example.newSpriteGame.dummygame.assets.Bar;
import com.example.newSpriteGame.dummygame.assets.Hand;
import com.example.newSpriteGame.dummygame.assets.Help;
import com.example.newSpriteGame.dummygame.assets.Icons;
import com.example.newSpriteGame.dummygame.assets.NoSound;
import com.example.newSpriteGame.dummygame.assets.Ring;
import com.example.newSpriteGame.dummygame.assets.Score;
import com.example.newSpriteGame.dummygame.assets.Sound;

public class LevelOneGameScreen extends Screen {
    private static int flagUp= -1;
    private  static int flagDown = -1;
    private static int fails = 0;
    private static int failFlag = -1;
    private  static int backOne = 0;
    private Sprite bg;
    private Sprite home;
    private Sprite welcome;
    private Sprite horiRing;
    private Sprite horiRing2;
    private Sprite horiRing3;
    private Sprite horiRing4;
    private Sprite horiRing5;
    private Sprite menu,back,help ;
    private Sprite fourRings;
    private Sprite twoRings;
    private Sprite threeRings;
    private Sprite drawbare;
    private Sprite winSprite;
    private Sprite drawbarRing;
    private Sprite cross_error;
    private Sprite helpImage;
    private Sound sound;
    private Sound no_sound;
    private int sound_on=0;
    int X = game.getScreenWidth() ;
    int Y = game.getScreenHeight();
    private static int showingFlag= -1;
    private Hand hand;
    public LevelOneGameScreen(Game game) {
        super(game);
        BackGroundMusic.bg_music.stop();
        home = new Sprite(BackgroundImage.home_image,0,0,game.getGraphics().getHeight(),game.getGraphics().getWidth());
        horiRing = new Sprite(Ring.horizontalRing,198,790,90,250);
        horiRing2 = new Sprite(Ring.horizontalRing,198,730,90,250);
        horiRing4 = new Sprite(Ring.horizontalRing,198,670,90,250);
        drawbarRing = new Sprite(Ring.barRing,game.getScreenHeight()/4,game.getScreenWidth()/4,90,250);
        drawbare = new Sprite(Bar.drawbare,game.getScreenHeight(),game.getScreenWidth()/4,500,300);
        sound = new Sound(Sound.sound_icon,(int)(X/1.2),(int)(Y/1.2),(Y/8),(int)(X/8));
        no_sound = new Sound(NoSound.no_sound,(int)(X/1.2),(int)(Y/1.2),(Y/8),(int)(X/8));
        back = new Back(Icons.back_img,0,0,(int)(game.getScreenHeight()/7.5),(int)(game.getScreenWidth()/7.5));
        help = new Help(Icons.help,(int)(X/1.2),0,(int)(game.getScreenHeight()/7.8),(int)(game.getScreenWidth()/7.8));
        helpImage = new Sprite(Icons.help_img,X/6,Y/9,1000,1600);
        hand = new Hand(Icons.hand_img,400,600,(int)(game.getScreenHeight()/7.8),(int)(game.getScreenWidth()/7.8));
        drawbare.setStatic(true);
        addSprite(home);
        addSprite(back);
        addSprite(no_sound);
        addSprite(sound);
        addSprite(help);
        addSprite(hand);
        addNewSprites();
    }

    @Override
    public void render(float deltaTime) {
        doAllTheWork();
        if(showingFlag == 0){
            addSprite(helpImage);
            showingFlag ++;
        }
        if(!hand.contain(1240,450)){
            hand.setX(hand.getX()+10);
            hand.setY(hand.getY()-2);
        }else {
            hand.setWidth(0);
            hand.setHeight(0);
        }

    }

    @Override
    public void pause() {

    }

    @Override
    public void handleTouchUp(int x, int y, int pointer) {
        Sprite s = getDraggedSprite();
        if(s!=null && s.getClass()==Back.class){
            Intent myIntent = new Intent((Context)game,SecondActivity.class);
            myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            ((Context)game).getApplicationContext().startActivity(myIntent);

        }else if(s!=null && s.getClass()==Sound.class){
            if(sound_on == 0){
                BackGroundMusic.bg_music.play();
                sound.setHeight((Y/7));
                sound.setWidth((X/7));
                no_sound.setHeight(0);
                no_sound.setWidth(0);
                sound_on = 1;
            }else{
                BackGroundMusic.bg_music.stop();
                no_sound.setHeight((Y/7));
                no_sound.setWidth((X/7));
                sound.setHeight(0);
                sound.setWidth(0);
                sound_on = 0;
            }
        }else if(s!=null && s.getClass()==Help.class){
            showingFlag = 0;
        }
        if( flagUp == -1){
            BackGroundMusic.bg_music.stop();
            flagUp = 0;
        }
        if( showingFlag != 0){
           helpImage.setHeight(0);
           helpImage.setHeight(0);
           showingFlag = 0;
        }
    }


    @Override
    public void resume() {

    }
    public void addNewSprites(){
        addSprite(drawbare);
        addSprite(horiRing);
        addSprite(horiRing2);
        addSprite(horiRing4);
    }
    public void fallingRingFour(){
        horiRing4.setPosition(1233,847);
        horiRing4.setDragged(false);
        horiRing4.setStatic(true);
        BackGroundMusic.success_sound.play();
        flagUp=-2;
        Score.successful_attempt++;
    }
    public void fallingRingTwo(){
        horiRing2.setImage(drawbarRing.getImage());
        horiRing2.setPosition(1233,760);
        horiRing2.setDragged(false);
        horiRing2.setStatic(true);
        BackGroundMusic.successfull.play();
        flagUp=-4;
        Score.successful_attempt++;
    }
    public void fallingRingOne(){
        horiRing.setImage(drawbarRing.getImage());
        horiRing.setPosition(1233,680);
        horiRing.setDragged(false);
        horiRing.setStatic(true);
        BackGroundMusic.success_sound.play();
        Score.successful_attempt++;
    }
    public void doAllTheWork(){
        flagUp = 0;

        if(flagUp == 0){
            horiRing4.setStatic(false);
        }

        if(horiRing4.contain(1233,465)){
            horiRing4.setImage(drawbarRing.getImage());
            flagUp = 200;
        }else if(horiRing4.contain(horiRing4.getX(),900)){
            flagDown = 100;
        }
        if(horiRing4.isDragged()){
            try {
                int fallingRing = horiRing4.getY() + 7;

                horiRing4.setY(fallingRing);
                Thread.sleep(2);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(flagDown == 100){
            horiRing4.setY(900);
            fails++;
            flagUp = -2;
            BackGroundMusic.failSound.play();
        }
        if(flagUp == 200){
            fallingRingFour();
        }

        if( flagUp == -2){
            horiRing2.setStatic(false);
        }
        if(horiRing2.contain(1233,465)){
            horiRing2.setImage(drawbarRing.getImage());
            flagUp = 400;
        }else if(horiRing2.contain(horiRing2.getX(),900)){
            flagDown = 300;
        }
        if(horiRing2.isDragged()){
            try {
                int fallingRing = horiRing2.getY() + 10;
                if(fallingRing == 900)
                    horiRing2.setDragged(false);
                else {
                    horiRing2.setY(fallingRing);
                    Thread.sleep(5);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(flagDown == 300){
            horiRing2.setY(900);
            flagUp = -4;
            fails++;
        }
        if(flagUp == 400){
            fallingRingTwo();
        }
        if(flagUp == -4){
            horiRing.setStatic(false);
        }
        if(horiRing.contain(1233,465)){
            horiRing.setImage(drawbarRing.getImage());
            flagUp = 600;
        }else if(horiRing.contain(horiRing.getX()+5,900)){
            flagDown = 500;
        }
        if(horiRing.isDragged()){
            try {
                int fallingRing = horiRing.getY() + 10;
                if(fallingRing == 900)
                    horiRing.setDragged(false);
                else {
                    horiRing.setY(fallingRing);
                    Thread.sleep(3);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(flagDown == 500){
            horiRing.setY(900);
            fails++;
            flagUp = -6;
        }
        if(flagUp == 600){
            fallingRingOne();
            flagUp = -6;
        }

        if(flagUp == -6){
            if(Score.successful_attempt == 3) {
                BackGroundMusic.winingSound.play();
                Intent myIntent = new Intent((Context)game,SecondActivity.class);
                myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                ((Context)game).getApplicationContext().startActivity(myIntent);
            }

        }
    }
    @Override
    public void backButton() {

    }
}
