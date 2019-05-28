package com.example.newSpriteGame.dummygame.GameViews;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.emobadaragaminglib.Base.Game;
import com.example.emobadaragaminglib.Base.Screen;
import com.example.emobadaragaminglib.Components.Sprite;
import com.example.newSpriteGame.dummygame.SecondActivity;
import com.example.newSpriteGame.dummygame.assets.BackGroundMusic;
import com.example.newSpriteGame.dummygame.assets.BackgroundImage;
import com.example.newSpriteGame.dummygame.assets.Bar;
import com.example.newSpriteGame.dummygame.assets.Ring;

public class LevelTwoGameScreen extends Screen {
    private Sprite home;
    private static int flagUp= -1;
    private  static int flagDown = -1;
    private static int score = 0;
    private static int fails = 0;
    private Sprite horiRing;
    private Sprite horiRing2;
    private Sprite horiRing4;
    private Sprite drawbare;
    private Sprite drawbarRing;
    public LevelTwoGameScreen(Game game) {
        super(game);
        home = new Sprite(BackgroundImage.home_image,0,0,game.getGraphics().getHeight(),game.getGraphics().getWidth());
        horiRing = new Sprite(Ring.horizontalRing,198,790,90,250);
        horiRing2 = new Sprite(Ring.horizontalRing,198,730,90,250);
        horiRing4 = new Sprite(Ring.horizontalRing,198,670,90,250);
        drawbarRing = new Sprite(Ring.barRing,game.getScreenHeight()/4,game.getScreenWidth()/4,90,250);
        drawbare = new Sprite(Bar.drawbare,game.getScreenHeight(),game.getScreenWidth()/4,500,300);
        drawbare.setStatic(true);
        addSprite(home);
        addNewSprites();
    }

    @Override
    public void render(float deltaTime) {
        flagUp = 0;
        score = 0;
        if(flagUp == 0){
            horiRing4.setStatic(false);
        }

        if(horiRing4.contain(1233,810)){
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
        }
        if(flagUp == 200){
            fallingRingFour();
        }

        if( flagUp == -2){
            horiRing2.setStatic(false);
        }
        if(horiRing2.contain(1233,760)){
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
        if(horiRing.contain(1233,680)){
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
            if(score == 3) {
                BackGroundMusic.winingSound.play();
                Intent myIntent = new Intent((Context)game,SecondActivity.class);
                myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                ((Context)game).getApplicationContext().startActivity(myIntent);
            }

        }
    }

    @Override
    public void pause() {

    }

    @Override
    public void handleTouchUp(int x, int y, int pointer) {
        if( flagUp == -1){
            BackGroundMusic.bg_music.stop();
            flagUp = 0;
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
        horiRing4.setImage(drawbarRing.getImage());
        horiRing4.setPosition(1233,847);
        horiRing4.setDragged(false);
        horiRing4.setStatic(true);
        BackGroundMusic.success_sound.stop();
        flagUp=-2;
        score++;
        Log.d("SCOOOOOOOOOOREEEE"," ------------" +score);
    }
    public void fallingRingTwo(){
        horiRing2.setImage(drawbarRing.getImage());
        horiRing2.setPosition(1233,760);
        horiRing2.setDragged(false);
        horiRing2.setStatic(true);
        BackGroundMusic.success_sound.stop();
        flagUp=-4;
        score++;
        Log.d("SCOOOOOOOOOOREEEE"," ------------" +score);
    }
    public void fallingRingOne(){
        horiRing.setImage(drawbarRing.getImage());
        horiRing.setPosition(1233,680);
        horiRing.setDragged(false);
        horiRing.setStatic(true);
        BackGroundMusic.success_sound.stop();
        score++;
        Log.d("SCOOOOOOOOOOREEEE"," ------------" +score);
    }
    @Override
    public void backButton() {

    }
}
