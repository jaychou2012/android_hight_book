package com.design.designpattern.behavioral.strategy;

public class StrategyPatternDemo {
    public static void main(String[] args) {
        SportStrategy sportStrategy = new SportStrategy(new BasketBallSport());
        sportStrategy.sport();

        sportStrategy = new SportStrategy(new RunSport());
        sportStrategy.sport();
    }
}
