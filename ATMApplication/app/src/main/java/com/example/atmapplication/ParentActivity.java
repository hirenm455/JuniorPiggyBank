package com.example.atmapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Toast;

import com.hanks.passcodeview.PasscodeView;

public class ParentActivity extends AppCompatActivity {

    PasscodeView passcodeView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent);
        setTitle("Parent Activity");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.yellow)));

        passcodeView=(PasscodeView)findViewById(R.id.passcode_view);
        passcodeView.setPasscodeLength(4)
                .setLocalPasscode("1234")
                .setListener(new PasscodeView.PasscodeViewListener() {
                    @Override
                    public void onFail() {
                        Toast.makeText(getApplicationContext(),"Password is Wrong",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onSuccess(String number) {
                        Intent intent=new Intent(ParentActivity.this,MainParentActivity.class);
                        startActivity(intent);
                    }
                });
    }
}
