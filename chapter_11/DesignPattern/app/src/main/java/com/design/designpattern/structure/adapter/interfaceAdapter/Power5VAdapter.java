package com.design.designpattern.structure.adapter.interfaceAdapter;

/**
 * 提供5V电压适配输出服务
 */
public class Power5VAdapter extends PowerAdapter {

    @Override
    public int output5V() {
        return 5;
    }
}
