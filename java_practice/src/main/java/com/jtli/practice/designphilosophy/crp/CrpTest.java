package com.jtli.practice.designphilosophy.crp;

/**
 * @Classname CrpTest
 * @Description <p>
 * 合成复用原则:优先使用对象组合，而不是通过继承来达到复用的目的。
 * 在一个新的对象里面使用一些已有的对象，使之成为新对象的一部分，新的对象通过向这些对象的委派达到复用已有功能的目的。
 * 实际上我们在考虑将某个类通过继承关系在子类得到父类已经实现的方法之外（比如A类实现了连接数据库的功能，恰巧B类中也需要，
 * 我们就可以通过继承来获得A已经写好的连接数据库的功能，这样就能直接复用A中已经写好的逻辑）
 * 我们应该应该优先地去考虑使用合成的方式来实现复用。
 * </p>
 * @Date 2023/2/18 13:43
 * @Author by jtlee
 * @Version 1.0.0
 */
public class CrpTest {

    /**
     * 通过对象之间的组合，我们就大大降低了类之间的耦合度，并且A的实现细节我们也不会直接得到了。
     */

    class A {
        public void connectDatabase() {
            System.out.println("我是连接数据库操作！");
        }
    }

    /**
     * 耦合度太高
     */
    class B extends A {    //直接通过继承的方式，得到A的数据库连接逻辑
        public void test() {
            System.out.println("我是B的方法，我也需要连接数据库！");
            connectDatabase();   //直接调用父类方法就行
        }
    }

    //不进行继承，而是在用的时候给我一个A，当然也可以抽象成一个接口，更加灵活
    class C {
        public void test(A a){
            System.out.println("我是C的方法，我也需要连接数据库！");
            a.connectDatabase();   //在通过传入的对象A去执行
        }
    }

    //在构造时就指定好
    class D {

        A a;
        public D(A a){
            this.a = a;
        }

        public void test(){
            System.out.println("我是D的方法，我也需要连接数据库！");
            a.connectDatabase();   //也是通过对象A去执行
        }
    }


}
