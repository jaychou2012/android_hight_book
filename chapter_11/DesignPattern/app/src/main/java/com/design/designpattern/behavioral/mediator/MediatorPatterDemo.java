package com.design.designpattern.behavioral.mediator;


public class MediatorPatterDemo {
    public static void main(String[] args) {
        // 创建中介者
        Mediator mediator = new MessageMediator();

        // 创建2个同事类
        Colleague colleague1 = new MessageColleague();
        Colleague colleague2 = new MessageColleague();
        // 注册同事类
        mediator.register(colleague1);
        mediator.register(colleague2);
        // 发送消息
        colleague1.send("来自同事类1的消息");
        colleague2.send("来自同事类2的消息");
    }
}
