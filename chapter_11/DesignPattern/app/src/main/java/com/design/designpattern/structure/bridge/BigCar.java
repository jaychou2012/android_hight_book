package com.design.designpattern.structure.bridge;

/**
 * 扩展抽象化角色：大汽车
 */
public class BigCar extends Car {

    @Override
    public String getName() {
        return color.getColor() + " BigCar";
    }
}
