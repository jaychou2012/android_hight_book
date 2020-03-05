package com.design.designpattern.structure.flyweight;

public class FlyWeightPatternDemo {
    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();

        Car audi = carFactory.getCar("audi");
        Car benzi = carFactory.getCar("benzi");
        Car audi2 = carFactory.getCar("audi");

        audi.product(new UnsharedCarInfo("大汽车"));
        benzi.product(new UnsharedCarInfo("小汽车"));
        audi2.product(new UnsharedCarInfo("小汽车"));
    }
}
