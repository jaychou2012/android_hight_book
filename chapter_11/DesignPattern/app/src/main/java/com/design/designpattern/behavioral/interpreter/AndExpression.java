package com.design.designpattern.behavioral.interpreter;

/**
 * 非终结符表达式类
 */
public class AndExpression implements Expression {
    private Expression year = null;
    private Expression degree = null;

    public AndExpression(Expression year, Expression degree) {
        this.year = year;
        this.degree = degree;
    }

    public boolean interpret(String info) {
        String s[] = info.split("的");
        return year.interpret(s[0]) && degree.interpret(s[1]);
    }
}
