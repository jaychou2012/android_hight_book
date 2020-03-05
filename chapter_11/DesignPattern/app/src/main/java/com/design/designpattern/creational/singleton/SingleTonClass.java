package com.design.designpattern.creational.singleton;

//public class SingleTonClass {
//
//    //创建 SingleTonClass 的一个对象
//    private static SingleTonClass instance = new SingleTonClass();
//
//    //让构造函数为 private，这样该类就不会被实例化
//    private SingleTonClass(){}
//
//    //获取单例对象
//    public static SingleTonClass getInstance(){
//        return instance;
//    }
//    //编写类里的方法
//    public void showMethod(){
//        System.out.println("Hello World!");
//    }
//}

//懒汉式加载，多线程不安全，没有加锁 synchronized，不过性能高一些
//public class SingleTonClass {
//    private static SingleTonClass instance;
//
//    private SingleTonClass() {
//    }
//
//    public static SingleTonClass getInstance() {
//        if (instance == null) {
//            instance = new SingleTonClass();
//        }
//        return instance;
//    }
//}

//懒汉式加载，多线程安全，加锁 synchronized，但加锁会影响效率，效率很低，大部分情况下不需要同步
//public class SingleTonClass {
//    private static SingleTonClass instance;
//
//    private SingleTonClass() {
//    }
//
//    public static synchronized SingleTonClass getInstance() {
//        if (instance == null) {
//            instance = new SingleTonClass();
//        }
//        return instance;
//    }
//}

// 饿汉式
//public class SingleTonClass {
//    private static SingleTonClass instance = new SingleTonClass();
//
//    private SingleTonClass() {
//    }
//
//    public static SingleTonClass getInstance() {
//        return instance;
//    }
//}

// 双重校验锁，多线程安全，并可以保持高性能
//public class SingleTonClass {
//    private volatile static SingleTonClass singleton;
//
//    private SingleTonClass() {
//    }
//
//    public static SingleTonClass getSingleton() {
//        if (singleton == null) {
//            synchronized (SingleTonClass.class) {
//                if (singleton == null) {
//                    singleton = new SingleTonClass();
//                }
//            }
//        }
//        return singleton;
//    }
//}

// 静态内部类
//public class SingleTonClass {
//    private static class SingletonHolder {
//        private static final SingleTonClass INSTANCE = new SingleTonClass();
//    }
//    private SingleTonClass (){}
//    public static final SingleTonClass getInstance() {
//        return SingletonHolder.INSTANCE;
//    }
//}

public enum SingleTonClass {
    INSTANCE;

    public void showMethod() {
    }
}