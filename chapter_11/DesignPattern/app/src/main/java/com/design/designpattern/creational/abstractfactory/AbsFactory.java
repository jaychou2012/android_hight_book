package com.design.designpattern.creational.abstractfactory;

public class AbsFactory {
    public static AbstractFactory getFactory(String type) {
        if (type.equalsIgnoreCase("CAR")) {
            return new AbsCarFactory();
        } else if (type.equalsIgnoreCase("BUS")) {
            return new AbsBusFactory();
        }
        return null;
    }
}
