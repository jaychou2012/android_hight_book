package com.design.designpattern.creational.factory;

import com.design.designpattern.creational.abstractfactory.Audi;
import com.design.designpattern.creational.abstractfactory.Benz;
import com.design.designpattern.creational.abstractfactory.Car;

public class CarFactory {
    //使用 getCar 方法获取Car类型的对象
    public Car getCar(String carType) {
        if (carType == null) {
            return null;
        }
        if (carType.equalsIgnoreCase("BENZ")) {
            return new Benz();
        } else if (carType.equalsIgnoreCase("AUDI")) {
            return new Audi();
        }
        return null;
    }
}
