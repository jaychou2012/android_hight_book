package com.design.designpattern.structure.flyweight;

/**
 * 具体享元角色
 */
public class BigCar implements Car {
    private String key;

    public BigCar(String key) {
        this.key = key;
        System.out.println("具体享元:" + key + "被创建");
    }

    @Override
    public void product(UnsharedCarInfo unsharedCarInfo) {
        System.out.println("具体享元方法:product");
    }
}
