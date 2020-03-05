package com.design.designpattern.behavioral.visitor;

/**
 * 具体访问者
 */
public class TeacherVisitor implements Visitor {

    @Override
    public void visit(ScoreElement element) {
        System.out.println("教师访问：输出学生当前老师学科成绩");
    }

    @Override
    public void visit(InfoElement element) {
        System.out.println("教师访问：学生部分信息");
    }
}
