package com.example.atmapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class PerformTaskActivity extends AppCompatActivity {

    MediaPlayer myMediaPlayer;

    Button btnShoes;

    //,sharedPref1,sharedPref2;

    //,editor1,editor2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perform_task);

        setTitle("Perform Task Activity");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.yellow)));


        myMediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.buddy);
        if (myMediaPlayer != null) {
            myMediaPlayer.start();
        } else {
            myMediaPlayer.reset();
            try {
                myMediaPlayer.prepare();
            } catch (IllegalStateException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            myMediaPlayer.start();
        }
    }


    public void hw(View view)
    {
        Toast.makeText(getApplicationContext(),"Task Submited",Toast.LENGTH_LONG).show();
        SharedPreferences sharedPref = getSharedPreferences("myKey", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("value", "Ok");
        editor.apply();
    }


    public void clothes(View view)
    {
        Toast.makeText(getApplicationContext(),"Task Submited",Toast.LENGTH_LONG).show();
        SharedPreferences sharedPref1 = getSharedPreferences("myKey1", MODE_PRIVATE);
        SharedPreferences.Editor editor1 = sharedPref1.edit();
        editor1.putString("clothes", "OkClothes");
        editor1.apply();
    }


    public void polish(View view)
    {
        Toast.makeText(getApplicationContext(),"Task Submited",Toast.LENGTH_LONG).show();
        SharedPreferences sharedPref2 = getSharedPreferences("myKey2", MODE_PRIVATE);
        SharedPreferences.Editor editor2 = sharedPref2.edit();
        editor2.putString("polish", "OkPolish");
        editor2.apply();
    }

    //Music Pause
    @Override
    protected void onPause() {
        super.onPause();
        myMediaPlayer.release();
    }
}
