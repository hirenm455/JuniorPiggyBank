package com.example.atmapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

public class MainChildActivity extends AppCompatActivity {

    MediaPlayer myMediaPlayer;
    TextView txtbal;
    int pbal,cbal,sum,total,totalsum;

    String amt,money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_child);
        setTitle("Main Child Activity");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.yellow)));


        amt=QuickTransferActivity.getAmt();
        pbal=Integer.valueOf(amt);



        txtbal=(TextView)findViewById(R.id.txtVwChildBalance);
        cbal=Integer.valueOf(txtbal.getText().toString());


        sum=pbal+cbal;

        txtbal.setText(Integer.toString(sum));

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


   /* @Override
    public void onBackPressed() {

        AlertDialog.Builder builder=new AlertDialog.Builder(MainChildActivity.this);
        builder.setTitle("Pop Up");
        builder.setMessage("Do you want to exit ?");
        builder.setPositiveButton("YES.EXIT NOW!!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                releaseMediaPlayer();
                finish();
            }
        });

        builder.setNegativeButton("NOT NOW", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setCancelable(false);
        builder.show();

    }

    private void releaseMediaPlayer() {
        if (myMediaPlayer!= null) {
            if(myMediaPlayer.isPlaying()) {
                myMediaPlayer.stop();
            }
            myMediaPlayer.release();
            myMediaPlayer= null;
        }
    }*/

   public void perform(View view)
   {
       Intent intent=new Intent(MainChildActivity.this,PerformTaskActivity.class);
       startActivity(intent);
   }

    public void deposit(View view)
    {
        Intent intent=new Intent(MainChildActivity.this,DepositActivity.class);
        startActivity(intent);
    }

   public void wishlist(View view)
   {
       Intent intent=new Intent(MainChildActivity.this,WishlistActivity.class);
       startActivity(intent);
   }

    //Music Pause
    @Override
    protected void onPause() {
        super.onPause();
        myMediaPlayer.release();
    }
}
