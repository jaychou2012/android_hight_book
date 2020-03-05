package com.design.designpattern.behavioral.command;

/**
 * 具体命令
 */
public class BenzCar implements Car {
    //命令接收者
    private BenzProducter benzProducter;

    public BenzCar() {
        benzProducter = new BenzProducter();
    }

    @Override
    public void product() {
        benzProducter.product();
    }
}
