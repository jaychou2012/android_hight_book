package com.design.designpattern.behavioral.chain;

public class ChainPatterDemo {
    public static void main(String[] args) {
        //组装责任链
        Producter producter1 = new ProducterOne();
        Producter producter2 = new ProducterTwo();
        producter1.setNext(producter2);
        //提交请求
        producter1.product("two");
    }
}
