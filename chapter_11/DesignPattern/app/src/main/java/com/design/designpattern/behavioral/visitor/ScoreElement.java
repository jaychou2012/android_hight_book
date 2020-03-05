package com.design.designpattern.behavioral.visitor;

/**
 * 具体元素类
 */
public class ScoreElement implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
