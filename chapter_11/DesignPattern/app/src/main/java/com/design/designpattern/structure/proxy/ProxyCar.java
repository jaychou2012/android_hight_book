package com.design.designpattern.structure.proxy;

/**
 * 代理
 */
public class ProxyCar implements Car {
    private Car realCar;

    public ProxyCar(Car car) {
        this.realCar = car;
    }

    @Override
    public void product() {
        if (realCar == null) {
            realCar = new RealCar();
        }
        preRequest();
        realCar.product();
        postRequest();
    }

    private void preRequest() {
        System.out.println("预处理");
    }

    private void postRequest() {
        System.out.println("后续处理");
    }
}
