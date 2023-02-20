package com.jtli.practice.designmode.creative.abstractfactory;

/**
 * @Classname AbstractProductFactory
 * @Description <p>
 * 它强调了一系列相关产品对象（属于同一个产品族）的创建过程，
 * 它和工厂方法模式的侧重点不同，工厂方法模式更加侧重于同一产品等级，
 * 而抽象工厂模式侧重的是同一产品族。简单说就是一个工厂中生产的一系列对象都是同一个产品族的。
 * </p>
 * @Date 2023/2/19 11:19
 * @Author by jtlee
 * @Version 1.0.0
 */
public interface AbstractProductFactory {

    //生产手机
    IPhoneProduct phoneProduct();

    //生成路由器
    IRouterProduct routerProduct();
}
