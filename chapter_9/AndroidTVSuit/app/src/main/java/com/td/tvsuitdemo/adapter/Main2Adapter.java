package com.td.tvsuitdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v17.leanback.widget.OnChildViewHolderSelectedListener;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;

import com.td.tvsuit.utils.adapter.BaseMultiSmartAdapter;
import com.td.tvsuit.utils.adapter.SmarViewHolder;
import com.td.tvsuit.views.HorizontalFocusView;
import com.td.tvsuit.views.IndicatorView;
import com.td.tvsuitdemo.R;
import com.td.tvsuitdemo.base.Config;
import com.td.tvsuitdemo.entity.CardItem;
import com.td.tvsuitdemo.entity.MultiCardItem;
import com.td.tvsuitdemo.ui.Main2Activity;
import com.td.tvsuitdemo.ui.MainActivity;
import com.td.tvsuitdemo.utils.Utils;

import java.util.List;

/**
 * Created by office on 2018/3/21.
 */

public class Main2Adapter extends BaseMultiSmartAdapter<MultiCardItem> {
    private HorViewAdapter horViewAdapter;

    public Main2Adapter(Context context, List<MultiCardItem> data) {
        super(context, data);
        addItemType(Config.ITEM_TYPE_HOR, R.layout.item_hor_v);
        addItemType(Config.ITEM_TYPE_THREE, R.layout.item_three_v);
        addItemType(Config.ITEM_TYPE_ONE_TWO, R.layout.item_one_two_v);
        addItemType(Config.ITEM_TYPE_TWO_BIG_SMALL, R.layout.item_two_big_small_v);
    }

    @Override
    protected void bindData(SmarViewHolder holder, MultiCardItem item) {
        switch (item.getItemType()) {
            case Config.ITEM_TYPE_HOR:
                horViewAdapter = new HorViewAdapter(context, R.layout.item_list_hor, item.getCardItems());
                ((HorizontalFocusView) holder.getView(R.id.hfv)).setAdapter(horViewAdapter);
                ((HorizontalFocusView) holder.getView(R.id.hfv)).setNumRows(1);
                ((HorizontalFocusView) holder.getView(R.id.hfv)).setGravity(Gravity.CENTER);
                ((HorizontalFocusView) holder.getView(R.id.hfv)).setRowHeight(Utils.dp2px(context, 100));
                ((HorizontalFocusView) holder.getView(R.id.hfv)).setHorizontalSpacing(5);
                ((HorizontalFocusView) holder.getView(R.id.hfv)).setVerticalSpacing(5);
                ((HorizontalFocusView) holder.getView(R.id.hfv)).setAnimateChildLayout(true);
                ((HorizontalFocusView) holder.getView(R.id.hfv)).setSelectedPosition(item.getCardItems().size() * 100);
                horViewAdapter.setItemListener(new HorViewAdapter.onRecyclerItemClickerListener() {
                    @Override
                    public void onRecyclerItemClick(View view, int position, List<CardItem> list) {
                        Intent intent = new Intent(context, Main2Activity.class);
                        context.startActivity(intent);
                    }
                });
                (holder.getView(R.id.hfv)).setNextFocusUpId(R.id.tab);
                ((IndicatorView) holder.getView(R.id.indicatorView)).setDefaultSelect(0);
                ((IndicatorView) holder.getView(R.id.indicatorView)).setNumber(item.getCardItems().size());
                ((IndicatorView) holder.getView(R.id.indicatorView)).initLayout();
                ((HorizontalFocusView) holder.getView(R.id.hfv)).setOnChildViewHolderSelectedListener(new OnChildViewHolderSelectedListener() {
                    @Override
                    public void onChildViewHolderSelected(RecyclerView parent, RecyclerView.ViewHolder child, int position, int subposition) {
                        super.onChildViewHolderSelected(parent, child, position, subposition);
                        ((IndicatorView) holder.getView(R.id.indicatorView)).setSelect(position % item.getCardItems().size());
                    }
                });
                (holder.getView(R.id.hfv)).requestFocus();
                break;
            case Config.ITEM_TYPE_THREE:
                Utils.setFocusHighLight(holder.itemView.findViewById(R.id.fl_one), R.id.v_alpha_one, 1.03f);
                Utils.setFocusHighLight(holder.itemView.findViewById(R.id.fl_two), R.id.v_alpha_two, 1.03f);
                Utils.setFocusHighLight(holder.itemView.findViewById(R.id.fl_three), R.id.v_alpha_three, 1.03f);
                holder.itemView.findViewById(R.id.fl_one).setOnClickListener(new ItemClick(item.getCardItems().get(0)));
                holder.itemView.findViewById(R.id.fl_two).setOnClickListener(new ItemClick(item.getCardItems().get(1)));
                holder.itemView.findViewById(R.id.fl_three).setOnClickListener(new ItemClick(item.getCardItems().get(2)));
                break;
            case Config.ITEM_TYPE_ONE_TWO:
                Utils.setFocusHighLight(holder.itemView.findViewById(R.id.fl_one), R.id.v_alpha_one, 1.03f);
                Utils.setFocusHighLight(holder.itemView.findViewById(R.id.fl_two), R.id.v_alpha_two, 1.03f);
                Utils.setFocusHighLight(holder.itemView.findViewById(R.id.fl_three), R.id.v_alpha_three, 1.03f);
                holder.itemView.findViewById(R.id.fl_one).setOnClickListener(new ItemClick(item.getCardItems().get(0)));
                holder.itemView.findViewById(R.id.fl_two).setOnClickListener(new ItemClick(item.getCardItems().get(1)));
                holder.itemView.findViewById(R.id.fl_three).setOnClickListener(new ItemClick(item.getCardItems().get(2)));
                break;
            case Config.ITEM_TYPE_TWO_BIG_SMALL:
                Utils.setFocusHighLight(holder.itemView.findViewById(R.id.fl_one), R.id.v_alpha_one, 1.03f);
                Utils.setFocusHighLight(holder.itemView.findViewById(R.id.fl_two), R.id.v_alpha_two, 1.03f);
                holder.itemView.findViewById(R.id.fl_one).setOnClickListener(new ItemClick(item.getCardItems().get(0)));
                holder.itemView.findViewById(R.id.fl_two).setOnClickListener(new ItemClick(item.getCardItems().get(1)));
                break;
        }
    }

    class ItemClick implements View.OnClickListener {
        CardItem cardItem;

        public ItemClick(CardItem cardItem) {
            this.cardItem = cardItem;
        }

        @Override
        public void onClick(View v) {
            Utils.setPageDestiNation(getContext(), cardItem);
        }
    }
}
