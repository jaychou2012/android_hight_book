package com.td.tvsuitdemo.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v17.leanback.widget.VerticalGridView;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.td.tvsuit.views.LoadingView;
import com.td.tvsuit.views.VerticalView;
import com.td.tvsuitdemo.R;
import com.td.tvsuitdemo.adapter.ListAdapter;
import com.td.tvsuitdemo.adapter.MenuAdapter;
import com.td.tvsuitdemo.base.BaseFragmentActivity;
import com.td.tvsuitdemo.entity.CardItem;
import com.td.tvsuitdemo.fragment.ListFragment;
import com.td.tvsuitdemo.utils.FocusStateIml;
import com.td.tvsuitdemo.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.td.tvsuitdemo.base.BaseApplication.getContext;

public class ListActivity extends BaseFragmentActivity implements FocusStateIml, VerticalView.OnLoadMoreListener {
    @BindView(R.id.vgv)
    VerticalGridView vgv;
    @BindView(R.id.vv_list)
    VerticalView vv_list;
    private MenuAdapter menuAdapter;
    private List<CardItem> menus;
    private LinearLayout.LayoutParams layoutParams;
    private ListFragment listFragment;
    private ListAdapter listAdapter;
    private List<CardItem> list;
    private LoadingView loadingView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        initView();
    }

    private void initView() {
        ButterKnife.bind(this);
        menus = new ArrayList<>();
        for (int i = 0; i < 18; i++) {
            CardItem cardItem = new CardItem();
            menus.add(cardItem);
        }
        menuAdapter = new MenuAdapter(this, R.layout.item_left, menus);
        vgv.setNumColumns(1);
        vgv.setAdapter(menuAdapter);
        vgv.setGravity(Gravity.CENTER);
//        vgv.setNextFocusUpId(R.id.expanded_menu);
        vgv.requestFocus();
        menuAdapter.setFocusStateIml(this);
        layoutParams = new LinearLayout.LayoutParams((int) (Utils.getScreenWidth(this) / 6.0), LinearLayout.LayoutParams.MATCH_PARENT);
        vgv.setLayoutParams(layoutParams);
        initList();
//        initFragments();
    }

    @SuppressLint("RestrictedApi")
    private void initList() {
        list = new ArrayList<>();
        for (int i = 0; i < 60; i++) {
            CardItem cardItem = new CardItem();
            list.add(cardItem);
        }
        listAdapter = new ListAdapter(this, R.layout.item_list, list);
        vv_list.setNumColumns(5);
        vv_list.setColumnCount(5);
        vv_list.setItemSpacing(Utils.dp2px(getContext(), 15));
        vv_list.setAdapter(listAdapter);
        vv_list.setFocusScrollStrategy(VerticalGridView.FOCUS_SCROLL_ITEM);
        vv_list.setOnLoadMoreListener(this);
        listAdapter.setOnItemClickListener((View view, int i) -> {
            showToast("点击");
            Intent intent = new Intent(this, SearchActivity.class);
            startActivity(intent);
        });
        loadingView = new LoadingView(this);
    }

    private void initFragments() {
        listFragment = ListFragment.newInstance("0", "");
        getSupportFragmentManager().beginTransaction().add(R.id.content, listFragment).show(listFragment).commit();
        getSupportFragmentManager().executePendingTransactions();
    }

    @Override
    public void currentFocus(boolean hasFocus, int position, View itemView) {
        if (!hasFocus) {
            ((TextView) itemView.findViewById(R.id.tv_name)).setTextColor(getResources().getColor(R.color.left_menu_bg));
        } else {
            ((TextView) itemView.findViewById(R.id.tv_name)).setTextColor(getResources().getColor(R.color.left_menu_color));
            itemView.setBackgroundResource(R.drawable.menu_selector);
        }
    }

    @Override
    public boolean onLoadMore() {
        loadingView.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 60; i++) {
                    CardItem cardItem = new CardItem();
                    list.add(cardItem);
                }
                listAdapter.notifyItemChanged(listAdapter.getSelection());
                loadingView.dismiss();
            }
        }, 2000);
        return false;
    }
}
