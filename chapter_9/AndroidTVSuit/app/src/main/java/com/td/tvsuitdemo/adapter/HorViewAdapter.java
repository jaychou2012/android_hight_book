package com.td.tvsuitdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.td.tvsuit.views.ScrollTextView;
import com.td.tvsuitdemo.R;
import com.td.tvsuitdemo.entity.CardItem;
import com.td.tvsuitdemo.utils.Utils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HorViewAdapter extends RecyclerView.Adapter<HorViewAdapter.RecyclerHolder> {
    private Context context;
    private FrameLayout.LayoutParams layoutParams;
    private int layoutId;
    private onRecyclerItemClickerListener onRecyclerItemClickerListener;
    private List<CardItem> lists;

    public HorViewAdapter(Context context, int layoutId, List<CardItem> lists) {
        this.context = context;
        this.layoutId = layoutId;
        this.lists = lists;
        layoutParams = new FrameLayout.LayoutParams((int) (Utils.getScreenWidth(context) / 2.5f), Utils.dp2px(context, 30));
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(layoutId, viewGroup, false);
        return new RecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int i) {
        holder.fl_parent.setLayoutParams(layoutParams);
        holder.textView.setText((i % lists.size()) + "");
        Utils.setFocusHighLight(holder.fl_parent, R.id.v_alpha, 1.02f);
        holder.fl_parent.setOnClickListener((View v) -> {
            if (onRecyclerItemClickerListener != null) {
                onRecyclerItemClickerListener.onRecyclerItemClick(v, i % lists.size(), lists);
            }
        });
        holder.fl_parent.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_DPAD_UP) {
                    Utils.sendLocalMessage(context,
                            "ACTION_UP");
                }
                return false;
            }
        });
        holder.fl_parent.setNextFocusUpId(R.id.tab);
    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    class RecyclerHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_text)
        ScrollTextView textView;
        @BindView(R.id.iv_img)
        ImageView iv_img;
        @BindView(R.id.fl_parent)
        FrameLayout fl_parent;

        private RecyclerHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    /**
     * 点击监听回调接口
     */
    public interface onRecyclerItemClickerListener {
        void onRecyclerItemClick(View view, int position, List<CardItem> list);
    }

    /**
     * 增加点击监听
     */
    public void setItemListener(onRecyclerItemClickerListener mListener) {
        this.onRecyclerItemClickerListener = mListener;
    }
}
