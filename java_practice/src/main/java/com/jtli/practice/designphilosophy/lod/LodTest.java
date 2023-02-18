package com.jtli.practice.designphilosophy.lod;

import java.io.IOException;
import java.net.Socket;

/**
 * @Classname LodTest
 * @Description <p>
 * 迪米特法则
 * 每一个软件单位对其他单位都只有最少的知识，而且局限于那些与本单位密切相关的软件单位。
 * 简单来说就是，一个类/模块对其他的类/模块有越少的交互越好。当一个类发生改动，那么，
 * 与其相关的类（比如用到此类啥方法的类）需要尽可能少的受影响（比如修改了方法名、字段名等
 * ，可能其他用到这些方法或是字段的类也需要跟着修改）这样我们在维护项目的时候会更加轻松一些。
 * <br/>
 * 降低耦合度
 * </p>
 * @Date 2023/2/18 13:47
 * @Author by jtlee
 * @Version 1.0.0
 */
public class LodTest {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8080);   //假设我们当前的程序需要进行网络通信
        Test1 test = new Test1();
        test.test(socket.getLocalAddress().getHostAddress());   //现在需要执行test方法来做一些事情
    }

    static class Test {
        /**
         * 比如test方法需要得到我们当前Socket连接的本地地址
         */
        public void test(Socket socket){
            System.out.println("IP地址："+socket.getLocalAddress());
        }
    }

    //一个字符串就能搞定，就没必要丢整个对象进来
    static class Test1 {
        public void test(String str){
            System.out.println("IP地址："+str);
        }
    }
}
