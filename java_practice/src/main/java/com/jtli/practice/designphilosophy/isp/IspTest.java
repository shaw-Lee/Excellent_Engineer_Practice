package com.jtli.practice.designphilosophy.isp;

/**
 * @Classname IspTest
 * @Description <p>
 *  客户端不应依赖那些它不需要的接口。
 * </p>
 * @Date 2023/2/18 13:31
 * @Author by jtlee
 * @Version 1.0.0
 */
public class IspTest {

    interface Device {
        String getCpu();
        String getType();
        String getMemory();
    }

//    //电脑就是一种电子设备，那么我们就实现此接口
//    class Computer implements Device {
//
//        @Override
//        public String getCpu() {
//            return "i9-12900K";
//        }
//
//        @Override
//        public String getType() {
//            return "电脑";
//        }
//
//        @Override
//        public String getMemory() {
//            return "32G DDR5";
//        }
//    }
//
//    //电风扇也算是一种电子设备
//    class Fan implements Device {
//
//        @Override
//        public String getCpu() {
//            return null;   //就一个破风扇，还需要CPU？
//        }
//
//        @Override
//        public String getType() {
//            return "风扇";
//        }
//
//        @Override
//        public String getMemory() {
//            return null;   //风扇也不需要内存吧
//        }
//    }

    interface SmartDevice {   //智能设备才有getCpu和getMemory
        String getCpu();
        String getType();
        String getMemory();
    }

    interface NormalDevice {   //普通设备只有getType
        String getType();
    }

    //电脑就是一种电子设备，那么我们就继承此接口
    class Computer implements SmartDevice {

        @Override
        public String getCpu() {
            return "i9-12900K";
        }

        @Override
        public String getType() {
            return "电脑";
        }

        @Override
        public String getMemory() {
            return "32G DDR5";
        }
    }

    //电风扇也算是一种电子设备
    class Fan implements NormalDevice {
        @Override
        public String getType() {
            return "风扇";
        }
    }
}
