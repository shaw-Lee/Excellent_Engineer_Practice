package com.jtli.practice.designmode.behavioral.chainofresponsibility;

import java.util.Optional;

/**
 * @Classname HanlerTest
 * @Description <p>
 * 为了避免请求发送者与多个请求处理者耦合在一起
 * ，将所有请求的处理者通过前一对象记住其下一个对象的引用而连成一条链；
 * 当有请求发生时，可将请求沿着这条链传递，直到有对象处理它为止。
 * </p>
 * @Date 2023/2/22 20:36
 * @Author by jtlee
 * @Version 1.0.0
 */
public class HanlerTest {

    public static void main(String[] args) {
        Handler handler = new FirstHandler();  //一面首当其冲
        handler
                .connect(new SecondHandler())   //继续连接二面和三面
                .connect(new ThirdHandler());
        handler.handle();   //开始面试
    }
}
abstract class Handler {

    protected Handler successor;    //这里我们就设计责任链以单链表形式存在，这里存放后继节点

    public Handler connect(Handler successor){     //拼接后续节点
        this.successor = successor;
        return successor;  //这里返回后继节点，方便我们一会链式调用
    }

    public void handle(){
        this.doHandle();   //由不同的子类实现具体处理过程
        Optional
                .ofNullable(successor)
                .ifPresent(Handler::handle);    //责任链上如果还有后继节点，就继续向下传递
    }

    public abstract void doHandle();   //结合上节课学习的模板方法，交给子类实现
}

class FirstHandler extends Handler{   //用于一面的处理器
    @Override
    public void doHandle() {
        System.out.println("============= 白马程序员一面 ==========");
        System.out.println("1. 谈谈你对static关键字的理解？");
        System.out.println("2. 内部类可以调用外部的数据吗？如果是静态的呢？");
        System.out.println("3. hashCode()方法是所有的类都有吗？默认返回的是什么呢？");
        System.out.println("以上问题会的，可以依次打在评论区");
    }
}

class SecondHandler extends Handler{  //二面
    @Override
    public void doHandle() {
        System.out.println("============= 白马程序员二面 ==========");
        System.out.println("1. 如果我们自己创建一个java.lang包并且编写一个String类，能否实现覆盖JDK默认的？");
        System.out.println("2. HashMap的负载因子有什么作用？变化规律是什么？");
        System.out.println("3. 线程池的运作机制是什么？");
        System.out.println("4. ReentrantLock公平锁和非公平锁的区别是什么？");
        System.out.println("以上问题会的，可以依次打在评论区");
    }
}

class ThirdHandler extends Handler{
    @Override
    public void doHandle() {
        System.out.println("============= 白马程序员三面 ==========");
        System.out.println("1. synchronized关键字了解吗？如何使用？底层是如何实现的？");
        System.out.println("2. IO和NIO的区别在哪里？NIO三大核心组件？");
        System.out.println("3. TCP握手和挥手流程？少一次握手可以吗？为什么？");
        System.out.println("4. 操作系统中PCB是做什么的？运行机制是什么？");
        System.out.println("以上问题会的，可以依次打在评论区");
    }
}

