package com.jtli.practice.designmode.behavioral.observer;

import java.util.Date;
import java.util.Observable;

/**
 * @Classname Test
 * @Description <p>
 * 观察者模式也称作监听模式，即观察与被观察的关系，比如你在烧开水时看它有没有开，你就是观察者，水就是被观察者。
 * 观察者模式是指对象之间一对多的依赖关系，每当那个特定对象改变状态时，所有依赖于它的对象都会得到通知并被自动更新。
 * <p>
 * 观察者模式是对象的行为模式。有的地方称作的发布-订阅模式、模型-视图模式、源-监听器模式、从属者模式等，
 * 当你看到这种叫法时，不要觉得陌生，它们都是观察者模式。
 * <p>
 * 观察者模式可以有任意多个观察者对象同时监听某一个对象。监听某个对象的叫观察者（Observer），
 * 被监听的对象叫被观察者（Subject） 。被观察者对象在内容或状态发生改变时，会通知所有观察者，使它们能自动更新自己的信息。
 * </p>
 * @Date 2023/2/23 20:39
 * @Author by jtlee
 * @Version 1.0.0
 */
public class Test {
    public static void main(String[] args) {
        Subject subject = new Subject();
        subject.addObserver((o, arg) -> System.out.println("监听到变化，并得到参数："+arg));
        //注意这里的Observer是java.util包下提供的
        subject.modify();   //进行修改操作
    }

}
class Subject extends Observable {   //继承此抽象类表示支持观察者

    public void modify(){
        System.out.println("对对象进行修改！");
        this.setChanged();    //当对对象修改后，需要setChanged来设定为已修改状态
        this.notifyObservers(new Date());   //使用notifyObservers方法来通知所有的观察者
        //注意只有已修改状态下通知观察者才会有效，并且可以给观察者传递参数，这里传递了一个时间对象
    }
}
