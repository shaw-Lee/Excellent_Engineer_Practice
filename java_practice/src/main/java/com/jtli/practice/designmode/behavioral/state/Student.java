package com.jtli.practice.designmode.behavioral.state;

/**
 * @Classname Stuedent
 * @Description <p>
 * 当一个对象内在状态改变时允许改变其行为，这个对象看起来像是改变了其类。
 * </p>
 * @Date 2023/2/23 20:50
 * @Author by jtlee
 * @Version 1.0.0
 */
public class Student {

    private State state;   //使用一个成员来存储状态

    public void setState(State state) {
        this.state = state;
    }

    public void study() {
        switch (state) {   //根据不同的状态，学习方法会有不同的结果
            case LAZY:
                System.out.println("只要我不努力，老板就别想过上想要的生活，开摆！");
                break;
            case NORMAL:
                System.out.println("拼搏百天，我要上清华大学！");
                break;
        }
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.setState(State.NORMAL);   //先正常模式
        student.study();

        student.setState(State.LAZY);   //开启摆烂模式
        student.study();
    }
}

enum State {   //状态直接使用枚举定义
    NORMAL, LAZY
}
