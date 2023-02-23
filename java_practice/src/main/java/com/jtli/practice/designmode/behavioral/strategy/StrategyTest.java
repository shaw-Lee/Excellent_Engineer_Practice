package com.jtli.practice.designmode.behavioral.strategy;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Classname StrategyTest
 * @Description <p>
 * 策略模式（Strategy Pattern）是一种行为型设计模式，它定义了一系列算法，将每个算法封装起来，
 * 使它们可以相互替换，而且算法的变化不会影响到使用算法的客户端。在这种模式中，一个类的行为或其算法可以在运行时改变，
 * 根据所传递的参数来确定应该使用哪个算法。
 * 策略模式主要由三个角色组成：上下文（Context）、策略（Strategy）和具体策略（Concrete Strategy）。
 * 下面分别介绍这三个角色：
 * <p>
 * 上下文（Context）：上下文是一个包含某个算法的类。它将一个具体策略对象传递给客户端，并在客户端使用这个对象时，
 * 调用该对象所定义的算法。上下文还可以在运行时更改所使用的算法。
 * 策略（Strategy）：策略是一个接口或抽象类，它定义了一系列算法。在实现策略时，可以定义多个具体的策略类，
 * 每个类都实现了策略接口，且实现了自己的算法。
 * 具体策略（Concrete Strategy）：具体策略是实现策略接口的类。它实现了一个特定的算法，供上下文调用。
 *
 * </p>
 * @Date 2023/2/23 20:55
 * @Author by jtlee
 * @Version 1.0.0
 */
public class StrategyTest {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 10,
                TimeUnit.SECONDS, new SynchronousQueue<>(),  //这里不给排队
                new ThreadPoolExecutor.AbortPolicy());   //当线程池无法再继续创建新任务时，我们可以自由决定使用什么拒绝策略

        Runnable runnable = () -> {
            try {
                TimeUnit.SECONDS.sleep(60);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        executor.execute(runnable);   //连续提交两次任务，肯定塞不下，这时就得走拒绝了
        executor.execute(runnable);
    }
}
