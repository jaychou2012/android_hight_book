package com.td.tvsuit.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class SlideViewPager extends NoScrollViewPager {
    private boolean isSlide = false;

    public SlideViewPager(Context context) {
        super(context);
    }

    public SlideViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setSlide(boolean slide) {
        this.isSlide = slide;
    }

    @Override
    public void scrollTo(int x, int y) {
        super.scrollTo(x, y);
    }

    @Override
    public boolean onTouchEvent(MotionEvent arg0) {
        /* return false;//super.onTouchEvent(arg0); */
        switch (arg0.getAction()) {
        }
        return !isSlide && super.onTouchEvent(arg0);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        return !isSlide && super.onInterceptTouchEvent(arg0);
    }

    @Override
    public void setCurrentItem(int item, boolean smoothScroll) {
        super.setCurrentItem(item, smoothScroll);
    }

    public void setPageScroll(boolean canScroll) {
        super.setPageScroll(canScroll);
    }

    @Override
    public void setCurrentItem(int item) {
        //false 去除滚动效果
        super.setCurrentItem(item, false);
    }
}