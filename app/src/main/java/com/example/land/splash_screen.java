package com.example.land;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class splash_screen extends AppCompatActivity {
    TextView wel,land;
    private static int splash_timeout=5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        wel = findViewById(R.id.welcome);
        land = findViewById(R.id.landholders);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(splash_screen.this,screen1.class);
                 startActivity(intent);
                 finish();
            }
        },splash_timeout);

        Animation myanimation = AnimationUtils.loadAnimation(splash_screen.this,R.anim.animation1);
        wel.startAnimation(myanimation);

        Animation myanimation2 = AnimationUtils.loadAnimation(splash_screen.this,R.anim.animation2);
        land.startAnimation(myanimation2);
    }
}