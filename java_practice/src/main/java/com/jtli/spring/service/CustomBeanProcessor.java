package com.jtli.spring.service;

import com.jtli.spring.context.BeanPostProcessor;
import com.jtli.spring.context.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Classname CustomBeanProcessor
 * @Description <p>
 *      自定义后置处理器
 * </p>
 * @Date 2023/3/18 21:42
 * @Author by jtlee
 * @Version 1.0.0
 */
@Component
public class CustomBeanProcessor implements BeanPostProcessor {

//    @Override
//    public Object postProcessBeforeInitialization(Object bean, String benmame) {
//        System.out.println(benmame);
//        return bean;
//    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String benmame) {
//         // 自定义逻辑处理 切面增强
//         if (benmame.equals("userService")) {
//             // jdk代理只能代理实现了接口的类 userService implments UserServiceInterface
//             return Proxy.newProxyInstance(CustomBeanProcessor.class.getClassLoader(),
//                     bean.getClass().getInterfaces(), (proxy, method, args) -> {
//                         System.out.println("切面自定以逻辑处理");
//                         return method.invoke(bean,args);
//                     });
//         }
        System.out.println("自定义的postProcessAfterInitialization");
        System.out.println(benmame);
        return bean;
    }
}
