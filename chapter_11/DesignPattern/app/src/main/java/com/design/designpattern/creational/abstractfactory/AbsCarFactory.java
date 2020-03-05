package com.design.designpattern.creational.abstractfactory;

public class AbsCarFactory extends AbstractFactory {
    // 生产car
    @Override
    public Car getCar(String type) {
        if (type == null) {
            return null;
        }
        if (type.equalsIgnoreCase("AUDI")) {
            return new Audi();
        } else if (type.equalsIgnoreCase("BENZ")) {
            return new Benz();
        }
        return null;
    }

    //生产bus
    @Override
    public Bus getBus(String type) {
        return null;
    }
}
