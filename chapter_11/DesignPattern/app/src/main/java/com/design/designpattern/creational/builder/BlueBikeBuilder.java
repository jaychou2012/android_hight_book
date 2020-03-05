package com.design.designpattern.creational.builder;

public class BlueBikeBuilder implements BikeBuilder {
    // 自动创建自行车对象
    Bike bike = new Bike();

    @Override
    public void buildTyres() {
        bike.setTyre("蓝色轮胎");
    }

    @Override
    public void buildFrame() {
        bike.setFrame("蓝色车架");
    }

    @Override
    public void buildColor() {
        bike.setColor("蓝色");
    }

    @Override
    public Bike getBike() {
        return bike;
    }
}
