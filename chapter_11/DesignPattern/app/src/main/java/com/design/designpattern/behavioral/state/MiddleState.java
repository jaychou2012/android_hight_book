package com.design.designpattern.behavioral.state;

/**
 * 具体状态类
 */
public class MiddleState extends ScoreState {
    @Override
    public void computeLevel(int score) {
        System.out.println("computeLevel:MiddleState  " + score);
    }
}
