package com.design.designpattern.behavioral.observer;

/**
 * 定义被观察者/目标的抽象接口
 */
public interface Observerable {

    public void registerObserver(Observer o);

    public void removeObserver(Observer o);

    public void notifyObserver(Object object);
}
