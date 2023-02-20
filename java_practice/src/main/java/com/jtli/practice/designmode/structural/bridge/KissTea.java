package com.jtli.practice.designmode.structural.bridge;

/**
 * @Classname KissTea
 * @Description <p>
 * 桥接模式是将抽象部分与它的实现部分分离，使它们都可以独立地变化。
 * 它是一种对象结构型模式，又称为柄体(Handle and Body)模式或接口(Interfce)模式。
 * <p>
 * “抽象部分”和“实现部分”可以以继承的方式独立扩展而互不影响，
 * 在程序运行时可以动态将一个抽象化子类的对象和一个实现化子类的对象进行组合
 * ，即系统需要对抽象化角色和实现化角色进行动态耦合。
 * <p>
 * 一个类存在两个（或多个）独立变化的维度
 * <p>
 * ，且这两个（或多个）维度都需要独立进行扩展。
 * 对于那些不希望使用继承或因为多层继承导致系统类的个数急剧增加的系统，桥接模式尤为适用。
 * </p>
 * @Date 2023/2/20 20:12
 * @Author by jtlee
 * @Version 1.0.0
 */
public class KissTea extends RefinedAbstractTea {
    protected KissTea(Size size) {   //在构造时需要指定具体的大小实现
        super(size);
    }

    @Override
    public String getType() {
        return "bobo芋圆奶茶";
    }

    public static void main(String[] args) {
        KissTea kissTea = new KissTea(new Large());
        System.out.println(kissTea.getSize());
        System.out.println(kissTea.getType());
    }
}
