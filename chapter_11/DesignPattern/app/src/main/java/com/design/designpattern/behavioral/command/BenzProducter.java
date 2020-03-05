package com.design.designpattern.behavioral.command;

/**
 * 具体的接收命令对象
 */
public class BenzProducter implements Producter {
    @Override
    public void product() {
        System.out.println("BenzProducter开始生产BenzCar");
    }
}
