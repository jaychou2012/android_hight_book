package com.design.designpattern.behavioral.visitor;

/**
 * 具体访问者
 */
public class StudentVisitor implements Visitor {

    @Override
    public void visit(ScoreElement element) {
        System.out.println("学生访问：输出学生所有学科成绩");
    }

    @Override
    public void visit(InfoElement element) {
        System.out.println("学生访问：输出学生所有信息");
    }
}
