package com.design.designpattern.creational.prototype;

public class ProtoTypePatternDemo {
    public static void main(String[] args) {
        Benz benz1 = new Benz();
        benz1.setId("1");
        benz1.setType("BENZ");

        Benz benz2 = (Benz) benz1.clone();
        // 返回值相等
        System.out.println("benz1Type：" + benz1.getType() + ",benz2Type：" + benz2.getType());
        // 返回false，克隆对象和原对象不是同一个对象
        System.out.println("obj1==obj2?" + (benz1 == benz1));
        // 返回true，克隆对象与原对象的类型一样
        System.out.println(benz1.getClass() == benz2.getClass());
    }
}
