package com.jtli.spring.service;

import com.jtli.spring.context.Autowired;
import com.jtli.spring.context.BeanNameAware;
import com.jtli.spring.context.Component;
import com.jtli.spring.context.Value;

/**
 * @Classname UserService
 * @Description <p>
 *      TODO
 * </p>
 * @Date 2023/3/18 16:47
 * @Author by jtlee
 * @Version 1.0.0
 */
@Component
public class UserService implements BeanNameAware {

    @Autowired
    private OrderService orderService;

    @Value("value")
    private String value;

    private String  beanname;

    public void test() {
        System.out.println(value);
        System.out.println("UserServiceTest");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("获取当前组件名称"+name);
        this.beanname = beanname;
    }
}
