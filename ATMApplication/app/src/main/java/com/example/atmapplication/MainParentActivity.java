package com.example.atmapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainParentActivity extends AppCompatActivity {

    TextView txtAmt;
    String amt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_parent);
        setTitle("Main Parent Activity");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.yellow)));
    }

    public void add(View view)
    {
        Intent intent=new Intent(MainParentActivity.this,AddTaskActivity.class);
        startActivity(intent);
    }

    public void quick(View view)
    {
        txtAmt=(TextView)findViewById(R.id.txtVwamt);
        amt=txtAmt.getText().toString();

        Intent intent=new Intent(MainParentActivity.this,QuickTransferActivity.class);
        intent.putExtra("bal",amt);
        startActivityForResult(intent, 1);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                String strEditText = data.getStringExtra("amount");
                txtAmt.setText(strEditText);
            }
        }
    }


    public void limit(View view)
    {
        Intent intent=new Intent(MainParentActivity.this,LimitActivity.class);
        startActivity(intent);
    }
}
