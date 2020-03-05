package com.design.designpattern.behavioral.chain;

/**
 * 具体处理者角色
 */
public class ProducterTwo extends Producter {
    @Override
    public void product(String request) {
        if (request.equals("two")) {
            System.out.println("ProducterTwo负责处理该请求");
        } else {
            if (getNext() != null) {
                getNext().product(request);
            } else {
                System.out.println("没有人处理该请求");
            }
        }
    }
}
