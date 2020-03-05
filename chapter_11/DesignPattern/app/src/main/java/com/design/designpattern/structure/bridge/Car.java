package com.design.designpattern.structure.bridge;

/**
 * 抽象化角色：汽车
 */
public abstract class Car {
    protected CarColor color;

    public void setCarColor(CarColor color) {
        this.color = color;
    }

    public void run() {
    }

    public abstract String getName();
}
