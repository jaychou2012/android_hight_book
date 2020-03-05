package com.td.tvsuitdemo.ui;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.tbruyelle.rxpermissions.RxPermissions;
import com.td.tvsuitdemo.R;
import com.td.tvsuitdemo.base.BaseActivity;

import butterknife.ButterKnife;

public class WelActivity extends BaseActivity {
    private int time = 3;
    private RunTime runTime;
    private RxPermissions rxPermissions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wel);
        initPermissions();
    }

    private void initView() {
        ButterKnife.bind(this);
        runTime = new RunTime();
        handler.postDelayed(runTime, 1000);
    }

    private void initPermissions() {
        rxPermissions = new RxPermissions(this);
        rxPermissions.request(Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE).subscribe((Boolean aBoolean) -> {
            if (aBoolean) {
                initView();
            } else {
                showToast("请开启必要权限");
                initPermissions();
            }
        });
    }

    class RunTime implements Runnable {
        @Override
        public void run() {
            if (time >= 0) {
                handler.obtainMessage(0).sendToTarget();
                handler.postDelayed(this, 1000);
            } else {
                handler.obtainMessage(-1).sendToTarget();
            }
        }
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    time--;
                    break;
                case -1:
                    handler.removeCallbacks(runTime);
                    Intent intent = new Intent(WelActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                    break;
            }
        }
    };
}
