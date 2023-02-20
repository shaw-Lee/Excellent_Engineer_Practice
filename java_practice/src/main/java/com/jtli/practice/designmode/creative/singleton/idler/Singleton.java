package com.jtli.practice.designmode.creative.singleton.idler;

/**
 * @Classname Singleton
 * @Description <p>
 *      懒汉式单例模式（线程不安全），需要加锁及双重检测
 * </p>
 * @Date 2023/2/19 12:58
 * @Author by jtlee
 * @Version 1.0.0
 */
public class Singleton {

    private static volatile Singleton INSTANCE;   //在一开始先不进行对象创建

    private Singleton() {
    }   //不用多说了吧

    public static Singleton getInstance() {   //将对象的创建延后到需要时再进行
        if(INSTANCE == null) {
            synchronized (Singleton.class) {
                if(INSTANCE == null) INSTANCE = new Singleton();  //内层还要进行一次检查，双重检查锁定
            }
        }
        return INSTANCE;
    }
/**
 * 或者静态内部类方式
 */
//    private static class Holder {   //由静态内部类持有单例对象，但是根据类加载特性，我们仅使用Singleton类时，不会对静态内部类进行初始化
//        private final static Singleton INSTANCE = new Singleton();
//    }
//
//    public static Singleton getInstance(){   //只有真正使用内部类时，才会进行类初始化
//        return Holder.INSTANCE;   //直接获取内部类中的
//    }
}
