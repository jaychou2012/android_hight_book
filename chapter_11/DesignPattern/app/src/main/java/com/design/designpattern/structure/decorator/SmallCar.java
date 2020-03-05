package com.design.designpattern.structure.decorator;


/**
 * 具体构件角色
 */
public class SmallCar implements Car {
    @Override
    public void run() {
        System.out.println("Inside SmallCar:run() method");
    }
}
