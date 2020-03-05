package com.design.designpattern.behavioral.memento;

/**
 * 备忘录角色
 */
public class StudentMemento {
    private String name;
    private int age;

    public StudentMemento(Student student) {
        this.name = student.getName();
        this.age = student.getAge();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
