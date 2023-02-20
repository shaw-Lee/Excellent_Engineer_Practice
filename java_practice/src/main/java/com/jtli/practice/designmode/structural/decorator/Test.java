package com.jtli.practice.designmode.structural.decorator;

/**
 * @Classname Test
 * @Description <p>
 * 装饰器（Decorator）模式的定义：指在不改变现有对象结构的情况下，
 * 动态地给该对象增加一些职责（即增加其额外功能）的模式，它属于对象结构型模式。
 * <p>
 * 装饰器模式的主要优点有：
 * <p>
 * 装饰器是继承的有力补充，比继承灵活，在不改变原有对象的情况下，动态的给一个对象扩展功能，即插即用
 * 通过使用不用装饰类及这些装饰类的排列组合，可以实现不同效果
 * 装饰器模式完全遵守开闭原则
 * 其主要缺点是：装饰器模式会增加许多子类，过度使用会增加程序得复杂性。
 * </p>
 * @Date 2023/2/20 20:46
 * @Author by jtlee
 * @Version 1.0.0
 */
public class Test {

    public static void main(String[] args) {
        Base base = new BaseImpl();
        Decorator decorator = new DecoratorImpl(base);  //将Base实现装饰一下
        Decorator outer = new DecoratorImpl(decorator);  //装饰者还可以嵌套

        decorator.test();

        outer.test();
    }
}
