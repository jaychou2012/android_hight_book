package com.td.tvsuitdemo.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.LocalBroadcastManager;
import android.view.KeyEvent;
import android.view.View;

import com.td.tvsuit.leanback.widget.tablayout.TvTabLayout;
import com.td.tvsuit.views.NoScrollViewPager;
import com.td.tvsuit.views.SlideViewPager;
import com.td.tvsuitdemo.R;
import com.td.tvsuitdemo.adapter.FragmentListPagerAdapter;
import com.td.tvsuitdemo.adapter.FragmentPagerStateAdapter;
import com.td.tvsuitdemo.base.BaseFragment;
import com.td.tvsuitdemo.base.BaseFragmentActivity;
import com.td.tvsuitdemo.fragment.Page2Fragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main2Activity extends BaseFragmentActivity implements TvTabLayout.OnTabSelectedListener, NoScrollViewPager.OnPageChangeListener, View.OnClickListener {
    @BindView(R.id.svp)
    SlideViewPager slideViewPager;
    @BindView(R.id.tab)
    TvTabLayout tablayout;
    private List<BaseFragment> fragmentList;
    private FragmentListPagerAdapter fragmentListPagerAdapter;
    private Page2Fragment pageFragment;
    private FragmentPagerStateAdapter fragmentPagerStateAdapter;
    private long exitTime = 0;
    private KeyReceiver keyReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        ButterKnife.bind(this);
        for (int i = 0; i < 6; i++) {
            tablayout.addTab(tablayout.newTab().setText(i + ""), i == 0);
        }
        tablayout.addOnTabSelectedListener(this);
        tablayout.setOnClickListener(this);
        initFragment();
    }

    private void initFragment() {
        fragmentList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            pageFragment = new Page2Fragment();
            Bundle bundle = new Bundle();
            bundle.putInt("id", i);
            pageFragment.setArguments(bundle);
            fragmentList.add(pageFragment);
        }

        FragmentManager fm = getSupportFragmentManager();
        fragmentListPagerAdapter = new FragmentListPagerAdapter(fm, fragmentList);
        slideViewPager.setAdapter(fragmentListPagerAdapter);

//        fragmentPagerStateAdapter = new FragmentPagerStateAdapter(fm, fragmentList);
//        fragmentPager.setAdapter(fragmentPagerStateAdapter);
        slideViewPager.setCurrentItem(0);
        slideViewPager.setOffscreenPageLimit(3);
        slideViewPager.addOnPageChangeListener(this);
        slideViewPager.setPageScroll(true);
        tablayout.requestFocus();
        keyReceiver = new KeyReceiver();
        registeMessageBroadcast();
    }

    @Override
    public void onTabSelected(TvTabLayout.Tab tab) {
        slideViewPager.setCurrentItem(tab.getPosition(), true);
    }

    @Override
    public void onTabUnselected(TvTabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TvTabLayout.Tab tab) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        tablayout.selectTab(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (slideViewPager.getCurrentItem() != 0) {
                slideViewPager.setCurrentItem(0, true);
                tablayout.selectTab(0);
                return true;
            }
            if (System.currentTimeMillis() - exitTime > 1500) {
                showToast("再按一次退出客户端");
                exitTime = System.currentTimeMillis();
                return true;
            } else {
                System.exit(0);
            }
        }
        return super.onKeyUp(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unRegisteMessageBroadcast();
    }

    private void registeMessageBroadcast() {
        IntentFilter intentFilter = new IntentFilter("ACTION_UP");
        LocalBroadcastManager.getInstance(this).registerReceiver(keyReceiver, intentFilter);
    }

    private void unRegisteMessageBroadcast() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(keyReceiver);
    }

    @Override
    public void onClick(View v) {
        showToast("点击");
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }

    class KeyReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("ACTION_UP")) {
                tablayout.requestFocus();
            }
        }
    }
}
