package com.jtli.practice.designmode.structural.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Classname Test
 * @Description <p>
 * 定义：为其他对象提供一种代理以控制对这个对象的访问
 * 代理模式为一个对象提供了一个替身，以控制对这个对象的访问。即通过代理对象访问目标目标对象，
 * 可以在目标对象实现的基础上，增强额外的功能操作，即扩展目标对象的功能。
 * </p>
 * @Date 2023/2/21 20:15
 * @Author by jtlee
 * @Version 1.0.0
 */
public class Test {
    public static void main(String[] args) {
        SubjectImpl subject = new SubjectImpl();   //被代理的大冤种
        InvocationHandler handler = new SubjectProxy(subject);
        Subject proxy = (Subject) Proxy.newProxyInstance(
                subject.getClass().getClassLoader(),    //需要传入被代理的类的类加载器
                subject.getClass().getInterfaces(),    //需要传入被代理的类的接口列表
                handler);    //最后传入我们实现的代理处理逻辑实现类
        proxy.test();    //比如现在我们调用代理类的test方法，那么就会进入到我们上面TestProxy中invoke方法，走我们的代理逻辑
    }
}
