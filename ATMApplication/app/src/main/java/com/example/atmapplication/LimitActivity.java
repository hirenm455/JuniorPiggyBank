package com.example.atmapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

public class LimitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_limit);

        setTitle("Limit Activity");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.yellow)));
    }

    public void ok(View view)
    {
        Intent intent=new Intent(LimitActivity.this,MainParentActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
