package com.design.designpattern.creational.factory;

import com.design.designpattern.creational.abstractfactory.Car;

public class FactoryPatternDemo {
    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();

        //获取 BigCar 的对象，并调用它的 run 方法
        Car car1 = carFactory.getCar("AUDI");

        //调用 BigCar 的 run 方法
        car1.run();

        //获取 SmallCar 的对象，并调用它的 run 方法
        Car car2 = carFactory.getCar("BENZ");

        //调用 SmallCar 的 run 方法
        car2.run();

    }
}
