package com.design.designpattern.behavioral.mediator;

/**
 * 具体同事类
 */
public class MessageColleague extends Colleague {
    @Override
    public void receive(String message) {
        System.out.println("具体同事类MessageColleague收到信息：" + message);
    }

    @Override
    public void send(String message) {
        //请中介者转发消息
        mediator.relay(this, message);
    }
}
