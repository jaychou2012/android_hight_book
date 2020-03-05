package com.design.designpattern.behavioral.command;

/**
 * 具体命令
 */
public class AudiCar implements Car {
    //命令接收者
    private AudiProducter audiProducter;

    public AudiCar() {
        audiProducter = new AudiProducter();
    }

    @Override
    public void product() {
        audiProducter.product();
    }
}
