package com.example.atmapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class WithdrawActivity extends AppCompatActivity {

    MediaPlayer myMediaPlayer;
    TextView t1,t2,t11,t12,t21,t22;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdraw);

        setTitle("Withdraw Activity");
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


        Intent intent=getIntent();
        String shoes=intent.getStringExtra("Shoes");
        String shoesAmt=intent.getStringExtra("Samt");

        String watch=intent.getStringExtra("Watch");
        String watchAmt=intent.getStringExtra("Wamt");

        String car=intent.getStringExtra("Car");
        String carAmt=intent.getStringExtra("Camt");

        t1=(TextView)findViewById(R.id.txtVw1);
        t2=(TextView)findViewById(R.id.txtVw2);

        t11=(TextView)findViewById(R.id.txtVw11);
        t12=(TextView)findViewById(R.id.txtVw12);

        t21=(TextView)findViewById(R.id.txtVw21);
        t22=(TextView)findViewById(R.id.txtVw22);

        t1.setText(shoes);
        t2.setText(shoesAmt);

        t11.setText(watch);
        t12.setText(watchAmt);

        t21.setText(car);
        t22.setText(carAmt);

    }

    public void buy(View view)
    {
        Toast.makeText(getApplicationContext(),"Items Purchased",Toast.LENGTH_LONG).show();
        Intent intent=new Intent(WithdrawActivity.this,MainChildActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    //Music Pause
    @Override
    protected void onPause() {
        super.onPause();
        myMediaPlayer.release();
    }
}
