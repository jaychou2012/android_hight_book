package com.td.tvsuitdemo.adapter;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.view.View;
import android.view.animation.OvershootInterpolator;

import com.td.tvsuit.utils.adapter.BaseSmartAdapter;
import com.td.tvsuit.utils.adapter.SmarViewHolder;
import com.td.tvsuit.views.ScrollTextView;
import com.td.tvsuitdemo.R;
import com.td.tvsuitdemo.base.Config;
import com.td.tvsuitdemo.entity.CardItem;

import java.util.List;

/**
 * Created by office on 2018/3/21.
 */

public class ListAdapter extends BaseSmartAdapter<CardItem> {
    private Context context;
    private TimeInterpolator timeInterpolator;
    private int select = 0;

    public ListAdapter(Context context, int layoutId, List<CardItem> lists) {
        super(context, layoutId, lists);
        this.context = context;
        timeInterpolator = new OvershootInterpolator();
    }

    @Override
    public void bindData(SmarViewHolder holder, CardItem cardItem) {
        ((ScrollTextView) holder.getView(R.id.tv_text)).setText(holder.getAdapterPosition() + "");
        holder.itemView.setOnFocusChangeListener((View v, boolean hasFocus) -> {
            if (hasFocus) {
                select = holder.getAdapterPosition();
                if (timeInterpolator != null) {
                    holder.itemView.animate().setInterpolator(timeInterpolator).
                            scaleX(Config.CARD_SCALE).scaleY(Config.CARD_SCALE).
                            setDuration(Config.SCALE_DURATION).start();
                } else {
                    holder.itemView.animate().scaleX(Config.CARD_SCALE).scaleY(Config.CARD_SCALE).
                            setDuration(Config.SCALE_DURATION).start();
                }
                holder.itemView.findViewById(R.id.v_alpha).setVisibility(View.GONE);
                ((ScrollTextView) holder.itemView.findViewById(R.id.tv_text)).startScroll();
            } else {
                holder.itemView.animate().scaleX(1.0f).scaleY(1.0f).setDuration(Config.SCALE_DURATION).start();
                holder.itemView.findViewById(R.id.v_alpha).setVisibility(View.VISIBLE);
                ((ScrollTextView) holder.itemView.findViewById(R.id.tv_text)).stopScroll();
            }
        });
    }

    public int getSelection() {
        return select;
    }
}
