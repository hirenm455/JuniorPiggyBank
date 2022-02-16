package com.example.atmapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;

public class DepositActivity extends AppCompatActivity {

    MediaPlayer myMediaPlayer;

    TextView txtId,txtAmt;

    String id,amt;
    private static String amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit);

        setTitle("Deposit Activity");
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


        txtId=(TextView)findViewById(R.id.txtVwChildId);
        txtAmt=(TextView)findViewById(R.id.txtVwChildAmt);

        id=QuickTransferActivity.getId();
        amt=QuickTransferActivity.getAmt();

        txtId.setText(id);
        txtAmt.setText(amt);

    }


    public void deposit(View view)
    {
        Intent intent=new Intent(DepositActivity.this,MainChildActivity.class);
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
