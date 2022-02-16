package com.example.atmapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class AddTaskActivity extends AppCompatActivity {

    CheckBox checkHw,checkClothes,checkPolish;
    String hw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        setTitle("Add Task Activity");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.yellow)));

        checkHw = (CheckBox) findViewById(R.id.chkHw);
        checkClothes = (CheckBox) findViewById(R.id.chkClothes);
        checkPolish = (CheckBox) findViewById(R.id.chkPolish);

        SharedPreferences sharedPreferences = getSharedPreferences("myKey", MODE_PRIVATE);
        SharedPreferences sharedPreferences1 = getSharedPreferences("myKey1", MODE_PRIVATE);
        SharedPreferences sharedPreferences2 = getSharedPreferences("myKey2", MODE_PRIVATE);

        String value = sharedPreferences.getString("value", "");
        String clothes = sharedPreferences1.getString("clothes", "");
        String polish = sharedPreferences2.getString("polish", "");

        if (value == "Ok") {
            checkHw.setChecked(true);
        }

        if (clothes == "OkClothes") {
            checkClothes.setChecked(true);
        }

        if (polish == "OkPolish") {
            checkPolish.setChecked(true); }
    }

    public void transfer(View view)
    {
        Intent intent=new Intent(AddTaskActivity.this,QuickTransferActivity.class);
        startActivity(intent);
    }

}
