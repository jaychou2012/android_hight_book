package com.design.designpattern.creational.builder;

public class BuilderPatternDemo {
    public static void main(String[] args) {
        // 生产蓝色自行车
        BikeBuilder blueBikeBuilder = new BlueBikeBuilder();
        Director director1 = new Director(blueBikeBuilder);
        Bike bike1 = director1.construct();

        //  生产橙色自行车
        BikeBuilder orangeBikeBuilder = new OrangeBikeBuilder();
        Director director2 = new Director(orangeBikeBuilder);
        director2.construct();
        Bike bike2 = director2.construct();
    }
}
