package com.example.atmapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.io.IOException;

public class SplashActivity extends AppCompatActivity {

    private static TextView jr,piggy,bank;
    private static Animation animLeftToRight,animRightToLeft,animSlideUp;
    MediaPlayer myMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setTitle("Splash Activity");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.yellow)));

        jr=(TextView)findViewById(R.id.txtVwJunior);
        piggy=(TextView)findViewById(R.id.txtVwPiggy);
        bank=(TextView)findViewById(R.id.txtVwBank);

        animLeftToRight= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.left_to_right);
        jr.startAnimation(animLeftToRight);

        animRightToLeft= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.right_to_left);
        piggy.startAnimation(animRightToLeft);

        animSlideUp= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.left_to_right);
        bank.startAnimation(animSlideUp);

        Handler handler=new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

            Intent intent=new Intent(SplashActivity.this,SelectActivity.class);;
                    startActivity(intent);
                    finish();
            }
        },3150);

    }

}
