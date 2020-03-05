package com.design.designpattern.creational.abstractfactory;

public class Benz implements Car {
    @Override
    public void run() {
        System.out.println("Inside SmallCar:run() method");
    }
}
