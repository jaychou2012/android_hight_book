package com.design.designpattern.structure.decorator;

/**
 * 具体装饰角色
 */
public class SizeCarDecorator extends CarDecorator {

    public SizeCarDecorator(Car car) {
        super(car);
    }

    @Override
    public void run() {
        super.run();
        addFunction();
    }

    public void addFunction() {
        System.out.println("增加扩展功能，也可以修改功能");
    }
}
