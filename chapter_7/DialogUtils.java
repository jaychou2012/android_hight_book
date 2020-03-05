package com.td.assist.utils;

import android.content.Context;

import com.td.assist.R;
import com.td.assist.SmartDialog;


public class DialogUtils {
    private SmartDialog dialog;
    private Context context;

    public DialogUtils(Context context) {
        this.context = context;
    }

    public void showLoadingDialog() {
        if (dialog != null) {
            dialog.dismiss();
            dialog = null;
        }
        dialog = new SmartDialog(context, R.style.loadingDialog, R.layout.dialog_loading);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    public void hideLoadingDialog() {
        if (dialog != null) {
            dialog.dismiss();
            dialog = null;
        }
    }

}
