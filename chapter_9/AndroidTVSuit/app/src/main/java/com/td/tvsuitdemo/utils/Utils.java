package com.td.tvsuitdemo.utils;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.support.v4.content.LocalBroadcastManager;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Toast;

import com.td.tvsuitdemo.R;
import com.td.tvsuitdemo.base.BaseApplication;
import com.td.tvsuitdemo.base.Config;
import com.td.tvsuitdemo.entity.CardItem;
import com.td.tvsuitdemo.ui.PlayActivity;

import java.util.Timer;
import java.util.TimerTask;

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

    public static void setFocusHighLight(final View view, boolean alpha) {
        view.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    if (Config.interpolator != null) {
                        view.animate().setInterpolator(Config.interpolator).scaleX(Config.CARD_SCALE).scaleY(Config.CARD_SCALE).setDuration(Config.SCALE_DURATION).start();
                    } else {
                        view.animate().scaleX(Config.CARD_SCALE).scaleY(Config.CARD_SCALE).setDuration(Config.SCALE_DURATION).start();
                    }
                } else {
                    view.animate().scaleX(1.0f).scaleY(1.0f).setDuration(Config.SCALE_DURATION).start();
                }
            }
        });
    }

//    public static void setFocusHighLight(View view, TimeInterpolator interpolator, boolean alpha, float scale) {
//        view.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                if (hasFocus) {
//                    if (interpolator != null) {
//                        view.animate().setInterpolator(interpolator).scaleX(scale).scaleY(scale).setDuration(Config.duration).start();
//                    } else {
//                        view.animate().scaleX(Config.scale).scaleY(Config.scale).setDuration(Config.duration).start();
//                    }
//                    if (alpha) {
//                        view.findViewById(R.id.v_alpha).setVisibility(View.GONE);
//                    }
//                } else {
//                    view.animate().scaleX(1.0f).scaleY(1.0f).setDuration(Config.duration).start();
//                    if (alpha) {
//                        view.findViewById(R.id.v_alpha).setVisibility(View.VISIBLE);
//                    }
//                }
//            }
//        });
//    }

    public static void setFocusHighLight(View view, int alphaResId, float scale) {
        view.setOnFocusChangeListener((View v, boolean hasFocus) -> {
            if (hasFocus) {
                if (Config.interpolator != null) {
                    view.animate().setInterpolator(Config.interpolator).scaleX(scale).scaleY(scale).setDuration(Config.SCALE_DURATION).start();
                } else {
                    view.animate().scaleX(Config.CARD_SCALE).scaleY(Config.CARD_SCALE).setDuration(Config.SCALE_DURATION).start();
                }
                if (alphaResId != -1) {
                    view.findViewById(alphaResId).setVisibility(View.GONE);
                }
            } else {
                view.animate().scaleX(1.0f).scaleY(1.0f).setDuration(Config.SCALE_DURATION).start();
                if (alphaResId != -1) {
                    view.findViewById(alphaResId).setVisibility(View.VISIBLE);
                }
            }
        });
    }

    public static void sendLocalMessage(Context context, String action) {
        LocalBroadcastManager.getInstance(context).sendBroadcast(
                new Intent(action)
        );
    }

    public static void setPageDestiNation(Context context, CardItem cardItem) {
        switch (cardItem.getType()) {
            case 0: {
                Intent intent = new Intent(context, PlayActivity.class);
                context.startActivity(intent);
            }
            break;
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            default: {
                Intent intent = new Intent(context, PlayActivity.class);
                context.startActivity(intent);
            }
            break;
        }
    }

    public static void getViewLayout(View view, ViewLayoutIml iml) {
        if (view == null) {
            return;
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (iml != null) {
                    iml.getWidthHeight(view.getWidth(), view.getHeight());
                }
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }

    public static void setVolume(boolean add, boolean mute) {
        AudioManager audioManager = (AudioManager) BaseApplication.getContext().getSystemService(Context.AUDIO_SERVICE);
        int max = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int current = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        if (add) {
            if (current >= max) {
                return;
            }
            current++;
            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, current, 0);
        } else {
            if (current <= 0) {
                return;
            }
            current--;
            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, current, 0);
        }
        if (mute) {
            audioManager.setStreamMute(AudioManager.STREAM_MUSIC, mute);
        }
        showVolumeToast(BaseApplication.getContext(), current, max, mute);
    }

    private static LinearLayout.LayoutParams layoutParams;
    private static long currentTime = 0;
    private static boolean isShow = false;
    private static Toast toast;

    public static void showVolumeToast(Context context, int volume, int max, boolean mute) {
        currentTime = System.currentTimeMillis();
        if (!isShow) {
            toast = new Toast(context);
            toast.setView(View.inflate(context, R.layout.layout_volumn_toast, null));
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP, 0, 50);
            SeekBar seekBar = (SeekBar) toast.getView().findViewById(R.id.seekBar);
            ImageView iv_volume = (ImageView) toast.getView().findViewById(R.id.iv_img);
            layoutParams = new LinearLayout.LayoutParams((Utils.getScreenWidth(context) / 4), LinearLayout.LayoutParams.WRAP_CONTENT);
            seekBar.setLayoutParams(layoutParams);
            seekBar.setMax(max);
            if (!mute) {
                seekBar.setProgress(volume);
                iv_volume.setImageResource(R.mipmap.ic_launcher);
            } else {
                seekBar.setProgress(0);
                iv_volume.setImageResource(R.mipmap.ic_launcher);
            }
            final Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    toast.show();
                    isShow = true;
                    if (System.currentTimeMillis() - currentTime > 2 * 1000) {
                        toast.cancel();
                        timer.cancel();
                        isShow = false;
                    }
                }
            }, 0, 3000);
        } else {
            SeekBar seekBar = (SeekBar) toast.getView().findViewById(R.id.seekBar);
            ImageView iv_volume = (ImageView) toast.getView().findViewById(R.id.iv_img);
            layoutParams = new LinearLayout.LayoutParams((Utils.getScreenWidth(context) / 4), LinearLayout.LayoutParams.WRAP_CONTENT);
            seekBar.setLayoutParams(layoutParams);
            seekBar.setMax(max);
            if (!mute) {
                seekBar.setProgress(volume);
                iv_volume.setImageResource(R.mipmap.ic_launcher);
            } else {
                seekBar.setProgress(0);
                iv_volume.setImageResource(R.mipmap.ic_launcher);
            }
        }
    }

    public static float getCurrentSystemVolume(Context context) {
        AudioManager audioManager = (AudioManager) BaseApplication.getContext().getSystemService(Context.AUDIO_SERVICE);
        int max = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int current = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        return ((float) current / (float) max);
    }

    public static void setStreamMute(boolean mute) {
        AudioManager audioManager = (AudioManager) BaseApplication.getContext().getSystemService(Context.AUDIO_SERVICE);
        if (audioManager != null) {
            audioManager.setStreamMute(AudioManager.STREAM_MUSIC, mute);
        }
    }

    public static void setStreamVolume(int volume) {
        AudioManager audioManager = (AudioManager) BaseApplication.getContext().getSystemService(Context.AUDIO_SERVICE);
        if (audioManager != null) {
            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, volume, AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE);
        }
    }
}
