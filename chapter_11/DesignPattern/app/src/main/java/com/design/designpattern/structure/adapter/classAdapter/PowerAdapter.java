package com.design.designpattern.structure.adapter.classAdapter;

public class PowerAdapter extends AC220Adaptee implements DC5Target {

    @Override
    public int output5V() {
        int output = output220V();
        return (output / 44);
    }
}
