package com.td.tvsuitdemo.adapter;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.td.tvsuit.utils.adapter.BaseSmartAdapter;
import com.td.tvsuit.utils.adapter.SmarViewHolder;
import com.td.tvsuitdemo.R;
import com.td.tvsuitdemo.entity.CardItem;
import com.td.tvsuitdemo.utils.FocusIml;
import com.td.tvsuitdemo.utils.FocusStateIml;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by office on 2018/3/21.
 */

public class MenuAdapter extends BaseSmartAdapter<CardItem> {
    private Context context;
    private FrameLayout.LayoutParams layoutParams;
    private int width = 0, height = 0;
    private TimeInterpolator timeInterpolator;
    private TimeInterpolator linearInterpolator;
    private FocusIml focusIml;
    private FocusStateIml focusStateIml;
    private ArrayList<View> views = new ArrayList<>();
    private int focusPosition = 0;
    private int focusCount = 0;

    public MenuAdapter(Context context, int layoutId, List<CardItem> lists) {
        super(context, layoutId, lists);
        this.context = context;
        timeInterpolator = new OvershootInterpolator();
        linearInterpolator = new LinearInterpolator();
    }

    @Override
    public void bindData(final SmarViewHolder holder, CardItem cardItem) {
        views.add(holder.getItemView());
        ((TextView) holder.getView(R.id.tv_name)).setText(holder.getAdapterPosition() + "");
        holder.getView(R.id.fl_parent).setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    holder.getView(R.id.fl_parent).animate().scaleX(1.01f).scaleY(1.01f).setDuration(300).start();
                    ((TextView) holder.getView(R.id.tv_name)).setTextColor(context.getResources().getColor(R.color.white));
                } else {
                    holder.getView(R.id.fl_parent).animate().scaleX(1.0f).scaleY(1.0f).setDuration(300).start();
                    ((TextView) holder.getView(R.id.tv_name)).setTextColor(context.getResources().getColor(R.color.gray_light));
                }
                hasFocusView();
            }
        });
        holder.getView(R.id.fl_parent).setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_DPAD_UP) {
                    if (focusIml != null) {
                        if (holder.getAdapterPosition() == 0) {
                            focusIml.onKeyClick(KeyEvent.KEYCODE_DPAD_UP);
                        }
                    }
                }
                return false;
            }
        });
    }

    public void setFocusImlListener(FocusIml focusIml) {
        this.focusIml = focusIml;
    }

    public void setFocusStateIml(FocusStateIml focusStateIml) {
        this.focusStateIml = focusStateIml;
    }

    public void hasFocusView() {
        focusCount = 0;
        for (int i = 0; i < views.size(); i++) {
            if (views.get(i).hasFocus()) {
                focusPosition = i;
                focusCount++;
            }
        }
        if (focusStateIml != null) {
            focusStateIml.currentFocus(focusCount == 0 ? false : true, focusPosition, views.get(focusPosition));
        }
    }
}
