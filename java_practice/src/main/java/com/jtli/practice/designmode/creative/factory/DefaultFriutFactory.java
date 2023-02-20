package com.jtli.practice.designmode.creative.factory;

/**
 * @Classname FriutFactory
 * @Description <p>
 * 不过这样还是有一些问题，我们前面提到了开闭原则，一个软件实体，比如类、模块和函数应该对扩展开放，对修改关闭，
 * 但是如果我们现在需要新增一种水果，比如桃子，那么这时我们就得去修改工厂提供的工厂方法了，
 * 但是这样是不太符合开闭原则的，因为工厂实际上是针对于调用方提供的，所以我们应该尽可能对修改关闭。
 * <p>
 * 所以，我们就利用对扩展开放，对修改关闭的性质，将简单工厂模式改进为工厂方法模式，那现在既然不让改，
 * 那么我们就看看如何去使用扩展的形式：
 * </p>
 * @Date 2023/2/19 10:48
 * @Author by jtlee
 * @Version 1.0.0
 */
public abstract class DefaultFriutFactory<T extends Fruit> {
    //通过工厂来屏蔽对象的创建细节，使用者只需要关心如何去使用对象即可。
    public abstract T getFruit();
}
