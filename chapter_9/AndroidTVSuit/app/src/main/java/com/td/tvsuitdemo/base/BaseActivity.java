package com.td.tvsuitdemo.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.widget.Toast;
import com.td.tvsuitdemo.utils.Utils;

public class BaseActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_UP:
                Utils.setVolume(true, false);
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                Utils.setVolume(false, false);
                return true;
            case KeyEvent.KEYCODE_VOLUME_MUTE:
                Utils.setVolume(false, true);
                return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void showToast(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }
}
