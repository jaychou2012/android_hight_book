package com.design.designpattern.behavioral.state;

public class StatePatternDemo {
    public static void main(String[] args) {
        ScoreContext scoreContextLow = new ScoreContext();
        scoreContextLow.computeLevel(60);

        ScoreContext scoreContextHight = new ScoreContext();
        scoreContextHight.computeLevel(90);
    }
}
