package com.td.tvsuitdemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.td.tvsuit.adapter.FragmentPagerAdapter;
import com.td.tvsuitdemo.base.BaseFragment;

import java.util.List;

/**
 * Created by office on 2018/3/21.
 */

public class FragmentListPagerAdapter extends FragmentPagerAdapter {
    private FragmentManager fragmentManager;
    private List<BaseFragment> listfragment;

    public FragmentListPagerAdapter(FragmentManager fm, List<BaseFragment> list) {
        super(fm);
        this.fragmentManager = fm;
        this.listfragment = list;
    }

    @Override
    public Fragment getItem(int i) {
        return listfragment.get(i); //返回第几个fragment
    }

    @Override
    public int getCount() {
        return listfragment.size();
    }
}
