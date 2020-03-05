package com.design.designpattern.behavioral.template;

public class TemplateMethodPatternDemo {
    public static void main(String[] args) {
        Article article = new IEEEArticle();
        article.write();
    }
}
