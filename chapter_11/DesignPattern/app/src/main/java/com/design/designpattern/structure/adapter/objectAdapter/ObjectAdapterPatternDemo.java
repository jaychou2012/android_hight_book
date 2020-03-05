package com.design.designpattern.structure.adapter.objectAdapter;


public class ObjectAdapterPatternDemo {
    public static void main(String[] args) {
        // 将220V电压转为通用5V电压
        PowerAdapter powerAdapter = new PowerAdapter(new AC220Adaptee());
        powerAdapter.output5V();
    }
}
