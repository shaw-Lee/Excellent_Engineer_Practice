package com.jtli.practice.designmode.creative.singleton.hungry;

/**
 * @Classname Singleton
 * @Description <p>
 * 单例那么肯定就是只有一个实例对象，在我们的整个程序中，同一个类始终只会有一个对象来进行操作。
 * 比如数据库连接类，实际上我们只需要创建一个对象或是直接使用静态方法就可以了，没必要去创建多个对象。
 * <br/>
 * 饿汉式单例
 * </p>
 * @Date 2023/2/19 12:03
 * @Author by jtlee
 * @Version 1.0.0
 */
public class Singleton {

    //用于引用全局唯一的单例对象，在一开始就创建好
    private final static Singleton INSTANCE = new Singleton();

    private Singleton() {
    }   //不允许随便new，需要对象直接找getInstance

    public static Singleton getInstance() {   //获取全局唯一的单例对象
        return INSTANCE;
    }
}
