package com.jtli.practice.designmode.structural.decorator;

/**
 * @Classname DecoratorImpl
 * @Description <p>
 *      TODO
 * </p>
 * @Date 2023/2/20 20:46
 * @Author by jtlee
 * @Version 1.0.0
 */
public class DecoratorImpl extends Decorator {   //装饰实现

    public DecoratorImpl(Base base) {
        super(base);
    }

    @Override
    public void test() {    //对原本的方法进行装饰，我们可以在前后都去添加额外操作
        System.out.println("装饰方法：我是操作前逻辑");
        super.test();
        System.out.println("装饰方法：我是操作后逻辑");
    }
}