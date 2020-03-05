package com.google.instrumenttest;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.VisibleForTesting;
import android.support.test.espresso.IdlingResource;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EspActivity extends AppCompatActivity {
    private EditText et_text;
    private Button btn;
    private SimpleIdlingResource mIdlingResource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esp);
        et_text = findViewById(R.id.et_text);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EspActivity.this, "espresso", Toast.LENGTH_SHORT).show();
                mIdlingResource.setIdleState(false);
                delay();
            }
        });
    }

    private void delay() {
        CountDownTimer countDownTimer = new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                mIdlingResource.setIdleState(true);
                Intent intent = new Intent(EspActivity.this, WebActivity.class);
                intent.putExtra("url", et_text.getText().toString());
                startActivity(intent);
            }
        }.start();
    }

    @VisibleForTesting
    public IdlingResource getIdlingResource() {
        if (mIdlingResource == null) {
            mIdlingResource = new SimpleIdlingResource();
        }
        return mIdlingResource;
    }
}
