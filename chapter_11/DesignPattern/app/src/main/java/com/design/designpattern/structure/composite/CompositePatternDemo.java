package com.design.designpattern.structure.composite;

public class CompositePatternDemo {
    public static void main(String[] args) {
        Car c0 = new SizeCar();
        Car c1 = new SizeCar();
        Car leaf1 = new BigCar("audi");
        Car leaf2 = new BigCar("benz");
        Car leaf3 = new BigCar("hongqi");
        c0.add(leaf1);
        c0.add(c1);
        c1.add(leaf2);
        c1.add(leaf3);
        c0.product();
    }
}
