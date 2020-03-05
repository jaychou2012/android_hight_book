package com.test.imageapplication.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.test.imageapplication.R;
import com.test.imageapplication.adapter.ItemAdapter;
import com.test.imageapplication.base.BaseActivity;
import com.test.imageapplication.entity.Product;
import com.test.imageapplication.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements ItemAdapter.ItemClickListener {
    @BindView(R.id.rv)
    RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private ItemAdapter itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        ButterKnife.bind(this);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        itemAdapter = new ItemAdapter(this, Utils.getList(this));
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(itemAdapter);
        itemAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(int position, Product product) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(Utils.INTENT_KEY, product);
        startActivity(intent);
    }
}
