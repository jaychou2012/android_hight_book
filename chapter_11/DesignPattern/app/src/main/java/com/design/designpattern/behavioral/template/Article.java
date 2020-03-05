package com.design.designpattern.behavioral.template;

/**
 * 定义抽象类
 */
public abstract class Article {
    //抽象方法
    abstract void writeTitle();

    abstract void writeContent();

    //具体方法,并不一定是抽象方法，如果需要具体方法，也可以写具体方法
    public void writeEnd() {
        System.out.println("抽象类中的具体方法被调用");
    }

    //模板，模板方法
    public final void write() {

        //写标题
        writeTitle();

        //写内容
        writeContent();

        //写结尾
        writeEnd();
    }
}
