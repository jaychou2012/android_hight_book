package com.td.tvsuit.views;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.WindowManager;

import com.td.tvsuit.R;


/**
 * Created by office on 2017/7/19.
 */
public class LoadingView extends Dialog {

    public LoadingView(Context context) {
        super(context, R.style.Loading);
        init(context);
    }

    public LoadingView(Context context, int themeResId) {
        super(context, R.style.Loading);
        init(context);
    }

    protected LoadingView(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        init(context);
    }

    private void init(Context context) {
        setContentView(R.layout.layout_loading);
        setCanceledOnTouchOutside(false);
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.BOTTOM;
        lp.dimAmount = 0;
        getWindow().setAttributes(lp);
    }
}
