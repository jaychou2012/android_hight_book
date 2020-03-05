package com.design.designpattern.behavioral.command;

public class CommandPatternDemo {
    public static void main(String[] args) {
        // 命令
        Car audi = new AudiCar();
        Car benzi = new BenzCar();
        // 调用者
        CarProducter audiCarProducter = new CarProducter(audi);
        audiCarProducter.product();
        CarProducter benziCarProducter = new CarProducter(benzi);
        benziCarProducter.product();
    }
}
