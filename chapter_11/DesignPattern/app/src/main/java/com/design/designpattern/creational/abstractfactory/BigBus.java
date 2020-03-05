package com.design.designpattern.creational.abstractfactory;

import com.design.designpattern.creational.abstractfactory.Bus;

public class BigBus implements Bus {
    @Override
    public void run() {
        System.out.println("Inside BigBus:run() method");
    }
}
