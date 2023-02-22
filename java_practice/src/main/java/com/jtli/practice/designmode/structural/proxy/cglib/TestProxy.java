package com.jtli.practice.designmode.structural.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Classname TestProxy
 * @Description <p>
 *      TODO
 * </p>
 * @Date 2023/2/21 22:23
 * @Author by jtlee
 * @Version 1.0.0
 */
public class TestProxy implements MethodInterceptor {
    private final Object target;   //这些和之前JDK动态代理写法是一样的

    public TestProxy(Object target) {
        this.target = target;
    }

    @Override   //我们也是需要在这里去编写我们的代理逻辑
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("现在是由CGLib进行代理操作！"+o.getClass());
        return method.invoke(target, objects);   //也是直接调用代理对象的方法即可
    }
}
