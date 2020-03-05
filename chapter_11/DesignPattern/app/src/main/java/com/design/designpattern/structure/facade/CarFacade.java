package com.design.designpattern.structure.facade;

/**
 * 外观（Facade）角色
 */
public class CarFacade {
    private Car benz;
    private Car audi;

    public CarFacade() {
        benz = new Benz();
        audi = new Audi();
    }

    public void benzRun() {
        benz.run();
    }

    public void audiRun() {
        audi.run();
    }
}
