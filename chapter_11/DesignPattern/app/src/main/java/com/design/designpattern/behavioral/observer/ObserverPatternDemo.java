package com.design.designpattern.behavioral.observer;

public class ObserverPatternDemo {

    public static void main(String[] args) {
        // 创建被观察者/目标
        Observerable observerable = new AlertObserverable();

        // 创建2个观察者
        Observer observer1 = new AlertObserver();
        Observer observer2 = new AlertObserver();
        // 注册观察者
        observerable.registerObserver(observer1);
        observerable.registerObserver(observer2);

        // 通知更新
        observerable.notifyObserver("内容更新了");

        // 解除观察者注册
        observerable.removeObserver(observer1);
        observerable.removeObserver(observer2);
    }
}
