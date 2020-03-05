package com.design.designpattern.creational.factory;

public class Benz implements Car {
    @Override
    public void run() {
        System.out.println("Inside SmallCar:run() method");
    }
}
