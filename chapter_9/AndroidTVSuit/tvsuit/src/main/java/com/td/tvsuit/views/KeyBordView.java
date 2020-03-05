package com.td.tvsuit.views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.td.tvsuit.R;
import com.td.tvsuit.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * TV键盘：全键盘和T9键盘
 */
public class KeyBordView extends LinearLayout implements View.OnClickListener, ViewTreeObserver.OnGlobalLayoutListener {
    private TextView tv_clear;
    private TextView tv_back;
    private TextView tv_all;
    private TextView tv_t9;
    private View headerView;
    private View footerView;
    private String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
            "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"
    };
    private String[] t9 = {"\n0/1", "2\nABC", "3\nDEF", "4\nGHI", "5\nJKL", "6\nMNO", "7\nPQRS", "8\nTUV", "9\nWXYZ"};
    private LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
    private LayoutParams keyLayoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
    private LayoutParams keyParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
    private boolean init = false;
    private int layoutWidth = 0;
    private int layoutHeight = 0;
    private LinearLayout linearLayout;
    private Interpolator interpolator;
    private boolean isT9 = true;
    private KeySelectIml keySelectIml;
    private boolean dispatchKeyDel = true;
    private boolean squareKey = false;
    private View tv_9_key;
    private List<View> t9Views;

    public KeyBordView(Context context) {
        super(context);
        init();
    }

    public KeyBordView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public KeyBordView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setOrientation(VERTICAL);
        keyLayoutParams.weight = 1;
        keyParams.weight = 1;
        interpolator = new OvershootInterpolator();
        getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    public void setKeySelectListener(KeySelectIml keySelectListener) {
        this.keySelectIml = keySelectListener;
    }

    public void setDefaultKeyboard(boolean t9) {
        isT9 = t9;
    }

    private void initFooter() {
        footerView = LayoutInflater.from(getContext()).inflate(R.layout.layout_keybord_footer, null);
        addView(footerView);
        if (squareKey) {
            footerView.getViewTreeObserver().addOnGlobalLayoutListener(new LayoutObserver(footerView));
        }
    }

    private void initHeader() {
        headerView = LayoutInflater.from(getContext()).inflate(R.layout.layout_keybord_header, null);
        addView(headerView);
        if (squareKey) {
            headerView.getViewTreeObserver().addOnGlobalLayoutListener(new LayoutObserver(headerView));
        }
    }

    class LayoutObserver implements ViewTreeObserver.OnGlobalLayoutListener {
        private View view;

        public LayoutObserver(View view) {
            this.view = view;
        }

        @Override
        public void onGlobalLayout() {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            if (footerView.getHeight() != 0 && headerView.getHeight() != 0 && !init) {
                layoutHeight = layoutHeight - headerView.getHeight() - footerView.getHeight();
                keyLayoutParams.width = layoutHeight;
                keyLayoutParams.height = LayoutParams.MATCH_PARENT;
                setLayoutParams(keyLayoutParams);
                init = true;
                if (keySelectIml != null) {
                    keySelectIml.onLayoutComplete(layoutHeight);
                }
            }
        }
    }

    private void initContainer() {
//        init = true;
        setClipChildren(false);
        linearLayout = new LinearLayout(getContext());
        linearLayout.setId(R.id.keybord_container);
        linearLayout.setOrientation(VERTICAL);
        linearLayout.setClipChildren(false);
        layoutParams.height = 0;
        layoutParams.weight = 1;
        addView(linearLayout, 1, layoutParams);
    }

    private void initAll() {
        linearLayout.removeAllViews();
        keyLayoutParams.setMargins(0, Utils.dp2px(getContext(), 10), 0, 0);
        keyParams.setMargins(Utils.dp2px(getContext(), 5), 0, Utils.dp2px(getContext(), 5), 0);
        for (int i = 0; i < 6; i++) {
            LinearLayout keyLayout = new LinearLayout(getContext());
            keyLayout.setOrientation(HORIZONTAL);
            for (int j = 0; j < 6; j++) {
                View keyAllView = LayoutInflater.from(getContext()).inflate(R.layout.layout_keyall, null);
                TextView tv_keyAll = keyAllView.findViewById(R.id.tv_keyall);
                tv_keyAll.setText(letters[(i * 6) + j]);
//                TextView textView = new TextView(getContext());
//                textView.setText(letters[(i * 6) + j]);
//                textView.setFocusableInTouchMode(true);
//                textView.setFocusable(true);
//                textView.setGravity(Gravity.CENTER);
//                TextPaint paint = textView.getPaint();
//                paint.setFakeBoldText(true);
//                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
//                textView.setTextColor(getResources().getColor(R.color.keybord_color));
//                textView.setBackgroundResource(R.drawable.keybord_selector);
                keyLayout.addView(tv_keyAll, keyParams);
                tv_keyAll.setOnClickListener(this);
                Utils.setFocusHighLight(tv_keyAll, interpolator, false);
            }
            linearLayout.addView(keyLayout, keyLayoutParams);
        }
        isT9 = false;
    }

    private void initT9() {
        linearLayout.removeAllViews();
        keyLayoutParams.setMargins(0, Utils.dp2px(getContext(), 10), 0, 0);
        keyParams.setMargins(Utils.dp2px(getContext(), 5), 0, Utils.dp2px(getContext(), 5), 0);
        t9Views = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            LinearLayout keyLayout = new LinearLayout(getContext());
            keyLayout.setOrientation(HORIZONTAL);
            keyLayout.setClipChildren(false);
            for (int j = 0; j < 3; j++) {
                View keyView = LayoutInflater.from(getContext()).inflate(R.layout.layout_key, null);
                TextView tv_key = keyView.findViewById(R.id.tv_key);
                tv_key.setText(t9[(i * 3) + j]);
                LinearLayout ll_select = keyView.findViewById(R.id.ll_select);
                ll_select.setVisibility(View.GONE);
                tv_key.setOnClickListener(new KeyPopClick(ll_select, ((i * 3) + j)));
                keyLayout.addView(keyView, keyParams);
                Utils.setFocusHighLight(tv_key, interpolator, false);
                t9Views.add(keyView);
            }
            linearLayout.addView(keyLayout, keyLayoutParams);
        }
        isT9 = true;
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.tv_clear) {
            if (keySelectIml != null) {
                keySelectIml.keyClear(isT9);
            }

        } else if (i == R.id.tv_back) {
            if (keySelectIml != null) {
                keySelectIml.keyDelete(isT9);
            }

        } else if (i == R.id.tv_all) {
            if (!isT9) {
                return;
            }
            tv_all.setTextColor(getResources().getColor(R.color.yellow));
            tv_t9.setTextColor(getResources().getColor(R.color.white));
            initAll();

        } else if (i == R.id.tv_t9) {
            if (isT9) {
                return;
            }
            tv_t9.setTextColor(getResources().getColor(R.color.yellow));
            tv_all.setTextColor(getResources().getColor(R.color.white));
            initT9();

        } else if (i == R.id.tv_keyall) {
            if (keySelectIml != null) {
                keySelectIml.keySelect(((TextView) v).getText().toString().trim(), isT9);
            }
            v.requestFocus();
        }
    }

    private void showToast(String text) {
        Toast.makeText(getContext(), "" + text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (dispatchKeyDel) {
            if (event.getAction() == KeyEvent.ACTION_DOWN && event.getKeyCode() == KeyEvent.KEYCODE_DEL) {
                if (keySelectIml != null) {
                    keySelectIml.keyDelete(isT9);
                }
            }
        }
        if (event.getAction() == KeyEvent.ACTION_DOWN && event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            if (isT9 && tv_9_key != null) {
                LinearLayout ll_select = tv_9_key.findViewById(R.id.ll_select);
                TextView tv_key = tv_9_key.findViewById(R.id.tv_key);
                if (ll_select.getVisibility() == View.VISIBLE) {
                    tv_key.setVisibility(View.VISIBLE);
                    ll_select.setVisibility(View.GONE);
                    tv_key.requestFocus();
                    return true;
                }
            }
        }
        return super.dispatchKeyEvent(event);
    }

    /**
     * 是否拦截遥控器上的删除按钮，默认监听删除按钮
     *
     * @param dispatchKeyDel
     */
    public void setDispatchKeyDel(boolean dispatchKeyDel) {
        this.dispatchKeyDel = dispatchKeyDel;
    }

    public void setSquareKey(boolean squareKey) {
        this.squareKey = squareKey;
    }

    @Override
    public void onGlobalLayout() {
        if (!init) {
            getViewTreeObserver().removeOnGlobalLayoutListener(this);
            layoutWidth = getWidth();
            layoutHeight = getHeight();
            initHeader();
            initFooter();
            initContainer();
            if (isT9) {
                initT9();
            } else {
                initAll();
            }
            initView();
            tv_clear.setOnClickListener(this);
            tv_t9.setOnClickListener(this);
            tv_all.setOnClickListener(this);
            tv_back.setOnClickListener(this);
            if (isT9) {
                tv_t9.setTextColor(getResources().getColor(R.color.yellow));
            } else {
                tv_all.setTextColor(getResources().getColor(R.color.yellow));
            }
        }
    }

    private void initView() {
        tv_clear = findViewById(R.id.tv_clear);
        tv_back = findViewById(R.id.tv_back);
        tv_all = findViewById(R.id.tv_all);
        tv_t9 = findViewById(R.id.tv_t9);
    }

    class KeyPopClick implements OnClickListener, OnFocusChangeListener {
        LinearLayout ll_select;
        View tv_key;
        TextView tv_center;
        TextView tv_top;
        TextView tv_left;
        TextView tv_right;
        TextView tv_bottom;
        int position = 0;


        public KeyPopClick(LinearLayout ll_select, int position) {
            this.ll_select = ll_select;
            this.position = position;
        }

        @Override
        public void onClick(View v) {
            tv_key = v;
            tv_9_key = t9Views.get(position);
            v.setVisibility(View.GONE);
            ll_select.setVisibility(View.VISIBLE);
            tv_center = ll_select.findViewById(R.id.tv_center);
            tv_top = ll_select.findViewById(R.id.tv_top);
            tv_left = ll_select.findViewById(R.id.tv_left);
            tv_right = ll_select.findViewById(R.id.tv_right);
            tv_bottom = ll_select.findViewById(R.id.tv_bottom);
            setTextKeyClick();
            tv_center.requestFocus();
            tv_center.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (keySelectIml != null) {
                        keySelectIml.keySelect(((TextView) view).getText().toString().trim(), true);
                    }
                    ll_select.setVisibility(View.GONE);
                    tv_key.setVisibility(View.VISIBLE);
                    tv_key.requestFocus();
                }
            });
            tv_top.setOnFocusChangeListener(this);
            tv_left.setOnFocusChangeListener(this);
            tv_right.setOnFocusChangeListener(this);
            tv_bottom.setOnFocusChangeListener(this);
        }

        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus) {
                if (keySelectIml != null) {
                    keySelectIml.keySelect(((TextView) v).getText().toString().trim(), true);
                }
                ll_select.setVisibility(View.GONE);
                tv_key.setVisibility(View.VISIBLE);
                tv_key.requestFocus();
            }
        }

        private void setTextKeyClick() {
            switch (position) {
                case 0:
                    tv_center.setText("0");
                    tv_top.setText("1");
                    tv_left.setVisibility(INVISIBLE);
                    tv_right.setVisibility(INVISIBLE);
                    tv_bottom.setVisibility(INVISIBLE);
                    break;
                case 1:
                    tv_center.setText("2");
                    tv_top.setText("B");
                    tv_left.setText("A");
                    tv_right.setText("C");
                    tv_bottom.setVisibility(INVISIBLE);
                    break;
                case 2:
                    tv_center.setText("3");
                    tv_top.setText("E");
                    tv_left.setText("D");
                    tv_right.setText("F");
                    tv_bottom.setVisibility(INVISIBLE);
                    break;
                case 3:
                    tv_center.setText("4");
                    tv_top.setText("H");
                    tv_left.setText("G");
                    tv_right.setText("I");
                    tv_bottom.setVisibility(INVISIBLE);
                    break;
                case 4:
                    tv_center.setText("5");
                    tv_top.setText("K");
                    tv_left.setText("J");
                    tv_right.setText("L");
                    tv_bottom.setVisibility(INVISIBLE);
                    break;
                case 5:
                    tv_center.setText("6");
                    tv_top.setText("N");
                    tv_left.setText("M");
                    tv_right.setText("O");
                    tv_bottom.setVisibility(INVISIBLE);
                    break;
                case 6:
                    tv_center.setText("7");
                    tv_top.setText("Q");
                    tv_left.setText("P");
                    tv_right.setText("R");
                    tv_bottom.setText("S");
                    break;
                case 7:
                    tv_center.setText("8");
                    tv_top.setText("U");
                    tv_left.setText("T");
                    tv_right.setText("V");
                    tv_bottom.setVisibility(INVISIBLE);
                    break;
                case 8:
                    tv_center.setText("9");
                    tv_top.setText("X");
                    tv_left.setText("W");
                    tv_right.setText("Y");
                    tv_bottom.setText("Z");
                    break;
            }
        }
    }

    public interface KeySelectIml {
        void keySelect(String key, boolean t9);

        void keyDelete(boolean t9);

        void keyClear(boolean t9);

        void onLayoutComplete(int width);
    }
}

