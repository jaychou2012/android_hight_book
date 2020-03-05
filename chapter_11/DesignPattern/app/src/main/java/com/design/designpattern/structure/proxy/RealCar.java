package com.design.designpattern.structure.proxy;

/**
 * 真实主题
 */
public class RealCar implements Car {
    @Override
    public void product() {
        System.out.println("product: RealCar");
    }
}
