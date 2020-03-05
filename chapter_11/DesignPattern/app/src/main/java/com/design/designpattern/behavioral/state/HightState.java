package com.design.designpattern.behavioral.state;

/**
 * 具体状态类
 */
public class HightState extends ScoreState {
    @Override
    public void computeLevel(int score) {
        System.out.println("computeLevel:HightState  " + score);
    }
}
