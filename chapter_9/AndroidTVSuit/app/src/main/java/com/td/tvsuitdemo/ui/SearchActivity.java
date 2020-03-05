package com.td.tvsuitdemo.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.td.tvsuit.views.KeyBordView;
import com.td.tvsuitdemo.R;
import com.td.tvsuitdemo.base.BaseActivity;
import com.td.tvsuitdemo.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchActivity extends BaseActivity implements KeyBordView.KeySelectIml {
    @BindView(R.id.kbv)
    KeyBordView keyBordView;
    @BindView(R.id.et_text)
    EditText et_text;
    @BindView(R.id.ll_keyboard)
    LinearLayout ll_keyboard;
    private LinearLayout.LayoutParams layoutParams;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initView();
    }

    private void initView() {
        ButterKnife.bind(this);
        layoutParams = new LinearLayout.LayoutParams(
                Utils.getScreenWidth(this) / 2, LinearLayout.LayoutParams.MATCH_PARENT);
        ll_keyboard.setLayoutParams(layoutParams);
        // 键盘按键监听
        keyBordView.setKeySelectListener(this);
        // 是否键盘按键正方形显示，不按照宽度自适应方式显示
        keyBordView.setSquareKey(true);

        Drawable icon_search = getResources().getDrawable(R.mipmap.icon_search);
        icon_search.setBounds(0, 0, Utils.dp2px(this, 20),
                Utils.dp2px(this, 20));
        et_text.setCompoundDrawablePadding(5);
        et_text.setCompoundDrawables(icon_search, null, null, null);
    }

    @Override
    public void keySelect(String key, boolean t9) {
        StringBuilder stringBuilder = new StringBuilder(et_text.getText().toString().trim());
        stringBuilder.append(key);
        et_text.setText(stringBuilder);
    }

    @Override
    public void keyDelete(boolean t9) {
        String string = et_text.getText().toString().trim();
        if (string.length() == 0) {
            return;
        }
        String subString = string.substring(0, string.length() - 1);
        et_text.setText(subString);
        if (subString.length() == 0) {
            et_text.setHint("输入片名/人名的首字母或全拼");
        }
    }

    @Override
    public void keyClear(boolean t9) {
        et_text.setText("");
        et_text.setHint("输入片名/人名的首字母或全拼");
    }

    @Override
    public void onLayoutComplete(int width) {
        et_text.setLayoutParams(new LinearLayout.LayoutParams(width, LinearLayout.LayoutParams.WRAP_CONTENT));
    }
}
