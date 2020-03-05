package com.design.designpattern.structure.composite;

/**
 * 树叶构件
 */
public class BigCar implements Car {

    private String name;

    public BigCar(String name) {
        this.name = name;
    }

    @Override
    public void add(Car car) {

    }

    @Override
    public void remove(Car car) {

    }

    @Override
    public Car getChild(int i) {
        return null;
    }

    @Override
    public void product() {
        System.out.println("树叶" + name + "：被生产");
    }
}
