package com.design.designpattern.structure.flyweight;

import java.util.HashMap;

/**
 * 享元工厂角色
 */
public class CarFactory {
    private final HashMap<String, Car> carHashMap = new HashMap<>();

    public Car getCar(String key) {
        Car car = carHashMap.get(key);
        if (car == null) {
            car = new BigCar(key);
            carHashMap.put(key, car);
        } else {
            System.out.println("具体享元" + key + "已经存在，无需创建");
        }
        return car;
    }
}
