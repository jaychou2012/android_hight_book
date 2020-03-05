package com.design.designpattern.behavioral.memento;

/**
 * 管理者角色
 */
public class StudentCareTaker {
    private StudentMemento studentMemento;

    public StudentMemento getStudentMemento() {
        return studentMemento;
    }

    public void setStudentMemento(StudentMemento studentMemento) {
        this.studentMemento = studentMemento;
    }
}
