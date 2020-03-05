package com.google.instrumenttest;

import android.content.Context;

public class ClassUnderTest {
    private Context context;

    public ClassUnderTest(Context context) {
        this.context = context;
    }

    public String getHelloWorldString() {
        return context.getString(R.string.hello_world);
    }
}
