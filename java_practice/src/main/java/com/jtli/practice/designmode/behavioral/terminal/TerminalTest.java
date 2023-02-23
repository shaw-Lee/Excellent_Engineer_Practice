package com.jtli.practice.designmode.behavioral.terminal;

/**
 * @Classname TerminalTest
 * @Description <p>
 * 请求以命令的形式包裹在对象中，并传给调用对象。
 * 调用对象寻找可以处理该命令的合适的对象，并把该命令传给相应的对象，该对象执行命令。
 * <p>
 * 在这个设计模式的实现过程中有如下几个比较重要的点；
 * <p>
 * 1. 抽象命令类；声明执⾏命令的接⼝和⽅法
 * <p>
 * 2. 具体的命令实现类；接⼝类的具体实现，可以是⼀组相似的行为逻辑
 * <p>
 * 3. 实现者；也就是为命令做实现的具体实现类
 * <p>
 * 4. 调⽤用者；处理理命令、实现的具体操作者，负责对外提供命令服务
 * </p>
 * @Date 2023/2/22 20:45
 * @Author by jtlee
 * @Version 1.0.0
 */
public class TerminalTest {

    public static void main(String[] args) {
        AirConditioner airConditioner = new AirConditioner();   //先创建一个空调
        Controller.call(new OpenCommand(airConditioner));   //直接通过遥控器来发送空调开启命令
    }
}

interface Receiver {
    void action();   //具体行为，这里就写一个算了
}

abstract class Command {   //指令抽象，不同的电器有指令

    private final Receiver receiver;

    protected Command(Receiver receiver) {   //指定此命令对应的电器（接受者）
        this.receiver = receiver;
    }

    public void execute() {
        receiver.action();   //执行命令，实际上就是让接收者开始干活
    }
}

class Controller {   //遥控器只需要把我们的指令发出去就行了
    public static void call(Command command) {
        command.execute();
    }
}

class AirConditioner implements Receiver {
    @Override
    public void action() {
        System.out.println("空调已开启，呼呼呼");
    }
}

class OpenCommand extends Command {
    public OpenCommand(AirConditioner airConditioner) {
        super(airConditioner);
    }
}