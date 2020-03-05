package com.design.designpattern.behavioral.state;

/**
 * 环境类
 */
public class ScoreContext {
    public final static LowState LOW_STATE = new LowState();
    public final static MiddleState MIDDLE_STATE = new MiddleState();
    public final static HightState HIGHT_STATE = new HightState();
    private ScoreState scoreState;

    public ScoreContext() {
        this.scoreState = LOW_STATE;
    }

    public void setState(ScoreState scoreState) {
        this.scoreState = scoreState;
    }

    public ScoreState getState() {
        return scoreState;
    }

    public void computeLevel(int score) {
        if (score < 60) {
            setState(LOW_STATE);
        } else if (score >= 60 && score < 80) {
            setState(MIDDLE_STATE);
        } else {
            setState(HIGHT_STATE);
        }
        this.scoreState.computeLevel(score);
    }
}
