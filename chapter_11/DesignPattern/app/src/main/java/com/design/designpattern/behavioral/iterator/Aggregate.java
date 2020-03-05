package com.design.designpattern.behavioral.iterator;

/**
 * 抽象聚合接口
 */
public interface  Aggregate {
    public void add(Object obj);
    public void remove(Object obj);
    public Iterator getIterator();
}
