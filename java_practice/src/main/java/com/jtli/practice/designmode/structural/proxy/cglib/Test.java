package com.jtli.practice.designmode.structural.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @Classname Test
 * @Description <p>
 * Cglib代理也叫作子类代理，它使目标对象不需要实现接口，
 * 是在内存中构建一个子类对象从而实现对目标对象功能扩展，有的也将Cglib代理归属到动态代理。
 * <p>
 * Cglib是一个高性能的代码生成包，它可以在运行期扩展java类与实现java接口。
 * 被许多AOP的框架使用（如Spring AOP）。Cglib包的底层是通过使用字节码处理框架ASM来转换字节码并生成新的类。
 * <p>
 * 特别注意：代理的类不能为final，否则报错java.lang.IllegalArgumentException ，
 * 如果目标对象的方法如果为final或static，那么就不会被拦截（即不会执行目标对象额外的业务方法）。
 * </p>
 * @Date 2023/2/21 22:25
 * @Author by jtlee
 * @Version 1.0.0
 */
public class Test {
    public static void main(String[] args) {
        SubjectImpl subject = new SubjectImpl();

        Enhancer enhancer = new Enhancer();   //增强器，一会就需要依靠增强器来为我们生成动态代理对象
        enhancer.setSuperclass(SubjectImpl.class);    //直接选择我们需要代理的类型，直接不需要接口或是抽象类，SuperClass作为代理类的父类存在，这样我们就可以按照指定类型的方式去操作代理类了
        enhancer.setCallback(new TestProxy(subject));  //设定我们刚刚编写好的代理逻辑

        SubjectImpl proxy = (SubjectImpl) enhancer.create();   //直接创建代理类

        proxy.test();   //调用代理类的test方法
    }
}
