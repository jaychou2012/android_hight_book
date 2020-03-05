package com.design.designpattern.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体的被观察者/目标
 */
public class AlertObserverable implements Observerable {
    private List<Observer> observers = new ArrayList<Observer>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver(Object object) {
        for (int i = 0; i < observers.size(); i++) {
            Observer oserver = observers.get(i);
            oserver.update(object.toString());
        }
    }
}
