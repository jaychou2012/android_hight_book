package com.google.instrumenttest;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceUtils {
    private SharedPreferences sp;

    public SharedPreferenceUtils(SharedPreferences sp) {
        this.sp = sp;
    }

    public SharedPreferenceUtils(Context context) {
        this(context.getSharedPreferences("set", Context.MODE_PRIVATE));
    }

    public void put(String key, String value) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public String get(String key) {
        return sp.getString(key, null);
    }
}
