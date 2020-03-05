package com.design.designpattern.structure.adapter.classAdapter;

public class ClassAdapterPatternDemo {
    public static void main(String[] args) {
        // 将220V电压转为通用5V电压
        DC5Target dc5Target = new PowerAdapter();
        dc5Target.output5V();
    }
}
