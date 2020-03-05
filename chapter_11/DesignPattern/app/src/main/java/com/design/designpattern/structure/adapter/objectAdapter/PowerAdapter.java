package com.design.designpattern.structure.adapter.objectAdapter;

import com.design.designpattern.structure.adapter.classAdapter.DC5Target;

public class PowerAdapter implements DC5Target {
    private AC220Adaptee ac220Adaptee;

    public PowerAdapter(AC220Adaptee ac220Adaptee) {
        this.ac220Adaptee = ac220Adaptee;
    }

    @Override
    public int output5V() {
        int output = 0;
        if (ac220Adaptee != null) {
            output = ac220Adaptee.output220V() / 44;
        }
        return output;
    }
}
