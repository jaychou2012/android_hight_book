package com.td.tvsuitdemo.utils;

import android.view.View;

public interface FocusIml {
    void getFocusState(boolean hasFocus, int position, View itemView);

    void onKeyClick(int directionCode);

}
