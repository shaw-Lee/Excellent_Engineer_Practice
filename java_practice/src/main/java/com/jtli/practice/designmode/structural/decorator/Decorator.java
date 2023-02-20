package com.jtli.practice.designmode.structural.decorator;

/**
 * @Classname Decorator
 * @Description <p>
 *      TODO
 * </p>
 * @Date 2023/2/20 20:45
 * @Author by jtlee
 * @Version 1.0.0
 */
public class Decorator extends Base {   //装饰者需要将装饰目标组合到类中

    protected Base base;

    public Decorator(Base base) {
        this.base = base;
    }

    @Override
    public void test() {
        base.test();    //这里暂时还是使用目标的原本方法实现
    }
}
