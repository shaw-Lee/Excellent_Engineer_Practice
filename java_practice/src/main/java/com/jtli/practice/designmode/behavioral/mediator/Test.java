package com.jtli.practice.designmode.behavioral.mediator;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname Test
 * @Description <p>
 * (1). 定义
 * <p>
 * 　定义一个中介对象来封装一系列对象之间的交互，使原有对象之间的耦合松散，
 * 且可以独立地改变它们之间的交互。中介者模式又叫调停模式，它是迪米特法则的典型应用。
 * <p>
 * <p>
 * (2). 优点
 * <p>
 * 　A. 降低了对象之间的耦合性，使得对象易于独立地被复用。
 * <p>
 * 　B. 将对象间的多对多关联转变为一对一的关联，提高系统的灵活性，使得系统易于维护和扩展。
 * <p>
 * (3). 缺点
 * <p>
 * 　同事类太多时，中介者的职责将很大，它会变得复杂而庞大，以至于系统难以维护
 * </p>
 * @Date 2023/2/23 20:15
 * @Author by jtlee
 * @Version 1.0.0
 */
public class Test {

    public static void main(String[] args) {
        User user0 = new User("刘女士", "10086");   //出租人
        User user1 = new User("李先生", "10010");   //找房人
        Mediator mediator = new Mediator();   //我是黑心中介

        mediator.register("成都市武侯区天府五街白马程序员", user0);   //先把房子给中介挂上去

        User user = user1.find("成都市武侯区天府五街下硅谷", mediator);  //开始找房子
        if (user == null) System.out.println("没有找到对应的房源");

        user = user1.find("成都市武侯区天府五街白马程序员", mediator);  //开始找房子
        System.out.println(user);   //成功找到对应房源
    }
}

class Mediator {   //房产中介
    private final Map<String, User> userMap = new HashMap<>();   //在出售的房子需要存储一下

    public void register(String address, User user) {   //出售房屋的人，需要告诉中介他的房屋在哪里
        userMap.put(address, user);
    }

    public User find(String address) {   //通过此方法来看看有没有对应的房源
        return userMap.get(address);
    }
}

class User {   //用户可以是出售房屋的一方，也可以是寻找房屋的一方
    String name;
    String tel;

    public User(String name, String tel) {
        this.name = name;
        this.tel = tel;
    }

    public User find(String address, Mediator mediator) {   //找房子的话，需要一个中介和你具体想找的地方
        return mediator.find(address);
    }

    @Override
    public String toString() {
        return name + " (电话：" + tel + ")";
    }
}