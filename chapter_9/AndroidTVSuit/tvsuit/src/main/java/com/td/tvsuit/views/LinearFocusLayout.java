package com.td.tvsuit.views;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LinearFocusLayout extends LinearLayout {
    private boolean canFocusOutHorizontal = false;
    private boolean inRecyclerView = false;
    private List<View> views;

    public LinearFocusLayout(Context context) {
        super(context);
        init();
    }

    public LinearFocusLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LinearFocusLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setOrientation(LinearLayout.HORIZONTAL);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setDescendantFocusability(FOCUS_AFTER_DESCENDANTS);
        views = new ArrayList<>();
//        for (int i = 0; i < getChildCount(); i++) {
//            views.add(getChildAt(i));
//        }
    }

    public void setViews(View view) {
        views.add(view);
    }

    @Override
    protected boolean onRequestFocusInDescendants(int direction, Rect previouslyFocusedRect) {
//        showToast("onRequestFocusInDescendants:" + direction + "   " + currentItem);
        return super.onRequestFocusInDescendants(direction, previouslyFocusedRect);
    }

    @Override
    public View focusSearch(View focused, int direction) {
        View view = super.focusSearch(focused, direction);
        if (focused == null) {
            return view;
        }
        if (view != null) {
            //该方法返回焦点view所在的父view,如果是在recyclerview之外，就会是null.所以根据是否是null,来判断是否是移出了recyclerview
            View nextFocusItemView = findContainingItemView(view);
            if (nextFocusItemView == null) {
                if (inRecyclerView) {
                    if (!canFocusOutHorizontal && direction == View.FOCUS_LEFT) {
                        Log.i("info", "屏蔽横向：1 " + views.indexOf(focused));
                        //屏蔽焦点横向移出recyclerview
                        if (views.indexOf(focused) == 0) {
                            return focused;
                        } else {
                            return view;
                        }
                    } else if (!canFocusOutHorizontal && direction == View.FOCUS_RIGHT) {
                        Log.i("info", "屏蔽横向：2 " + views.indexOf(focused) + "  " + views.size());
                        if (views.indexOf(focused) == views.size() - 1) {
                            Log.i("info", "屏蔽横向：3 " + views.indexOf(focused));
                            return focused;
                        } else {
                            Log.i("info", "屏蔽横向：4 " + views.indexOf(focused));
                            return views.get(views.indexOf(focused) + 1);
//                        return view;
                        }
                    }
                } else {
                    if (!canFocusOutHorizontal && (direction == View.FOCUS_LEFT || direction == View.FOCUS_RIGHT)) {
                        //屏蔽焦点横向移出recyclerview
                        return focused;
                    }
                    //调用移出的监听
                    return view;
                }
                //调用移出的监听
                return view;
            }
        }
        return view;
//        return super.focusSearch(focused, direction);
    }

    @Nullable
    public View findContainingItemView(@NonNull View view) {
        ViewParent parent;
        for (parent = view.getParent(); parent != null && parent != this && parent instanceof View; parent = view.getParent()) {
            view = (View) parent;
        }
        return parent == this ? view : null;
    }

    public void setCanHorizontalOut(boolean canHorizontalOut, boolean inRecyclerView) {
        this.canFocusOutHorizontal = canHorizontalOut;
        this.inRecyclerView = inRecyclerView;
    }

    public void showToast(String text) {
        Toast.makeText(getContext(), text, Toast.LENGTH_SHORT).show();
    }
}
