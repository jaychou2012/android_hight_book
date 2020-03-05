package com.design.designpattern.behavioral.command;

/**
 * 具体的接收命令对象
 */
public class AudiProducter implements Producter {
    @Override
    public void product() {
        System.out.println("AudiProducter开始生产AudiCar");
    }
}
