package com.design.designpattern.structure.composite;

/**
 * 抽象构件
 */

public interface Car {
    void add(Car car);

    void remove(Car car);

    Car getChild(int i);

    void product();
}
