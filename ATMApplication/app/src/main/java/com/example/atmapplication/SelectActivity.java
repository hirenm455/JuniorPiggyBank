package com.example.atmapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class SelectActivity extends AppCompatActivity {

    Button parent,child;
    ImageView scooter;
    Animation animScooter,animParent,animChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        setTitle("Select Activity");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.yellow)));

        parent=(Button)findViewById(R.id.btnParent);
        child=(Button)findViewById(R.id.btnChild);
        scooter=(ImageView)findViewById(R.id.imgVwScooter);

        animParent= AnimationUtils.loadAnimation(this,R.anim.slide_right);
        parent.setAnimation(animParent);

        animChild= AnimationUtils.loadAnimation(this,R.anim.slide_right);
        child.setAnimation(animChild);

        animScooter= AnimationUtils.loadAnimation(this,R.anim.slide_right);
        scooter.setAnimation(animScooter);
    }

    public void parent(View view)
    {
        Intent intent=new Intent(SelectActivity.this, ParentActivity.class);
        startActivity(intent);
    }


    public void child(View view)
    {
        Intent intent=new Intent(SelectActivity.this,ChildActivity.class);
        startActivity(intent);
    }
}
