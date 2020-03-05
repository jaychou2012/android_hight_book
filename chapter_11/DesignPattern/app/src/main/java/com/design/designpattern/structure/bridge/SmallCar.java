package com.design.designpattern.structure.bridge;

/**
 * 扩展抽象化角色：小汽车
 */
public class SmallCar extends Car {

    @Override
    public String getName() {
        return color.getColor() + " SmallCar";
    }
}
