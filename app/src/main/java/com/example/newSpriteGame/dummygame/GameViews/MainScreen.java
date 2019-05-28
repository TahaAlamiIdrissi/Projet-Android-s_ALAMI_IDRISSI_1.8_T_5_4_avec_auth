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
import com.example.newSpriteGame.dummygame.assets.Icons;
import com.example.newSpriteGame.dummygame.assets.Menu;
import com.example.newSpriteGame.dummygame.assets.Ring;

public class MainScreen extends Screen {
    private final String TAG = "MainScreen: ";
    private static int flagUp= -1;
    private  static int flagDown = -1;
    private static int score = 0;
    private static int fails = 0;
    private static int failFlag = -1;
    private  static int backOne = 0;
    private Sprite bg;
    private Sprite home;
    private Sprite horiRing;
    private Sprite horiRing2;
    private Sprite horiRing3;
    private Sprite horiRing4;
    private Sprite horiRing5;
    private Sprite menu,back,play ;
    private Sprite fourRings;
    private Sprite twoRings;
    private Sprite threeRings;
    private Sprite drawbare;
    private Sprite winSprite;
    private Sprite drawbarRing;
    private Sprite cross_error;

    public MainScreen(Game game) {
        //This is gonna handle other stuff for you under the hood.We will see more of that next time.
        super(game);
        BackGroundMusic.bg_music.play();
        BackGroundMusic.bg_music.setLooping(true);
        horiRing = new Sprite(Ring.horizontalRing,198,790,90,250);
        horiRing2 = new Sprite(Ring.horizontalRing,198,730,90,250);
        horiRing4 = new Sprite(Ring.horizontalRing,198,670,90,250);
        horiRing5 = new Sprite(Ring.horizontalRing,game.getScreenHeight()/4,game.getScreenWidth()/4,90,250);
        fourRings = new Sprite(Ring.fourRings,game.getScreenHeight()/5,game.getScreenWidth()/4,195,250);
        twoRings = new Sprite(Ring.twoRings,game.getScreenHeight()/5,game.getScreenWidth()/4,250,200);
        threeRings = new Sprite(Ring.threeRings,game.getScreenHeight()/5,game.getScreenWidth()/4,250,200);
        back = new Back(Icons.back_img,115,63,250,200);
        menu = new Menu(Icons.menu_img,1600,63,250,200);
        cross_error = new Sprite(BackgroundImage.cross_error,805,120,400,400);
        drawbarRing = new Sprite(Ring.barRing,game.getScreenHeight()/4,game.getScreenWidth()/4,90,250);
        bg = new Sprite(BackgroundImage.bg_image,0,0,game.getGraphics().getHeight(),game.getGraphics().getWidth());
        winSprite = new Sprite(Icons.win_img,0,0,game.getGraphics().getHeight(),game.getGraphics().getWidth());
        home = new Sprite(BackgroundImage.home_image,0,0,game.getGraphics().getHeight(),game.getGraphics().getWidth());
        play = new Sprite(BackgroundImage.play_image,750,400,250,350);
        drawbare = new Sprite(Bar.drawbare,game.getScreenHeight(),game.getScreenWidth()/4,500,300);
        drawbare.setStatic(true);
        addSprite(home);
        Log.d(TAG, "Constructor Called");

    }

    @Override
    public void render(float deltaTime) {

        if(flagUp == 0){
            horiRing4.setStatic(false);
        }

        if(horiRing4.contain(1233,810)){
            BackGroundMusic.success_sound.play();
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
            horiRing4.setImage(cross_error.getImage());
        }
        if(flagUp == 200){
            fallingRingFour();
        }

        if( flagUp == -2){
            horiRing2.setStatic(false);
        }
        if(horiRing2.contain(1233,760)){
            BackGroundMusic.success_sound.play();
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
            horiRing2.setImage(cross_error.getImage());
        }
        if(flagUp == 400){
            fallingRingTwo();
        }
        if(flagUp == -4){
            horiRing.setStatic(false);
        }
        if(horiRing.contain(1233,680)){
            BackGroundMusic.success_sound.play();
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
            horiRing.setImage(cross_error.getImage());
        }
        if(flagUp == 600){
            fallingRingOne();
            flagUp = -6;
        }

        if(flagUp == -6){
            if(fails == 1){
                BackGroundMusic.success_sound.play();
            }else if(fails == 2){
                BackGroundMusic.winingSound.play();
            }else if (fails == 3){
                BackGroundMusic.bg_music.play();
            }else {
                if(score == 3) {
                    BackGroundMusic.winingSound.play();
                }
            }
        }

    }
    @Override
    public void handleTouchUp(int x, int y, int pointer) {
        if( flagUp == -1){
            BackGroundMusic.bg_music.stop();

            Intent myIntent = new Intent((Context)game,SecondActivity.class);
            myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            ((Context)game).getApplicationContext().startActivity(myIntent);
        }
    }


    private void winingSprite() {
            addSprite(winSprite);
            BackGroundMusic.winingSound.play();
    }
    public void addNewSprites(){
        addSprite(bg);
        addSprite(back);
        addSprite(menu);
        addSprite(drawbare);
        addSprite(horiRing);
        addSprite(horiRing2);
        addSprite(horiRing4);
        removeSprite(home);
    }
    public void fallingRingFour(){
        horiRing4.setImage(drawbarRing.getImage());
        horiRing4.setPosition(1233,847);
        horiRing4.setDragged(false);
        horiRing4.setStatic(true);
        BackGroundMusic.success_sound.stop();
        flagUp=-2;
        score++;
    }
    public void fallingRingTwo(){
        horiRing2.setImage(drawbarRing.getImage());
        horiRing2.setPosition(1233,760);
        horiRing2.setDragged(false);
        horiRing2.setStatic(true);
        BackGroundMusic.success_sound.stop();
        flagUp=-4;
        score++;
    }
    public void fallingRingOne(){
        horiRing.setImage(drawbarRing.getImage());
        horiRing.setPosition(1233,680);
        horiRing.setDragged(false);
        horiRing.setStatic(true);
        BackGroundMusic.success_sound.stop();
        score++;
    }

    @Override
    public void pause() {
        BackGroundMusic.bg_music.pause();
    }

    @Override
    public void resume() {
        BackGroundMusic.bg_music.play();
    }

    @Override
    public void dispose() {
        System.gc();
    }

    @Override
    public void backButton() {
        pause();
        removeSprite(bg);
//        removeSprite(back);
//        removeSprite(help);
//        removeSprite(menu);
        removeSprite(drawbare);
        removeSprite(horiRing);
        removeSprite(horiRing2);
        removeSprite(horiRing4);
        addSprite(home);
        flagDown = -1;
        flagUp = -1;
        backOne = 1;
    }

}
