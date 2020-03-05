package com.design.designpattern.creational.abstractfactory;

import com.design.designpattern.creational.abstractfactory.Bus;

public class SmallBus implements Bus {
    @Override
    public void run() {
        System.out.println("Inside SmallBus:run() method");
    }
}
