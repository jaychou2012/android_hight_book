package com.design.designpattern.structure.decorator;

/**
 * 抽象装饰角色
 */
public class CarDecorator implements Car {
    private Car car;

    public CarDecorator(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        car.run();
    }
}
