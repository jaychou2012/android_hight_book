package com.design.designpattern.structure.facade;

/**
 * 子系统（Sub System）角色
 */
public class Audi implements Car {
    @Override
    public void run() {
        System.out.println("Inside BigCar:run() method");
    }
}
