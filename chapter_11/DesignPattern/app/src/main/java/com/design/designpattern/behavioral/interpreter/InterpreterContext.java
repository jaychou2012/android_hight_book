package com.design.designpattern.behavioral.interpreter;

/**
 * 环境类
 */
public class InterpreterContext {

    private String[] years = {"2年工作经验", "3年工作经验"};
    private String[] degrees = {"硕士", "博士", "博士后"};
    private Expression yearDegree;

    public InterpreterContext() {
        Expression year = new TerminalExpression(years);
        Expression degree = new TerminalExpression(degrees);
        yearDegree = new AndExpression(year, degree);
    }

    public void canWork(String info) {
        boolean ok = yearDegree.interpret(info);
        if (ok) {
            System.out.println("您是" + info + "，可以胜任本工作");
        } else {
            System.out.println(info + "，您暂时未满足要求");
        }
    }
}
