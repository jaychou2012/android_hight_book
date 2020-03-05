package com.design.designpattern.behavioral.mediator;

/**
 * 抽象中介者
 */
public abstract class Mediator {

    public abstract void register(Colleague colleague);

    public abstract void relay(Colleague cl,String message); //转发
}
