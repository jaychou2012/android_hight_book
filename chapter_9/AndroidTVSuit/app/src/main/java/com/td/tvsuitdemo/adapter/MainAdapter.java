package com.td.tvsuitdemo.adapter;

import android.content.Context;
import android.view.View;

import com.td.tvsuit.utils.adapter.BaseMultiSmartAdapter;
import com.td.tvsuit.utils.adapter.SmarViewHolder;
import com.td.tvsuitdemo.R;
import com.td.tvsuitdemo.base.Config;
import com.td.tvsuitdemo.entity.CardItem;
import com.td.tvsuitdemo.entity.MultiCardItem;
import com.td.tvsuitdemo.utils.Utils;

import java.util.List;

/**
 * Created by office on 2018/3/21.
 */

public class MainAdapter extends BaseMultiSmartAdapter<MultiCardItem> {

    public MainAdapter(Context context, List<MultiCardItem> data) {
        super(context, data);
        addItemType(Config.ITEM_TYPE_THREE, R.layout.item_three);
        addItemType(Config.ITEM_TYPE_ONE_TWO, R.layout.item_one_two);
        addItemType(Config.ITEM_TYPE_ONE_THREE, R.layout.item_one_three);
        addItemType(Config.ITEM_TYPE_TWO_BIG_SMALL, R.layout.item_two_big_small);
        addItemType(Config.ITEM_TYPE_TWO, R.layout.item_two);
        addItemType(Config.ITEM_TYPE_TWO_THIN, R.layout.item_two_thin);
        addItemType(Config.ITEM_TYPE_TWO_WIDTH, R.layout.item_two_width);
        addItemType(Config.ITEM_TYPE_FOUR, R.layout.item_four);
        addItemType(Config.ITEM_TYPE_FOUR_EMPTY, R.layout.item_four_empty);
        addItemType(Config.ITEM_TYPE_TWO_ONE, R.layout.item_two_one);
        addItemType(Config.ITEM_TYPE_ONE_THREE_V, R.layout.item_one_three_v);
        addItemType(Config.ITEM_TYPE_TWO_EMPTY, R.layout.item_two_thin_empty);
    }

    @Override
    protected void bindData(SmarViewHolder holder, MultiCardItem item) {
        switch (item.getItemType()) {
            case Config.ITEM_TYPE_THREE:
                Utils.setFocusHighLight(holder.getView(R.id.fl_one),
                        R.id.v_alpha_one, Config.CARD_SCALE);
                Utils.setFocusHighLight(holder.getView(R.id.fl_two),
                        R.id.v_alpha_two, Config.CARD_SCALE);
                Utils.setFocusHighLight(holder.getView(R.id.fl_three),
                        R.id.v_alpha_three, Config.CARD_SCALE);
                holder.getView(R.id.fl_one).
                        setOnClickListener(new ItemClick(item.getCardItems().get(0)));
                holder.getView(R.id.fl_two).
                        setOnClickListener(new ItemClick(item.getCardItems().get(1)));
                holder.getView(R.id.fl_three).
                        setOnClickListener(new ItemClick(item.getCardItems().get(2)));
                break;
            case Config.ITEM_TYPE_ONE_TWO:
                Utils.setFocusHighLight(holder.getView(R.id.fl_one),
                        R.id.v_alpha_one, Config.CARD_SCALE);
                Utils.setFocusHighLight(holder.getView(R.id.fl_two),
                        R.id.v_alpha_two, Config.CARD_SCALE);
                Utils.setFocusHighLight(holder.getView(R.id.fl_three),
                        R.id.v_alpha_three, Config.CARD_SCALE);
                break;
            case Config.ITEM_TYPE_ONE_THREE:
                Utils.setFocusHighLight(holder.getView(R.id.fl_one),
                        R.id.v_alpha_one, Config.CARD_SCALE);
                Utils.setFocusHighLight(holder.getView(R.id.fl_two),
                        R.id.v_alpha_two, Config.CARD_SCALE);
                Utils.setFocusHighLight(holder.getView(R.id.fl_three),
                        R.id.v_alpha_three, Config.CARD_SCALE);
                Utils.setFocusHighLight(holder.getView(R.id.fl_four),
                        R.id.v_alpha_four, Config.CARD_SCALE);
                break;
            case Config.ITEM_TYPE_TWO_BIG_SMALL:
                Utils.setFocusHighLight(holder.getView(R.id.fl_one),
                        R.id.v_alpha_one, Config.CARD_SCALE);
                Utils.setFocusHighLight(holder.getView(R.id.fl_two),
                        R.id.v_alpha_two, Config.CARD_SCALE);
                break;
            case Config.ITEM_TYPE_TWO:
                Utils.setFocusHighLight(holder.getView(R.id.fl_one),
                        R.id.v_alpha_one, Config.CARD_SCALE);
                Utils.setFocusHighLight(holder.getView(R.id.fl_two),
                        R.id.v_alpha_two, Config.CARD_SCALE);
                break;
            case Config.ITEM_TYPE_TWO_THIN:
                Utils.setFocusHighLight(holder.getView(R.id.fl_one),
                        R.id.v_alpha_one, Config.CARD_SCALE);
                Utils.setFocusHighLight(holder.getView(R.id.fl_two),
                        R.id.v_alpha_two, Config.CARD_SCALE);
                break;
            case Config.ITEM_TYPE_TWO_WIDTH:
                Utils.setFocusHighLight(holder.getView(R.id.fl_one),
                        R.id.v_alpha_one, Config.CARD_SCALE);
                Utils.setFocusHighLight(holder.getView(R.id.fl_two),
                        R.id.v_alpha_two, Config.CARD_SCALE);
                break;
            case Config.ITEM_TYPE_FOUR:
                Utils.setFocusHighLight(holder.getView(R.id.fl_one),
                        R.id.v_alpha_one, Config.CARD_SCALE);
                Utils.setFocusHighLight(holder.getView(R.id.fl_two),
                        R.id.v_alpha_two, Config.CARD_SCALE);
                Utils.setFocusHighLight(holder.getView(R.id.fl_three),
                        R.id.v_alpha_three, Config.CARD_SCALE);
                break;
            case Config.ITEM_TYPE_FOUR_EMPTY:
                Utils.setFocusHighLight(holder.getView(R.id.fl_one),
                        R.id.v_alpha_one, Config.CARD_SCALE);
                Utils.setFocusHighLight(holder.getView(R.id.fl_two),
                        R.id.v_alpha_two, Config.CARD_SCALE);
                break;
            case Config.ITEM_TYPE_TWO_ONE:
                Utils.setFocusHighLight(holder.getView(R.id.fl_one),
                        R.id.v_alpha_one, Config.CARD_SCALE);
                Utils.setFocusHighLight(holder.getView(R.id.fl_two),
                        R.id.v_alpha_two, Config.CARD_SCALE);
                Utils.setFocusHighLight(holder.getView(R.id.fl_three),
                        R.id.v_alpha_three, Config.CARD_SCALE);
                break;
            case Config.ITEM_TYPE_ONE_THREE_V:
                Utils.setFocusHighLight(holder.getView(R.id.fl_one),
                        R.id.v_alpha_one, Config.CARD_SCALE);
                Utils.setFocusHighLight(holder.getView(R.id.fl_two),
                        R.id.v_alpha_two, Config.CARD_SCALE);
                Utils.setFocusHighLight(holder.getView(R.id.fl_three),
                        R.id.v_alpha_three, Config.CARD_SCALE);
                Utils.setFocusHighLight(holder.getView(R.id.fl_four),
                        R.id.v_alpha_four, Config.CARD_SCALE);
                break;
            case Config.ITEM_TYPE_TWO_EMPTY:
                Utils.setFocusHighLight(holder.getView(R.id.fl_one),
                        R.id.v_alpha_one, Config.CARD_SCALE);
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
