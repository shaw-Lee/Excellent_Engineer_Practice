package com.jtli.spring;

import com.jtli.spring.config.Appconfig;
import com.jtli.spring.context.ApplicationContext;
import com.jtli.spring.service.UserService;

/**
 * @Classname Application
 * @Description <p>
 *      TODO
 * </p>
 * @Date 2023/3/18 16:48
 * @Author by jtlee
 * @Version 1.0.0
 */
public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ApplicationContext(Appconfig.class);
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.test();

    }
}
