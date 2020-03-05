package com.design.designpattern.structure.adapter.interfaceAdapter;


/**
 * 定义电压输出接口
 */
public interface DCOutput {
    int output5V();

    int output8V();

    int output9V();

    int output12V();

    int output24V();
}
