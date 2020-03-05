package com.design.designpattern.creational.singleton;

public class SingleTonDemo {
    public static void main(String[] args) {
        //不可以通过new关键字来创建对象了，因为是私有的
        //SingleTonClass singleTonClass = new SingleTonClass();

        //实例化获取单例对象
        SingleTonClass singleTonClass = SingleTonClass.getInstance();

        //调用方法
        singleTonClass.showMethod();
    }
}
