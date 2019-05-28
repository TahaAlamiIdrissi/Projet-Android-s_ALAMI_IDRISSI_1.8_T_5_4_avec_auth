package com.example.newSpriteGame.dummygame.GameViews;

import android.content.Context;
import android.content.Intent;

import com.example.emobadaragaminglib.Base.Game;
import com.example.emobadaragaminglib.Base.Screen;
import com.example.emobadaragaminglib.Components.Sprite;
import com.example.newSpriteGame.dummygame.SecondActivity;
import com.example.newSpriteGame.dummygame.assets.Back;
import com.example.newSpriteGame.dummygame.assets.BackGroundMusic;
import com.example.newSpriteGame.dummygame.assets.BackgroundImage;
import com.example.newSpriteGame.dummygame.assets.Icons;

public class MenuScreen extends Screen {
    private Sprite help;
    private Sprite home;
    private Sprite table;
    private Sprite desc;
    private Back back;

    int X = game.getGraphics().getHeight();
    int Y = game.getGraphics().getWidth();
    public MenuScreen(Game game) {
        super(game);

        home = new Sprite(BackgroundImage.home_image,0,0,(game.getGraphics().getHeight()),(game.getGraphics().getWidth()));
        table = new Sprite(Icons.table_img,0,0,(game.getGraphics().getHeight()),(game.getGraphics().getWidth()));
        desc = new Sprite(Icons.desc_img,430,320,X/2,Y/2);
        back = new Back(Icons.back_img,1600,750,(int)(Y/7.5),(int)(X/7.5));
        BackGroundMusic.helpSound.play();
        BackGroundMusic.helpSound.setLooping(true);
        addSprite(home);
        addSprite(table);
        addSprite(desc);
        addSprite(back);
    }

    @Override
    public void render(float deltaTime) {

    }

    @Override
    public void handleTouchUp(int x, int y, int pointer) {
        super.handleTouchDown(x, y, pointer);
        Sprite s = getDraggedSprite();

        if(s!=null && s.getClass()==Back.class){

            Intent myIntent = new Intent((Context)game,SecondActivity.class);
            myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            ((Context)game).getApplicationContext().startActivity(myIntent);
            BackGroundMusic.helpSound.stop();
        }
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
