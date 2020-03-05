package com.td.tvsuitdemo.fragment;

import android.os.Bundle;
import android.support.v17.leanback.widget.HorizontalGridView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.td.tvsuit.utils.adapter.BaseMultiSmartAdapter;
import com.td.tvsuitdemo.R;
import com.td.tvsuitdemo.adapter.MainAdapter;
import com.td.tvsuitdemo.base.BaseFragment;
import com.td.tvsuitdemo.base.Config;
import com.td.tvsuitdemo.entity.CardItem;
import com.td.tvsuitdemo.entity.MultiCardItem;
import com.td.tvsuitdemo.utils.Utils;
import com.td.tvsuitdemo.utils.ViewLayoutIml;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class PageFragment extends BaseFragment implements ViewLayoutIml {
    private static final String ID_PARAM1 = "id";

    private int id;
    private View rootView;
    @BindView(R.id.hgv)
    HorizontalGridView hgv;
    private BaseMultiSmartAdapter adapter;
    private List<MultiCardItem> listItems;

    public PageFragment() {
        // Required empty public constructor
    }

    public static PageFragment newInstance(String param1, String param2, String param3) {
        PageFragment fragment = new PageFragment();
        Bundle args = new Bundle();
        args.putString(ID_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            id = getArguments().getInt(ID_PARAM1, 0);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (rootView == null) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_page, container, false);
            ButterKnife.bind(this, view);
            rootView = view;
        }
        return rootView;
    }

    @Override
    public void onLoadData() {
        super.onLoadData();
        initView();
    }

    private void initView() {
        listItems = new ArrayList<>();
        switch (id) {
            case 0:
                initPage0();
                break;
            case 1:
                initPage1();
                break;
            case 2:
                initPage2();
                break;
            case 3:
                initPage3();
                break;
            case 4:
                initPage4();
                break;
            case 5:
                initPage5();
                break;
            case 6:
                initPage6();
                break;
            case 7:
                initPage7();
                break;
            default:
                initPage0();
                break;
        }
    }

    private void initPage0() {
        adapter = new MainAdapter(getContext(), listItems);
        hgv.setAdapter(adapter);
        hgv.setNumRows(1);
        Utils.getViewLayout(hgv, this);

        List<CardItem> cardItems = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            CardItem cardItem = new CardItem();
            cardItems.add(cardItem);
        }

        MultiCardItem cardItem = new MultiCardItem();
        cardItem.setItemType(Config.ITEM_TYPE_THREE);
        cardItem.setCardItems(cardItems.subList(0, 3));

        MultiCardItem cardItem1 = new MultiCardItem();
        cardItem1.setItemType(Config.ITEM_TYPE_ONE_TWO);
        cardItem1.setCardItems(cardItems.subList(3, 6));

        MultiCardItem cardItem2 = new MultiCardItem();
        cardItem2.setItemType(Config.ITEM_TYPE_TWO);
        cardItem2.setCardItems(cardItems.subList(6, 8));

        MultiCardItem cardItem3 = new MultiCardItem();
        cardItem3.setItemType(Config.ITEM_TYPE_TWO_THIN);
        cardItem3.setCardItems(cardItems.subList(8, 10));

        listItems.add(cardItem);
        listItems.add(cardItem1);
        for (int i = 0; i < 5; i++) {
            listItems.add(cardItem2);
        }
        for (int i = 0; i < 5; i++) {
            listItems.add(cardItem3);
        }
        adapter.notifyDataSetChanged();
    }

    private void initPage1() {
        adapter = new MainAdapter(getContext(), listItems);
        hgv.setAdapter(adapter);
        hgv.setNumRows(1);
        Utils.getViewLayout(hgv, this);

        List<CardItem> cardItems = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            CardItem cardItem = new CardItem();
            cardItems.add(cardItem);
        }

        MultiCardItem cardItem = new MultiCardItem();
        cardItem.setItemType(Config.ITEM_TYPE_FOUR);
        cardItem.setCardItems(cardItems.subList(0, 4));

        MultiCardItem cardItem1 = new MultiCardItem();
        cardItem1.setItemType(Config.ITEM_TYPE_ONE_TWO);
        cardItem1.setCardItems(cardItems.subList(3, 6));

        MultiCardItem cardItem2 = new MultiCardItem();
        cardItem2.setItemType(Config.ITEM_TYPE_TWO_WIDTH);
        cardItem2.setCardItems(cardItems.subList(6, 8));

        MultiCardItem cardItem3 = new MultiCardItem();
        cardItem3.setItemType(Config.ITEM_TYPE_TWO_THIN);
        cardItem3.setCardItems(cardItems.subList(8, 10));

        MultiCardItem cardItem4 = new MultiCardItem();
        cardItem4.setItemType(Config.ITEM_TYPE_TWO);
        cardItem4.setCardItems(cardItems.subList(6, 8));

        listItems.add(cardItem);
        listItems.add(cardItem1);
        for (int i = 0; i < 3; i++) {
            listItems.add(cardItem2);
        }
        for (int i = 0; i < 3; i++) {
            listItems.add(cardItem3);
        }
        for (int i = 0; i < 3; i++) {
            listItems.add(cardItem4);
        }
        adapter.notifyDataSetChanged();
    }

    private void initPage2() {
        adapter = new MainAdapter(getContext(), listItems);
        hgv.setAdapter(adapter);
        hgv.setNumRows(1);
        Utils.getViewLayout(hgv, this);

        List<CardItem> cardItems = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            CardItem cardItem = new CardItem();
            cardItems.add(cardItem);
        }

        MultiCardItem cardItem = new MultiCardItem();
        cardItem.setItemType(Config.ITEM_TYPE_ONE_THREE);
        cardItem.setCardItems(cardItems.subList(0, 5));

        MultiCardItem cardItem1 = new MultiCardItem();
        cardItem1.setItemType(Config.ITEM_TYPE_TWO);
        cardItem1.setCardItems(cardItems.subList(3, 6));

        MultiCardItem cardItem3 = new MultiCardItem();
        cardItem3.setItemType(Config.ITEM_TYPE_TWO_THIN);
        cardItem3.setCardItems(cardItems.subList(8, 10));

        listItems.add(cardItem);
        for (int i = 0; i < 4; i++) {
            listItems.add(cardItem1);
        }
        for (int i = 0; i < 6; i++) {
            listItems.add(cardItem3);
        }
        adapter.notifyDataSetChanged();
    }

    private void initPage3() {
        adapter = new MainAdapter(getContext(), listItems);
        hgv.setAdapter(adapter);
        hgv.setNumRows(1);
        Utils.getViewLayout(hgv, this);

        List<CardItem> cardItems = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            CardItem cardItem = new CardItem();
            cardItems.add(cardItem);
        }

        MultiCardItem cardItem = new MultiCardItem();
        cardItem.setItemType(Config.ITEM_TYPE_TWO_THIN);
        cardItem.setCardItems(cardItems.subList(0, 5));

        MultiCardItem cardItem1 = new MultiCardItem();
        cardItem1.setItemType(Config.ITEM_TYPE_TWO);
        cardItem1.setCardItems(cardItems.subList(3, 6));

        listItems.add(cardItem);
        for (int i = 0; i < 8; i++) {
            listItems.add(cardItem1);
        }
        adapter.notifyDataSetChanged();
    }

    private void initPage4() {
        adapter = new MainAdapter(getContext(), listItems);
        hgv.setAdapter(adapter);
        hgv.setNumRows(1);
        Utils.getViewLayout(hgv, this);

        List<CardItem> cardItems = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            CardItem cardItem = new CardItem();
            cardItems.add(cardItem);
        }

        MultiCardItem cardItem = new MultiCardItem();
        cardItem.setItemType(Config.ITEM_TYPE_TWO);
        cardItem.setCardItems(cardItems.subList(0, 5));

        MultiCardItem cardItem1 = new MultiCardItem();
        cardItem1.setItemType(Config.ITEM_TYPE_FOUR);
        cardItem1.setCardItems(cardItems.subList(3, 6));

        MultiCardItem cardItem2 = new MultiCardItem();
        cardItem2.setItemType(Config.ITEM_TYPE_FOUR_EMPTY);
        cardItem2.setCardItems(cardItems.subList(3, 6));

        listItems.add(cardItem);
        listItems.add(cardItem);
        for (int i = 0; i < 7; i++) {
            listItems.add(cardItem1);
        }
        listItems.add(cardItem2);
        adapter.notifyDataSetChanged();
    }

    private void initPage5() {
        adapter = new MainAdapter(getContext(), listItems);
        hgv.setAdapter(adapter);
        hgv.setNumRows(1);
        Utils.getViewLayout(hgv, this);

        List<CardItem> cardItems = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            CardItem cardItem = new CardItem();
            cardItems.add(cardItem);
        }

        MultiCardItem cardItem = new MultiCardItem();
        cardItem.setItemType(Config.ITEM_TYPE_TWO_ONE);
        cardItem.setCardItems(cardItems.subList(0, 5));

        MultiCardItem cardItem1 = new MultiCardItem();
        cardItem1.setItemType(Config.ITEM_TYPE_TWO_WIDTH);
        cardItem1.setCardItems(cardItems.subList(3, 6));

        listItems.add(cardItem);
        for (int i = 0; i < 9; i++) {
            listItems.add(cardItem1);
        }
        adapter.notifyDataSetChanged();
    }

    private void initPage6() {
        adapter = new MainAdapter(getContext(), listItems);
        hgv.setAdapter(adapter);
        hgv.setNumRows(1);
        Utils.getViewLayout(hgv, this);

        List<CardItem> cardItems = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            CardItem cardItem = new CardItem();
            cardItems.add(cardItem);
        }

        MultiCardItem cardItem = new MultiCardItem();
        cardItem.setItemType(Config.ITEM_TYPE_TWO_ONE);
        cardItem.setCardItems(cardItems.subList(0, 5));

        MultiCardItem cardItem1 = new MultiCardItem();
        cardItem1.setItemType(Config.ITEM_TYPE_TWO_THIN);
        cardItem1.setCardItems(cardItems.subList(3, 6));

        MultiCardItem cardItem2 = new MultiCardItem();
        cardItem2.setItemType(Config.ITEM_TYPE_TWO);
        cardItem2.setCardItems(cardItems.subList(3, 6));

        MultiCardItem cardItem3 = new MultiCardItem();
        cardItem3.setItemType(Config.ITEM_TYPE_ONE_TWO);
        cardItem3.setCardItems(cardItems.subList(3, 6));

        listItems.add(cardItem);
        listItems.add(cardItem1);
        for (int i = 0; i < 3; i++) {
            listItems.add(cardItem2);
        }
        listItems.add(cardItem3);
        listItems.add(cardItem2);
        listItems.add(cardItem2);
        for (int i = 0; i < 3; i++) {
            listItems.add(cardItem1);
        }
        adapter.notifyDataSetChanged();
    }

    private void initPage7() {
        adapter = new MainAdapter(getContext(), listItems);
        hgv.setAdapter(adapter);
        hgv.setNumRows(1);
        Utils.getViewLayout(hgv, this);

        List<CardItem> cardItems = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            CardItem cardItem = new CardItem();
            cardItems.add(cardItem);
        }

        MultiCardItem cardItem = new MultiCardItem();
        cardItem.setItemType(Config.ITEM_TYPE_ONE_THREE_V);
        cardItem.setCardItems(cardItems.subList(0, 5));

        MultiCardItem cardItem1 = new MultiCardItem();
        cardItem1.setItemType(Config.ITEM_TYPE_TWO_THIN);
        cardItem1.setCardItems(cardItems.subList(3, 6));

        MultiCardItem cardItem2 = new MultiCardItem();
        cardItem2.setItemType(Config.ITEM_TYPE_TWO_EMPTY);
        cardItem2.setCardItems(cardItems.subList(3, 6));

        listItems.add(cardItem);
        for (int i = 0; i < 3; i++) {
            listItems.add(cardItem1);
        }
        listItems.add(cardItem2);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void getWidthHeight(int width, int height) {
        hgv.setRowHeight(height);
    }

    @Override
    public void init() {
        super.init();
        hgv.scrollToPosition(0);
    }
}
