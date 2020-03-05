package com.td.tvsuit.views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.td.tvsuit.R;
import com.td.tvsuit.utils.Utils;

import java.util.ArrayList;

public class IndicatorView extends LinearLayout {
    private int size = 0;
    private int defaultSelect = 0;
    private ArrayList<ImageView> views;
    private boolean init = false;
    private LayoutParams layoutParams;

    public IndicatorView(Context context) {
        super(context);
        init();
    }

    public IndicatorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public IndicatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setOrientation(HORIZONTAL);
        setGravity(Gravity.CENTER);
        views = new ArrayList<>();
        layoutParams = new LayoutParams(Utils.dp2px(getContext(), 30), Utils.dp2px(getContext(), 30));
    }

    public void setNumber(int size) {
        this.size = size;
    }

    public void initLayout() {
        if (init) {
            return;
        }
        views.clear();
        removeAllViews();
        for (int i = 0; i < size; i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setPadding(Utils.dp2px(getContext(), 10), Utils.dp2px(getContext(), 5), Utils.dp2px(getContext(), 10), 0);
            if (i == defaultSelect) {
                imageView.setImageResource(R.drawable.bg_dot_blue);
            } else {
                imageView.setImageResource(R.drawable.bg_dot_gray);
            }
            imageView.setLayoutParams(layoutParams);
            views.add(imageView);
            addView(imageView);
        }
        init = true;
    }

    public void setDefaultSelect(int defaultSelect) {
        this.defaultSelect = defaultSelect;
    }

    public void setSelect(int select) {
        for (int i = 0; i < size; i++) {
            ImageView imageView = views.get(i);
            if (i == select) {
                imageView.setImageResource(R.drawable.bg_dot_blue);
            } else {
                imageView.setImageResource(R.drawable.bg_dot_gray);
            }
        }
    }
}
