package com.design.designpattern.behavioral.strategy;

/**
 * 环境类
 */
public class SportStrategy {
    private Sport sport;

    public SportStrategy(Sport sport) {
        this.sport = sport;
    }

    public void sport() {
        sport.sport();
    }
}
