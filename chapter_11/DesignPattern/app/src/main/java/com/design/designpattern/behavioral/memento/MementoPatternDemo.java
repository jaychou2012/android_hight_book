package com.design.designpattern.behavioral.memento;

public class MementoPatternDemo {
    public static void main(String[] args) {
        // 创建备忘录管理者
        StudentCareTaker studentCareTaker = new StudentCareTaker();
        // 创建发起者
        Student student = new Student("小明", 18);
        studentCareTaker.setStudentMemento(student.memento());//进行备忘
        // 修改值状态
        student.setAge(20);
        // 进行恢复备忘
        student.recovery(studentCareTaker.getStudentMemento());
    }
}
