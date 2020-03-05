package com.td.tvsuitdemo.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;

public abstract class BaseFragment extends Fragment {
    private boolean isViewCreated = false;
    private boolean isInit = false;

    public BaseFragment() {

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isViewCreated = true;
        if (getUserVisibleHint() && !isInit) {
            onLoadData();
            isViewCreated = false;
            isInit = true;
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && !isInit && isViewCreated) {
            onLoadData();
            isViewCreated = false;
            isInit = true;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isViewCreated = false;
    }

    public void showToast(String text) {
        Toast.makeText(getActivity(), "" + text, Toast.LENGTH_SHORT).show();
    }

    public void onLoadData() {

    }

    public void init() {

    }
}
