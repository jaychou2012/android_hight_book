package com.design.designpattern.creational.builder;

public interface BikeBuilder {
    // 组装轮胎
    void buildTyres();

    // 组装车架
    void buildFrame();

    // 喷涂颜色
    void buildColor();

    // 生产出自行车
    Bike getBike();
}
