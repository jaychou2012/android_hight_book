package com.design.designpattern.behavioral.observer;

/**
 * 具体观察者
 */
public class AlertObserver implements Observer {
    @Override
    public void update(String message) {
        System.out.println("收到更新：" + message);
    }
}
