package com.jtli.practice.designphilosophy.srp;

/**
 * 单一职责原则
 * 一个对象应该只包含单一的职责，并且该职责被完整地封装在一个类中。
 * A human
 */
public class People {

    /**
     * humans can program
     */
    public void coding(){
        System.out.println("int mian() {");
        System.out.println("   printf(\"Holle Wrold!\");");
        System.out.println("}");
        System.out.println("oops! unable to run");
    }

    /**
     * humans can work
     */
    public void work(){
        System.out.println("真开心，能进到富土康打螺丝");
        System.out.println("诶，怎么工友都提桶跑路了");
    }

    /**
     * 送外卖也会
     */
    public void ride(){
        System.out.println("今天终于通过美团最终面，加入了梦寐以求的大厂了");
        System.out.println("感觉面试挺简单的，就是不知道为啥我同学是现场做一道力扣接雨水，而我是现场问会不会骑车");
        System.out.println("（迫不及待穿上外卖服装）");
    }


    // 根据单一职责原则，我们下需要进行更明确的划分，同种类型的操作我们一般才放在一起：
    class Coder{
        /**
         * 程序员会编程
         */
        public void coding(){
            System.out.println("int mian() {");
            System.out.println("   printf(\"Hello World!\")");
            System.out.println("}");
            System.out.println("啊嘞，怎么运行不起？明明照着老师敲的啊");
        }
    }

    class Worker{
        /**
         * 工人会打螺丝
         */
        public void work(){
            System.out.println("真开心，能进到富土康打螺丝");
            System.out.println("诶，怎么工友都提桶跑路了");
        }
    }

    class Rider {
        /**
         * 骑手会送外卖
         */
        public void ride(){
            System.out.println("今天终于通过美团最终面，加入了梦寐以求的大厂");
            System.out.println("感觉面试挺简单的，就是不知道为啥我同学是现场做一道力扣接雨水，我是现场问会不会骑车");
            System.out.println("（迫不及待穿上外卖服装）");
        }
    }
}
