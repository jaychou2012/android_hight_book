package com.design.designpattern.behavioral.memento;

/**
 * 发起者角色
 */
public class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public StudentMemento memento() {
        return new StudentMemento(this);
    }

    //进行数据恢复，恢复成备忘录中对象的值
    public void recovery(StudentMemento studentMemento) {
        this.name = studentMemento.getName();
        this.age = studentMemento.getAge();
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
