package com.google.instrumenttest;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.widget.Toast;

public class WebActivity extends AppCompatActivity {
    private WebView webView;
    private CountDownTimer countDownTimer;
    private String webUrl = "https://www.baidu.com";
    private SimpleIdlingResource mIdlingResource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        initView();
    }

    private void initView() {
        webView = findViewById(R.id.wv);
        if (getIntent() != null) {
            if (mIdlingResource == null) {
                mIdlingResource = new SimpleIdlingResource();
            }
            if (getIntent().hasExtra("url")) {
                webUrl = getIntent().getStringExtra("url");
            }
            if (mIdlingResource != null) {
                mIdlingResource.setIdleState(false);
            }
        }
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.setBackgroundColor(ContextCompat.getColor(this, android.R.color.transparent));
        countDownTimer = new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                webView.loadUrl(webUrl);
                Toast.makeText(WebActivity.this, "webUrl" + mIdlingResource, Toast.LENGTH_SHORT).show();
                mIdlingResource.setIdleState(true);
            }
        };
        countDownTimer.start();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                if (webView.canGoBack()) {
                    webView.goBack();
                } else {
                    finish();
                }
                break;
            case KeyEvent.KEYCODE_MENU:
                webView.loadUrl(webUrl);
                break;
        }
        return true;
    }
}
