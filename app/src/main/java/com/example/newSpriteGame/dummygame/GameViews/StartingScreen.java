package com.example.newSpriteGame.dummygame.GameViews;

import android.content.Context;
import android.content.Intent;

import com.e_mobadara.audiomanaging.AudioSettingsActivity;
import com.example.emobadaragaminglib.Base.Game;
import com.example.emobadaragaminglib.Base.Screen;
import com.example.emobadaragaminglib.Components.Sprite;

import com.example.newSpriteGame.dummygame.LevelOneActivity;
import com.example.newSpriteGame.dummygame.MainActivity2;
import com.example.newSpriteGame.dummygame.MenuActivity;
import com.example.newSpriteGame.dummygame.assets.Back;
import com.example.newSpriteGame.dummygame.assets.BackGroundMusic;
import com.example.newSpriteGame.dummygame.assets.BackgroundImage;
import com.example.newSpriteGame.dummygame.assets.Icons;
import com.example.newSpriteGame.dummygame.assets.LevelOne;
import com.example.newSpriteGame.dummygame.assets.LevelThree;
import com.example.newSpriteGame.dummygame.assets.LevelTwo;
import com.example.newSpriteGame.dummygame.assets.Menu;
import com.example.newSpriteGame.dummygame.assets.NoSound;
import com.example.newSpriteGame.dummygame.assets.Setting;
import com.example.newSpriteGame.dummygame.assets.Sound;


public class StartingScreen extends Screen {
    private Sprite home;
    private Sound sound;
    private Sound no_sound;
    private int sound_on=0;
    private LevelOne level1;
    private LevelTwo level2;
    private LevelThree level3;
    private Back back;
    private Menu menu;
    private Setting setting;

    int X=game.getScreenWidth();
    int Y=game.getScreenHeight();

    public StartingScreen(Game game) {
        super(game);
        home = new Sprite(BackgroundImage.home_image,0,0,game.getGraphics().getHeight(),game.getGraphics().getWidth());
        level1 = new LevelOne(LevelOne.level1,(X/7),(int)(Y/3),(Y/4),(int)(X/4));
        level2 = new LevelTwo(LevelTwo.level2,(int)(X/2.5),(int)(Y/3),(Y/4),(int)(X/4));
        level3 = new LevelThree(LevelThree.level3,(int)(X/1.52),(int)(Y/3),(Y/4),(int)(X/4));
        sound = new Sound(Sound.sound_icon,(int)(X/1.2),(int)(Y/1.2),(Y/7),(int)(X/7));
        no_sound = new Sound(NoSound.no_sound,(int)(X/1.2),(int)(Y/1.2),(Y/7),(int)(X/7));
        back = new Back(Icons.back_img,0,0,(int)(Y/7.5),(int)(X/7.5));
        menu = new Menu(Icons.menu_img,(int)(X/1.2),0,(int)(Y/6),(int)(X/5.5));
        setting = new Setting(Icons.settings,0,(int)(Y/1.2),(int)(Y/7.5),(int)(X/7.5));
        addSprite(home);
        addSprite(level1);
        addSprite(level2);
        addSprite(level3);
        addSprite(back);
        addSprite(setting);
        addSprite(menu);
        addSprite(no_sound);
        addSprite(sound);
    }

    @Override
    public void handleTouchDown(int x, int y, int pointer) {
        super.handleTouchDown(x, y, pointer);
        Sprite s = getDraggedSprite();

        try {
            if(s!=null && s.getClass()==LevelOne.class){

                Intent myIntent = new Intent((Context)game,LevelOneActivity.class);
                myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                ((Context)game).getApplicationContext().startActivity(myIntent);

            }else if(s!=null && s.getClass()==LevelTwo.class){

                Intent myIntent = new Intent((Context)game,LevelOneActivity.class);
                myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                ((Context)game).getApplicationContext().startActivity(myIntent);

            }else if(s!=null && s.getClass()==LevelThree.class){

                Intent myIntent = new Intent((Context)game,LevelOneActivity.class);
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
            }else if(s!=null && s.getClass()==Back.class){

                Intent myIntent = new Intent((Context)game,MainActivity2.class);
                myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                ((Context)game).getApplicationContext().startActivity(myIntent);

            }else if(s!=null && s.getClass()==Menu.class){
                BackGroundMusic.bg_music.stop();
                Intent myIntent = new Intent((Context)game,MenuActivity.class);
                myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                ((Context)game).getApplicationContext().startActivity(myIntent);

            }else if(s!=null && s.getClass()==Setting.class){

                Intent myIntent = new Intent((Context)game,AudioSettingsActivity.class);
                myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                ((Context)game).getApplicationContext().startActivity(myIntent);

            }


        }catch (Exception e){
            e.printStackTrace();
        }
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
