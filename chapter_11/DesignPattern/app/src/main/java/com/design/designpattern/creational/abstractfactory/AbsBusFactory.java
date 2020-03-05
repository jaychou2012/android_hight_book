package com.design.designpattern.creational.abstractfactory;

public class AbsBusFactory extends AbstractFactory {
    // 生产car
    @Override
    public Car getCar(String type) {
        return null;
    }

    //生产bus
    @Override
    public Bus getBus(String type) {
        if (type == null) {
            return null;
        }
        if (type.equalsIgnoreCase("BIG")) {
            return new BigBus();
        } else if (type.equalsIgnoreCase("SMALL")) {
            return new SmallBus();
        }
        return null;
    }
}
