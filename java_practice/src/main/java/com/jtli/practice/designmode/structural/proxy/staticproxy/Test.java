package com.jtli.practice.designmode.structural.proxy.staticproxy;

/**
 * @Classname Test
 * @Description <p>
 *      TODO
 * </p>
 * @Date 2023/2/21 20:22
 * @Author by jtlee
 * @Version 1.0.0
 */
public class Test {
}

interface Subject {
    void test();
}

class SubjectImpl implements Subject {

    @Override
    public void test() {
        System.out.println("执行目标方法");
    }
}

class SubjectProxy implements Subject {
    private Subject proxy;

    public SubjectProxy(Subject subject) {
        this.proxy = subject;
    }

    @Override
    public void test() {
        System.out.println("目标方法前置");
        proxy.test();
        System.out.println("目标方法后置");
    }
}