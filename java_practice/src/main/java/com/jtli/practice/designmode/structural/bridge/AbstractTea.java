package com.jtli.practice.designmode.structural.bridge;

/**
 * @Classname AbstractTea
 * @Description <p>
 *      TODO
 * </p>
 * @Date 2023/2/20 20:06
 * @Author by jtlee
 * @Version 1.0.0
 */
public abstract class AbstractTea {

    protected Size size;   //尺寸作为桥接属性存放在类中

    protected AbstractTea(Size size){   //在构造时需要知道尺寸属性
        this.size = size;
    }

    public abstract String getType();   //具体类型依然是由子类决定
}
