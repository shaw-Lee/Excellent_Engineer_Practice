package com.jtli.practice.designmode.structural.facade;

/**
 * @Classname Test
 * @Description <p>
 * 软件设计也是这样，当一个系统的功能越来越强，子系统会越来越多，
 * 客户对系统的访问也变得越来越复杂。这时如果系统内部发生改变，
 * 客户端也要跟着改变，这违背了“开闭原则”，也违背了“迪米特法则”，
 * 所以有必要为多个子系统提供一个统一的接口，从而降低系统的耦合度，这就是外观模式的目标。
 * </p>
 * @Date 2023/2/22 19:48
 * @Author by jtlee
 * @Version 1.0.0
 */
public class Test {

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.take();
    }
}
class SystemA{
    public void test() {
        System.out.println("排队");
    }
}

class SystemB{
    public void test() {
        System.out.println("预约");
    }
}

class SystemC{
    public void test() {
        System.out.println("就诊");
    }
}

class Facade {
    SystemA systemA = new SystemA();
    SystemB systemB = new SystemB();
    SystemC systemC = new SystemC();

    public void take() {
        systemA.test();;
        systemB.test();
        systemC.test();
    }
}