package com.jtli.practice.designmode.behavioral.memento;

/**
 * @Classname Test
 * @Description <p>
 * 所谓备忘录模式就是在不破坏封装的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态，
 * 这样可以在以后将这个对象恢复到原先保存的状态。
 * </p>
 * @Date 2023/2/23 20:22
 * @Author by jtlee
 * @Version 1.0.0
 */
public class Test {

    public static void main(String[] args) {
        Originator originator = new Originator();
        originator.setState("On");
        originator.show();

        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(originator.createMemento());

        originator.setState("Off");
        originator.show();

        originator.setMemento(caretaker.getMemento());
        originator.show();

    }

}

/**
 * 发起人
 */
class Originator {

    //需要保存的属性
    private String state;

    //创建备忘录，将当前需要保存的信息导入并实例化出一个Memento对象
    public Memento createMemento() {
        return new Memento(state);
    }

    //恢复备忘录，将Memento导入并将相关数据恢复
    public void setMemento(Memento memento) {
        this.state = memento.getState();
    }

    //显示数据
    public void show() {
        System.out.println("state = " + state);
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

/**
 * 备忘录
 */
class Memento {

    private String state;

    //构造方法，将相关数据导入
    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

/**
 * 管理者
 */
class Caretaker {

    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}