package com.design.designpattern.structure.decorator;

/**
 * 具体构件角色
 */
public class BigCar implements Car {
    @Override
    public void run() {
        System.out.println("Inside BigCar:run() method");
    }
}
