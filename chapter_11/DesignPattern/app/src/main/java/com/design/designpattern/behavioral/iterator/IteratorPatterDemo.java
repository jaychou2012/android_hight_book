package com.design.designpattern.behavioral.iterator;

public class IteratorPatterDemo {
    public static void main(String[] args) {
        // 创建聚合类
        Aggregate aggregate = new MessageAggregate();
        aggregate.add("消息1");
        aggregate.add("消息2");
        aggregate.add("消息3");
        //获取迭代器
        Iterator iterator = aggregate.getIterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            System.out.println("迭代消息：" + object.toString());
        }
    }
}
