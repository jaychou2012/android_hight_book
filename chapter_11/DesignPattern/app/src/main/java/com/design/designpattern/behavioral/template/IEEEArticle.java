package com.design.designpattern.behavioral.template;

/**
 * 具体子类
 */
public class IEEEArticle extends Article {
    //实现抽象方法，如果需要把具体方法重写也可以
    @Override
    void writeTitle() {
        System.out.println("writeTitle");
    }

    @Override
    void writeContent() {
        System.out.println("writeContent");
    }
}
