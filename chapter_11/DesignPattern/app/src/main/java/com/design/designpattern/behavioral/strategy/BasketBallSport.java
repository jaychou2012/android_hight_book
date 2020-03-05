package com.design.designpattern.behavioral.strategy;

/**
 * 具体策略类
 */
public class BasketBallSport implements Sport {
    @Override
    public void sport() {
        System.out.println("具体策略：BasketBallSport的sport方法");
    }
}
