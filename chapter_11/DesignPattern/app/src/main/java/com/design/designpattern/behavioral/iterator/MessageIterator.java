package com.design.designpattern.behavioral.iterator;

import java.util.List;

/**
 * 具体迭代器
 */
public class MessageIterator implements Iterator {
    private List<Object> list = null;

    private int index = -1;

    public MessageIterator(List<Object> list) {
        this.list = list;
    }

    @Override
    public Object first() {
        index = 0;
        Object obj = list.get(index);
        return obj;
    }

    @Override
    public Object next() {
        Object obj = null;
        if (this.hasNext()) {
            obj = list.get(++index);
        }
        return obj;
    }

    @Override
    public boolean hasNext() {
        if (index < list.size() - 1) {
            return true;
        } else {
            return false;
        }
    }
}
