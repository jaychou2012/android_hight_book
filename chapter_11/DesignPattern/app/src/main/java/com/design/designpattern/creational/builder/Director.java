package com.design.designpattern.creational.builder;

public class Director {
    BikeBuilder bikeBuilder;

    public Director(BikeBuilder bikeBuilder) {
        this.bikeBuilder = bikeBuilder;
    }

    // 开始生产自行车
    public Bike construct() {
        bikeBuilder.buildTyres();
        bikeBuilder.buildFrame();
        bikeBuilder.buildColor();
        return bikeBuilder.getBike();
    }
}
