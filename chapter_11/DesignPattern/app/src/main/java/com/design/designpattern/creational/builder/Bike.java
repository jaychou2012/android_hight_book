package com.design.designpattern.creational.builder;

public class Bike {
    // 颜色
    private String color;
    // 轮胎
    private String tyre;
    // 车架
    private String frame;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTyre() {
        return tyre;
    }

    public void setTyre(String tyre) {
        this.tyre = tyre;
    }

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }
}
