package com.design.designpattern.behavioral.visitor;

/**
 * 抽象元素，声明接受哪一类访问者访问
 */
public interface Element {
    void accept(Visitor visitor);
}
