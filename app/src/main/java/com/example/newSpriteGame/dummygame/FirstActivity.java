package com.example.newSpriteGame.dummygame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ensias_auth_library.FoxyAuth;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        FoxyAuth.emerge(this,MainActivity2.class);
    }
}
