package com.jtli.practice.designmode.creative.factory;

/**
 * @Classname Fruit
 * @Description <p>
 *      TODO
 * </p>
 * @Date 2023/2/19 10:30
 * @Author by jtlee
 * @Version 1.0.0
 */
public abstract class Fruit {
    private final  String name;

    protected Fruit(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name+"@"+hashCode();   //打印一下当前水果名称，还有对象的hashCode
    }
}
