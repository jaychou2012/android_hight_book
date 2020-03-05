package com.td.tvsuit.utils;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import com.td.tvsuit.config.Config;

public class Utils {
    public static int getScreenWidth(Context context) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.widthPixels;
    }

    public static int getScreenHeight(Context context) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.heightPixels;
    }

    public static int px2dp(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static int pxTodp(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale);
    }

    public static int dp2px(Context context, float dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dpVal, context.getResources().getDisplayMetrics());
    }

    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    public static int get16_9_height(int width) {
        int height = (int) ((width * 16.0) / 9.0);
        return height;
    }

    public static int get4_3_height(int width) {
        int height = (int) ((width * 4.0) / 3.0);
        return height;
    }

    public static int get16_9_width(int height) {
        int width = (int) ((height * 16.0) / 9.0);
        return width;
    }

    public static int get4_3_width(int height) {
        int width = (int) ((height * 4.0) / 3.0);
        return width;
    }

    public static void setFocusHighLight(final View view, final TimeInterpolator interpolator, boolean alpha) {
        view.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    if (interpolator != null) {
                        view.animate().setInterpolator(interpolator).scaleX(Config.scale).scaleY(Config.scale).setDuration(Config.duration).start();
                    } else {
                        view.animate().scaleX(Config.scale).scaleY(Config.scale).setDuration(Config.duration).start();
                    }
                } else {
                    view.animate().scaleX(1.0f).scaleY(1.0f).setDuration(Config.duration).start();
                }
            }
        });
    }

    public static void sendLocalMessage(Context context, String action) {
        LocalBroadcastManager.getInstance(context).sendBroadcast(
                new Intent(action)
        );
    }
}
