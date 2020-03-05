package com.design.designpattern.creational.abstractfactory;

public abstract class AbstractFactory {
    public abstract Car getCar(String type);

    public abstract Bus getBus(String type);
}
