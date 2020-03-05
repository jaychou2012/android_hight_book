package com.design.designpattern.behavioral.mediator;

/**
 * 抽象同事类
 */
public abstract class Colleague {
    protected Mediator mediator;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void receive(String message);

    public abstract void send(String message);
}
