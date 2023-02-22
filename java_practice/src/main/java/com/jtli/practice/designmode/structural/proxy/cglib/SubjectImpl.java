package com.jtli.practice.designmode.structural.proxy.cglib;

/**
 * @Classname SubjectImpl
 * @Description <p>
 *      TODO
 * </p>
 * @Date 2023/2/21 20:11
 * @Author by jtlee
 * @Version 1.0.0
 */
public class SubjectImpl extends Subject {
    @Override
    public void test() {
        System.out.println("执行目标方法");
    }
}
