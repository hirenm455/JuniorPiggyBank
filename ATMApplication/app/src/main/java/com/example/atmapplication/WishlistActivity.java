package com.example.atmapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class WishlistActivity extends AppCompatActivity {

    MediaPlayer myMediaPlayer;
    TextView txtshoes,txtwatch,txtcar,txtshoesAmt,txtwatchAmt,txtcarAmt;
    CheckBox checkBoxShoes,checkBoxWatch,checkBoxCar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishlist);

        setTitle("WishList Activity");
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


        txtshoes=(TextView)findViewById(R.id.txtVwShoes);
        txtwatch=(TextView)findViewById(R.id.txtVwWatch);
        txtcar=(TextView)findViewById(R.id.txtVwCar);

        txtshoesAmt=(TextView)findViewById(R.id.txtVwShoesAmt);
        txtwatchAmt=(TextView)findViewById(R.id.txtVwWatchAmt);
        txtcarAmt=(TextView)findViewById(R.id.txtVwCarAmt);

        checkBoxShoes=(CheckBox)findViewById(R.id.chkShoes);
        checkBoxWatch=(CheckBox)findViewById(R.id.chkWatch);
        checkBoxCar=(CheckBox)findViewById(R.id.chkCar);

    }

    public void withdraw(View view)
    {

        if(checkBoxShoes.isChecked() && checkBoxWatch.isChecked() && checkBoxCar.isChecked())
        {
            String shoes=txtshoes.getText().toString();
            String shoesAmt=txtshoesAmt.getText().toString();

            String watch=txtwatch.getText().toString();
            String watchAmt=txtwatchAmt.getText().toString();

            String car=txtcar.getText().toString();
            String carAmt=txtcarAmt.getText().toString();

            Intent intent=new Intent(WishlistActivity.this,WithdrawActivity.class);
            intent.putExtra("Shoes",shoes);
            intent.putExtra("Samt",shoesAmt);
            intent.putExtra("Watch",watch);
            intent.putExtra("Wamt",watchAmt);
            intent.putExtra("Car",car);
            intent.putExtra("Camt",carAmt);
            startActivity(intent);
        }

        else if(checkBoxShoes.isChecked() && checkBoxCar.isChecked())
        {
            String shoes=txtshoes.getText().toString();
            String shoesAmt=txtshoesAmt.getText().toString();

            String car=txtcar.getText().toString();
            String carAmt=txtcarAmt.getText().toString();

            Intent intent=new Intent(WishlistActivity.this,WithdrawActivity.class);
            intent.putExtra("Shoes",shoes);
            intent.putExtra("Samt",shoesAmt);
            intent.putExtra("Car",car);
            intent.putExtra("Camt",carAmt);
            startActivity(intent);
        }


        else if(checkBoxShoes.isChecked() && checkBoxWatch.isChecked())
        {
            String shoes=txtshoes.getText().toString();
            String shoesAmt=txtshoesAmt.getText().toString();

            String watch=txtwatch.getText().toString();
            String watchAmt=txtwatchAmt.getText().toString();

            Intent intent=new Intent(WishlistActivity.this,WithdrawActivity.class);
            intent.putExtra("Shoes",shoes);
            intent.putExtra("Samt",shoesAmt);
            intent.putExtra("Watch",watch);
            intent.putExtra("Wamt",watchAmt);
            startActivity(intent);
        }

        else if(checkBoxWatch.isChecked() && checkBoxCar.isChecked())
        {
            String watch=txtwatch.getText().toString();
            String watchAmt=txtwatchAmt.getText().toString();


            String car=txtcar.getText().toString();
            String carAmt=txtcarAmt.getText().toString();

            Intent intent=new Intent(WishlistActivity.this,WithdrawActivity.class);
            intent.putExtra("Watch",watch);
            intent.putExtra("Wamt",watchAmt);
            intent.putExtra("Car",car);
            intent.putExtra("Camt",carAmt);
            startActivity(intent);
        }

        else if(checkBoxShoes.isChecked())
        {
            String shoes=txtshoes.getText().toString();
            String shoesAmt=txtshoesAmt.getText().toString();

            Intent intent=new Intent(WishlistActivity.this,WithdrawActivity.class);
            intent.putExtra("Shoes",shoes);
            intent.putExtra("Samt",shoesAmt);
            startActivity(intent);
        }

        else if(checkBoxWatch.isChecked())
        {
            String watch=txtwatch.getText().toString();
            String watchAmt=txtwatchAmt.getText().toString();

            Intent intent=new Intent(WishlistActivity.this,WithdrawActivity.class);
            intent.putExtra("Watch",watch);
            intent.putExtra("Wamt",watchAmt);
            startActivity(intent);
        }

        else if(checkBoxCar.isChecked())
        {
            String car=txtcar.getText().toString();
            String carAmt=txtcarAmt.getText().toString();

            Intent intent=new Intent(WishlistActivity.this,WithdrawActivity.class);
            intent.putExtra("Car",car);
            intent.putExtra("Camt",carAmt);
            startActivity(intent);
        }

        else
        {
            Toast.makeText(getApplicationContext(),"Please select atleast one checkbox",Toast.LENGTH_LONG).show();
        }

    }

    //Music Pause
    @Override
    protected void onPause() {
        super.onPause();
        myMediaPlayer.release();
    }
}
