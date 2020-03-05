package com.design.designpattern.behavioral.chain;

/**
 * 抽象处理者角色
 */
public abstract class Producter {

    private Producter next;

    public void setNext(Producter next) {
        this.next = next;
    }

    public Producter getNext() {
        return next;
    }

    //处理请求的方法
    public abstract void product(String request);
}
