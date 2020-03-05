package com.design.designpattern.structure.flyweight;

/**
 * 非享元角色，不会复用，用于传递参数
 */
public class UnsharedCarInfo {
    private String info;

    public UnsharedCarInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
