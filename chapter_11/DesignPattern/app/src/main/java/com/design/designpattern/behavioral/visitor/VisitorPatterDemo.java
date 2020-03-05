package com.design.designpattern.behavioral.visitor;

public class VisitorPatterDemo {
    public static void main(String[] args) {
        // 创建结构数据集
        ObjectStruture objectStruture = new ObjectStruture();
        objectStruture.add(new ScoreElement());
        objectStruture.add(new InfoElement());
        // 创建访问者角色
        Visitor teacherVisitor = new TeacherVisitor();
        Visitor studentVisitor = new StudentVisitor();

        objectStruture.accept(teacherVisitor);
        objectStruture.accept(studentVisitor);
    }
}
