package com.design.designpattern.structure.adapter.interfaceAdapter;

/**
 * 定义抽象类实现电压输出接口，但是什么事情都不做
 */
public abstract class PowerAdapter implements DCOutput {
    @Override
    public int output5V() {
        return 0;
    }

    @Override
    public int output8V() {
        return 0;
    }

    @Override
    public int output9V() {
        return 0;
    }

    @Override
    public int output12V() {
        return 0;
    }

    @Override
    public int output24V() {
        return 0;
    }
}
