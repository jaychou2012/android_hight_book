package com.td.tvsuitdemo.fragment;

import android.os.Bundle;
import android.support.v17.leanback.widget.VerticalGridView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.td.tvsuit.utils.adapter.BaseMultiSmartAdapter;
import com.td.tvsuitdemo.R;
import com.td.tvsuitdemo.adapter.Main2Adapter;
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


public class Page2Fragment extends BaseFragment implements ViewLayoutIml {
    private static final String ID_PARAM1 = "id";

    private int id;
    private View rootView;
    @BindView(R.id.vgv)
    VerticalGridView vgv;
    private BaseMultiSmartAdapter adapter;
    private List<MultiCardItem> listItems;

    public Page2Fragment() {
        // Required empty public constructor
    }

    public static Page2Fragment newInstance(String param1, String param2, String param3) {
        Page2Fragment fragment = new Page2Fragment();
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
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_page2, container, false);
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
            default:
                initPage0();
                break;
        }
    }

    private void initPage0() {
        adapter = new Main2Adapter(getContext(), listItems);
        vgv.setAdapter(adapter);
        vgv.setNumColumns(1);
        Utils.getViewLayout(vgv, this);

        List<CardItem> cardItems = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            CardItem cardItem = new CardItem();
            cardItems.add(cardItem);
        }

        MultiCardItem cardItem = new MultiCardItem();
        cardItem.setItemType(Config.ITEM_TYPE_HOR);
        cardItem.setCardItems(cardItems.subList(0, 5));

        MultiCardItem cardItem1 = new MultiCardItem();
        cardItem1.setItemType(Config.ITEM_TYPE_THREE);
        cardItem1.setCardItems(cardItems.subList(3, 6));

        MultiCardItem cardItem2 = new MultiCardItem();
        cardItem2.setItemType(Config.ITEM_TYPE_THREE);
        cardItem2.setCardItems(cardItems.subList(6, 9));

        MultiCardItem cardItem3 = new MultiCardItem();
        cardItem3.setItemType(Config.ITEM_TYPE_THREE);
        cardItem3.setCardItems(cardItems.subList(8, 11));

        listItems.add(cardItem);
        listItems.add(cardItem1);
        listItems.add(cardItem2);
        listItems.add(cardItem3);
        listItems.add(cardItem3);
        listItems.add(cardItem3);
        listItems.add(cardItem3);
        listItems.add(cardItem3);
        listItems.add(cardItem3);
        adapter.notifyDataSetChanged();
    }

    private void initPage1() {
        adapter = new Main2Adapter(getContext(), listItems);
        vgv.setAdapter(adapter);
        vgv.setNumColumns(1);
        Utils.getViewLayout(vgv, this);

        List<CardItem> cardItems = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            CardItem cardItem = new CardItem();
            cardItems.add(cardItem);
        }

        MultiCardItem cardItem1 = new MultiCardItem();
        cardItem1.setItemType(Config.ITEM_TYPE_THREE);
        cardItem1.setCardItems(cardItems.subList(3, 6));

        MultiCardItem cardItem2 = new MultiCardItem();
        cardItem2.setItemType(Config.ITEM_TYPE_TWO_BIG_SMALL);
        cardItem2.setCardItems(cardItems.subList(6, 9));

        MultiCardItem cardItem3 = new MultiCardItem();
        cardItem3.setItemType(Config.ITEM_TYPE_TWO_BIG_SMALL);
        cardItem3.setCardItems(cardItems.subList(8, 11));

        listItems.add(cardItem1);
        listItems.add(cardItem2);
        listItems.add(cardItem3);
        adapter.notifyDataSetChanged();
    }

    private void initPage2() {
        adapter = new Main2Adapter(getContext(), listItems);
        vgv.setAdapter(adapter);
        vgv.setNumColumns(1);
        Utils.getViewLayout(vgv, this);

        List<CardItem> cardItems = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            CardItem cardItem = new CardItem();
            cardItems.add(cardItem);
        }

        MultiCardItem cardItem1 = new MultiCardItem();
        cardItem1.setItemType(Config.ITEM_TYPE_THREE);
        cardItem1.setCardItems(cardItems.subList(3, 6));

        MultiCardItem cardItem2 = new MultiCardItem();
        cardItem2.setItemType(Config.ITEM_TYPE_TWO_BIG_SMALL);
        cardItem2.setCardItems(cardItems.subList(6, 9));

        MultiCardItem cardItem3 = new MultiCardItem();
        cardItem3.setItemType(Config.ITEM_TYPE_TWO_BIG_SMALL);
        cardItem3.setCardItems(cardItems.subList(8, 11));

        listItems.add(cardItem1);
        listItems.add(cardItem2);
        listItems.add(cardItem3);
        adapter.notifyDataSetChanged();
    }

    private void initPage3() {
        adapter = new Main2Adapter(getContext(), listItems);
        vgv.setAdapter(adapter);
        vgv.setNumColumns(1);
        Utils.getViewLayout(vgv, this);

        List<CardItem> cardItems = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            CardItem cardItem = new CardItem();
            cardItems.add(cardItem);
        }

        MultiCardItem cardItem1 = new MultiCardItem();
        cardItem1.setItemType(Config.ITEM_TYPE_ONE_TWO);
        cardItem1.setCardItems(cardItems.subList(3, 6));

        MultiCardItem cardItem2 = new MultiCardItem();
        cardItem2.setItemType(Config.ITEM_TYPE_TWO_BIG_SMALL);
        cardItem2.setCardItems(cardItems.subList(6, 8));

        MultiCardItem cardItem3 = new MultiCardItem();
        cardItem3.setItemType(Config.ITEM_TYPE_THREE);
        cardItem3.setCardItems(cardItems.subList(8, 11));

        listItems.add(cardItem1);
        listItems.add(cardItem2);
        listItems.add(cardItem3);
        adapter.notifyDataSetChanged();
    }

    private void initPage4() {

    }

    private void initPage5() {

    }

    private void initPage6() {

    }

    @Override
    public void getWidthHeight(int width, int height) {
        vgv.setColumnWidth(width);
    }

    @Override
    public void init() {
        super.init();
        vgv.scrollToPosition(0);
    }
}
