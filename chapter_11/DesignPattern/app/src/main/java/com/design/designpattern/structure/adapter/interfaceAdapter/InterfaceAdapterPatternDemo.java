package com.design.designpattern.structure.adapter.interfaceAdapter;

public class InterfaceAdapterPatternDemo {
    public static void main(String[] args) {
        // 将220V电压转为通用5V电压
        DCOutput dcOutput5 = new Power5VAdapter();
        dcOutput5.output5V();
        // 将220V电压转为通用5V和8V电压
        DCOutput dcOutput58 = new Power5V8VAdapter();
        dcOutput58.output5V();
        dcOutput58.output8V();
    }
}
