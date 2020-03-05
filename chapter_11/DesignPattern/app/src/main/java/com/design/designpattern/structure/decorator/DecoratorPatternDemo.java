package com.design.designpattern.structure.decorator;

public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Car bigCar = new BigCar();
        Car sizeCarBig = new SizeCarDecorator(bigCar);
        Car sizeCarSmall = new SizeCarDecorator(new SmallCar());
        sizeCarBig.run();
        sizeCarSmall.run();
    }
}
