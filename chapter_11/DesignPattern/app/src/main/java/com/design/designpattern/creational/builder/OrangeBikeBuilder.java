package com.design.designpattern.creational.builder;

public class OrangeBikeBuilder implements BikeBuilder {
    // 自动创建自行车对象
    Bike bike = new Bike();

    @Override
    public void buildTyres() {
        bike.setTyre("橙色轮胎");
    }

    @Override
    public void buildFrame() {
        bike.setFrame("橙色车架");
    }

    @Override
    public void buildColor() {
        bike.setColor("橙色");
    }

    @Override
    public Bike getBike() {
        return bike;
    }
}
