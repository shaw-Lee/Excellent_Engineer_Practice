package com.jtli.practice.designphilosophy.ocp;
/**
 * @author jtlee
 * @version 1.0
 * @description: 开闭原则  软件实体应当对扩展开放，对修改关闭。
 *
 * 一个软件实体，比如类、模块和函数应该对扩展开放，对修改关闭。其中，对扩展开放是针对提供方来说的，对修改关闭是针对调用方来说的。
 * @date 2023/2/18 13:10
 */
public abstract class Coder {

    public abstract void coding();

    class JavaCoder extends Coder{
        @Override
        public void coding() {
            System.out.println("Java太卷了T_T，快去学Go吧！");
        }
    }

    class PHPCoder extends Coder{
        @Override
        public void coding() {
            System.out.println("PHP是世界上最好的语言");
        }
    }

    class C艹Coder extends Coder{
        @Override
        public void coding() {
            System.out.println("笑死，Java再牛逼底层不还得找我？");
        }
    }
}
