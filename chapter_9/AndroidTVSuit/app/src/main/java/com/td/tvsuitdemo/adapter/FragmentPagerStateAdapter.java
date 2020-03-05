package com.td.tvsuitdemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.td.tvsuitdemo.base.BaseFragment;

import java.util.List;

/**
 * Created by office on 2018/3/21.
 */

public class FragmentPagerStateAdapter extends FragmentStatePagerAdapter {
    private FragmentManager fragmentManager;
    private List<BaseFragment> listfragment;

    public FragmentPagerStateAdapter(FragmentManager fm, List<BaseFragment> list) {
        super(fm);
        this.fragmentManager = fm;
        this.listfragment = list;
    }

    @Override
    public Fragment getItem(int i) {
        return listfragment.get(i);
    }

    @Override
    public int getCount() {
        return listfragment.size();
    }
}
