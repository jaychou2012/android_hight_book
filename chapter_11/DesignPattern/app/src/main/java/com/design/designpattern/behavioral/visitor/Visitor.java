package com.design.designpattern.behavioral.visitor;

/**
 * 抽象访问者，声明访问者可以访问哪些元素
 */
public interface Visitor {
    void visit(ScoreElement element);
    void visit(InfoElement element);
}
