package com.jtli.practice.designphilosophy.lsp;/**

/**
 * @author jtlee
 * @version 1.0
 * @description: 里氏替换原则
 * <p>
 *     子类可以扩展父类的功能，但不能改变父类原有的功能：
 * 1. 子类可以实现父类的抽象方法，但不能覆盖父类的非抽象方法。
 * 2. 子类可以增加自己特有的方法。
 * 3. 当子类的方法重载父类的方法时，方法的前置条件（即方法的输入/入参）要比父类方法的输入参数更宽松。
 * 4. 当子类的方法实现父类的方法时（重写/重载或实现抽象方法），方法的后置条件（即方法的输出/返回值）要比父类更严格或与父类一样。
 * </p>
 * @date 2023/2/18 13:16
 */
public class Coder {
    public void coding() {
        System.out.println("我会打代码");
    }


    class JavaCoder extends Coder{

        /**
         * 子类除了会打代码之外，还会打游戏
         */
        public void game(){
            System.out.println("艾欧尼亚最强王者已上号");
        }
    }

    /**
     * 父类的行为已经被我们给覆盖，这个子类已经不具备父类的原本的行为，很显然违背了里氏替换原则。
     * 里氏替换也是实现开闭原则的重要方式之一。
     */
    class PhpCoder extends Coder{
        public void game(){
            System.out.println("艾欧尼亚最强王者已上号");
        }

        /**
         * 这里我们对父类的行为进行了重写，现在它不再具备父类原本的能力了
         */
        public void coding() {
            System.out.println("我寒窗苦读十六年，到最后还不如培训班三个月出来的程序员");
            System.out.println("想来想去，房子车子结婚彩礼，为什么这辈子要活的这么累呢？");
            System.out.println("难道来到这世间走这一遭就为了花一辈子时间买个房子吗？一个人不是也能活的轻松快乐吗？");
            System.out.println("摆烂了，啊对对对");
            //好了，emo结束，继续卷吧，人生因奋斗而美丽，这个世界虽然满目疮痍，但是还是有很多美好值得期待
        }
    }
}
