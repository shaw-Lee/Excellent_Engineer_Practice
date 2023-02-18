package com.jtli.practice.designphilosophy.dip;

import javax.annotation.Resource;

/**
 * @Classname DipTest
 * @Description <p>
 *     <title>依赖倒置原则</title><br/>
 *高层模块不应依赖于底层模块，它们都应该依赖抽象。抽象不应依赖于细节，细节应该依赖于抽象。
 * </p>
 * @Date 2023/2/18 13:24
 * @Author by jtlee
 * @Version 1.0.0
 */
public class DipTest {

    public static void main(String[] args) {

    }

//    static class UserMapper {
//        //CRUD...
//        UserController controller = new UserController();
//        //该怎么用就这么用
//    }
//
//    static class UserService {
//        UserMapper mapper = new UserMapper();
//        //业务代码....
//    }
//
//    static class UserController {
//        UserService service = new UserService();
//        //业务代码....
//    }

    interface UserMapper {
        //接口中只做CRUD方法定义
    }

    static class UserMapperImpl implements UserMapper {
        //实现类完成CRUD具体实现
    }

    interface UserService {
        //业务代码定义....
    }

    static class UserServiceImpl implements UserService {
        @Resource   //现在由Spring来为我们选择一个指定的实现类，然后注入，而不是由我们在类中硬编码进行指定
        UserMapper mapper;

        //业务代码具体实现
    }

    static class UserController {
        @Resource
        UserService service;   //直接使用接口，就算你改实现，我也不需要再修改代码了

        //业务代码....
    }
}
