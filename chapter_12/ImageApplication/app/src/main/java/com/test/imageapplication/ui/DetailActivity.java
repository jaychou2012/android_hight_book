package com.test.imageapplication.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.test.imageapplication.R;
import com.test.imageapplication.base.BaseActivity;
import com.test.imageapplication.entity.Product;
import com.test.imageapplication.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_content)
    TextView tv_content;
    @BindView(R.id.iv_img)
    ImageView iv_img;
    private Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();
    }

    private void initView() {
        getSupportActionBar().setTitle("详情");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ButterKnife.bind(this);
        product = (Product) getIntent().getExtras().getSerializable(Utils.INTENT_KEY);
        Glide.with(this).load(product.getImageUrl()).into(iv_img);
        tv_title.setText(product.getTitle());
        tv_content.setText(product.getContent());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
