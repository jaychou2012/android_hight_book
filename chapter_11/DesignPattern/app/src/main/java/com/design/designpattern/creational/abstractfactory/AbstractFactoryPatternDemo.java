package com.design.designpattern.creational.abstractfactory;

public class AbstractFactoryPatternDemo {

    public static void main(String[] args) {

        //获取Car工厂
        AbstractFactory carFactory = AbsFactory.getFactory("CAR");

        //获取Car为 AUDI 的对象
        Car car = carFactory.getCar("AUDI");

        car.run();

        //获取Bus工厂
        AbstractFactory busFactory = AbsFactory.getFactory("BUS");

        //获取Bus为 big 的对象
        Bus bus1 = busFactory.getBus("BIG");

        //调用 bus 的 run 方法
        bus1.run();
    }
}
