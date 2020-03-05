package com.design.designpattern.behavioral.interpreter;

/**
 * 定义文法规则
 * <expression> ::= <year>的<degree>
 * <year> ::=2年工作经验|3年工作经验
 * <degree> ::= 硕士|博士|博士后
 */
public class InterpreterPatternDemo {
    public static void main(String[] args) {
        // 创建解释器环境类
        InterpreterContext interpreterContext = new InterpreterContext();
        // 添加语句
        interpreterContext.canWork("2年工作经验的硕士");
        interpreterContext.canWork("2年工作经验的博士");
        interpreterContext.canWork("3年工作经验的博士后");
        interpreterContext.canWork("1年工作经验的博士后");
        interpreterContext.canWork("1年工作经验的博士");
    }
}
