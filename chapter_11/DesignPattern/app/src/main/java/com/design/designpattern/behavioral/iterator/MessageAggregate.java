package com.design.designpattern.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体聚合类
 */
public class MessageAggregate implements Aggregate {
    private List<Object> list = new ArrayList<Object>();

    @Override
    public void add(Object obj) {
        list.add(obj);
    }

    @Override
    public void remove(Object obj) {
        list.remove(obj);
    }

    @Override
    public Iterator getIterator() {
        return new MessageIterator(list);
    }
}
