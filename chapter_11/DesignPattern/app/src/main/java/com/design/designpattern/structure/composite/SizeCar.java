package com.design.designpattern.structure.composite;

import java.util.ArrayList;

/**
 * 树枝构件
 */
public class SizeCar implements Car {
    private ArrayList<Car> children = new ArrayList<Car>();

    @Override
    public void add(Car car) {
        children.add(car);
    }

    @Override
    public void remove(Car car) {
        children.remove(car);
    }

    @Override
    public Car getChild(int i) {
        return children.get(i);
    }

    @Override
    public void product() {
        for (Object obj : children) {
            ((Car) obj).product();
        }
    }
}
