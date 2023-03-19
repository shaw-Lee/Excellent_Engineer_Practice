package com.jtli.spring.context;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Classname Autowired
 * @Description <p>
 *      自定义Autowiredz注解
 * </p>
 * @Date 2023/3/18 17:06
 * @Author by jtlee
 * @Version 1.0.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Autowired {
}
