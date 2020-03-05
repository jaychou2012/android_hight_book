package com.design.designpattern.structure.bridge;

public class BridgePatternDemo {
    public static void main(String[] args) {
        CarColor carColorBlue = new Blue();
        SmallCar smallCar = new SmallCar();
        smallCar.setCarColor(carColorBlue);
        String carName = smallCar.getName();
        System.out.print(carName);
    }
}
