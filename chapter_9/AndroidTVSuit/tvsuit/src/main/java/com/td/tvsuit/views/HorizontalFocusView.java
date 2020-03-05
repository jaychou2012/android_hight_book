package com.td.tvsuit.views;

import android.content.Context;
import android.graphics.Rect;
import android.support.v17.leanback.widget.HorizontalGridView;
import android.util.AttributeSet;
import android.view.View;

public class HorizontalFocusView extends HorizontalGridView {

    public HorizontalFocusView(Context context) {
        super(context);
        init();
    }

    public HorizontalFocusView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HorizontalFocusView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {

    }

    @Override
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
    }

    @Override
    public boolean onRequestFocusInDescendants(int direction, Rect previouslyFocusedRect) {
        return super.onRequestFocusInDescendants(direction, previouslyFocusedRect);
    }

    @Override
    public View focusSearch(View focused, int direction) {
        return super.focusSearch(focused, direction);
    }

//    @Override
//    public boolean dispatchKeyEvent(KeyEvent event) {
//        if (event.getAction() == KeyEvent.ACTION_DOWN && (event.getKeyCode() == KeyEvent.KEYCODE_DPAD_LEFT || event.getKeyCode() == KeyEvent.KEYCODE_DPAD_RIGHT) && event.getRepeatCount() > 0) {
//            return true;
//        }
//        return super.dispatchKeyEvent(event);
//    }
}
