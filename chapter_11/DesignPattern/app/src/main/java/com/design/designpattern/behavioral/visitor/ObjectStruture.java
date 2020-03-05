package com.design.designpattern.behavioral.visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 结构对象集
 */
public class ObjectStruture {
    private List<Element> list = new ArrayList<Element>();

    public void accept(Visitor visitor) {
        for (Element element : list) {
            element.accept(visitor);
        }
    }

    public void add(Element element) {
        list.add(element);
    }

    public void remove(Element element) {
        list.remove(element);
    }
}
