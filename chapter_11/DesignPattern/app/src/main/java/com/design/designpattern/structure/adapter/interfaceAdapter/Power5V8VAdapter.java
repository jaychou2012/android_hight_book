package com.design.designpattern.structure.adapter.interfaceAdapter;

/**
 * 提供5V和8V电压适配输出服务
 */
public class Power5V8VAdapter extends PowerAdapter {

    @Override
    public int output5V() {
        return 5;
    }

    @Override
    public int output8V() {
        return 8;
    }
}
