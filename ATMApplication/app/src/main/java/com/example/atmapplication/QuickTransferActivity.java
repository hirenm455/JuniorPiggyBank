package com.example.atmapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class QuickTransferActivity extends AppCompatActivity {

    EditText edtTxtTransferAmt,edtId;
    private static String id, amt;
    String balance,bal;
    int bal1,total;
    int sum=0;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_transfer);

        setTitle("Quick Transfer Activity");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.yellow)));

        edtId=(EditText)findViewById(R.id.edtTxtId);

        edtTxtTransferAmt=(EditText)findViewById(R.id.edtTextAmt);

        id=edtId.getText().toString();
        amt=edtTxtTransferAmt.getText().toString();
    }

    public static String getId()
    {
        return id;
    }

    public static String getAmt()
    {
        return amt;
    }

    public void send(View view)
    {
        edtId=(EditText)findViewById(R.id.edtTxtId);

        edtTxtTransferAmt=(EditText)findViewById(R.id.edtTextAmt);

        if(!edtId.getText().toString().isEmpty())
        {
            if((edtId.getText().toString()).equals("1"))
            {
                if(!edtTxtTransferAmt.getText().toString().isEmpty())
                {
                    id=edtId.getText().toString();
                    amt=edtTxtTransferAmt.getText().toString();



                    bal1=Integer.valueOf(amt);

                    intent=getIntent();
                    bal=intent.getStringExtra("bal");
                    total=Integer.valueOf(bal);

                    if(bal1<total) {

                        sum=total-bal1;
                        balance=Integer.toString(sum);
                        intent = new Intent();
                        intent.putExtra("amount", balance);
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Not enough balance",Toast.LENGTH_LONG).show();
                    }

                    }
                    else
                    {
                        edtTxtTransferAmt.setError("Amount cannot be empty");
                    }
                }
                else
                {
                    edtId.setError("Invalid Id");
                }
        }
        else
        {
            edtId.setError("Id cannot be empty");
        }

    }
}

