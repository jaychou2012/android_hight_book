package com.design.designpattern.behavioral.state;

/**
 * 具体状态类
 */
public class LowState extends ScoreState {
    @Override
    public void computeLevel(int score) {
        System.out.println("computeLevel:LowState  " + score);
    }
}
