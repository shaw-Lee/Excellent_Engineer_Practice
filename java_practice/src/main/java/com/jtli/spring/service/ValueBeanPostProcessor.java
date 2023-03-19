package com.jtli.spring.service;

import com.jtli.spring.context.BeanPostProcessor;
import com.jtli.spring.context.Component;
import com.jtli.spring.context.Value;

import java.lang.reflect.Field;

/**
 * @Classname ValueBeanPostProcessor
 * @Description <p>
 * 注入@value值
 * </p>
 * @Date 2023/3/19 9:47
 * @Author by jtlee
 * @Version 1.0.0
 */
@Component
public class ValueBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String benmame) {
        // 获取bean中声明的属性
        for (Field field : bean.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Value.class)) {
                field.setAccessible(true);
                try{
                    // 注入值
                    field.set(bean,field.getAnnotation(Value.class).value());
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return bean;
    }
}
