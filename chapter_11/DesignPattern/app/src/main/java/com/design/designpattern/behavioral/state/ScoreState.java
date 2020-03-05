package com.design.designpattern.behavioral.state;

/**
 * 抽象状态类
 */
public abstract class ScoreState {

    //检查当前分数状态级别
    public abstract void computeLevel(int score);
}
