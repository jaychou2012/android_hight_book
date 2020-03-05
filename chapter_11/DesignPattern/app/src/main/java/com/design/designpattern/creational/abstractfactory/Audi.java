package com.design.designpattern.creational.abstractfactory;

public class Audi implements Car {
    @Override
    public void run() {
        System.out.println("Inside BigCar:run() method");
    }
}
