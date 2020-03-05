package com.design.designpattern.structure.proxy;

public class ProxyPatternDemo {
    public static void main(String[] args) {
        ProxyCar proxyCar = new ProxyCar(new RealCar());
        proxyCar.product();
    }
}
