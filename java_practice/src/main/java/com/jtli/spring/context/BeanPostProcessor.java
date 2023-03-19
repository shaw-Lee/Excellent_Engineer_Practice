package com.jtli.spring.context;

/**
 * @Classname BeanPostProcessor
 * @Description <p>
 *      bean初始化前后逻辑处理
 * </p>
 * @Date 2023/3/18 21:26
 * @Author by jtlee
 * @Version 1.0.0
 */
public interface BeanPostProcessor {

    default Object postProcessBeforeInitialization(Object bean, String benmame) {
        return bean;
    }

    default Object postProcessAfterInitialization(Object bean, String benmame) {
        return bean;
    }
}
