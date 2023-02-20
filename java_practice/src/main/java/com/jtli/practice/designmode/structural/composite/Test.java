package com.jtli.practice.designmode.structural.composite;

/**
 * @Classname Test
 * @Description <p>
 * 组合（Composite Pattern）模式的定义：
 * 有时又叫作整体-部分（Part-Whole）模式，
 * 它是一种将对象组合成树状的层次结构的模式，
 * 用来表示“整体-部分”的关系，使用户对单个对象和组合对象具有一致的访问性，属于结构型设计模式。
 * <p>
 * 组合模式一般用来描述整体与部分的关系，
 * 它将对象组织到树形结构中，顶层的节点被称为根节点，
 * 根节点下面可以包含树枝节点和叶子节点，树枝节点下面又可以包含树枝节点和叶子节点，树形结构图如下。
 * 组合模式的主要优点有：
 * <p>
 * 组合模式使得客户端代码可以一致地处理单个对象和组合对象，无须关心自己处理的是单个对象，
 * 还是组合对象，这简化了客户端代码；
 * 更容易在组合体内加入新的对象，客户端不会因为加入了新的对象而更改源代码，满足“开闭原则”；
 * 其主要缺点是：
 * <p>
 * 设计较复杂，客户端需要花更多时间理清类之间的层次关系；
 * 不容易限制容器中的构件；
 * 不容易用继承的方法来增加构件的新功能；
 * </p>
 * @Date 2023/2/20 20:27
 * @Author by jtlee
 * @Version 1.0.0
 */
public class Test {

    public static void main(String[] args) {
        Directory outer = new Directory();   //新建一个外层目录
        Directory inner = new Directory();   //新建一个内层目录
        outer.addComponent(inner);
        outer.addComponent(new File());   //在内层目录和外层目录都添加点文件，注意别导错包了
        inner.addComponent(new File());
        inner.addComponent(new File());
        outer.test();    //开始执行文件名称修改操作
    }
}
