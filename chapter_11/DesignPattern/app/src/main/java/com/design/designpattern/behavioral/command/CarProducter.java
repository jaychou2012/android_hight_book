package com.design.designpattern.behavioral.command;

/**
 * 调用者
 */
public class CarProducter {
    private Car car;

    public CarProducter(Car car) {
        this.car = car;
    }

    public void product() {
        car.product();
    }
}
