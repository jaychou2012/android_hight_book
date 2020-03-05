package com.design.designpattern.behavioral.strategy;

/**
 * 具体策略类
 */
public class RunSport implements Sport {
    @Override
    public void sport() {
        System.out.println("具体策略：RunSport的sport方法");
    }
}
