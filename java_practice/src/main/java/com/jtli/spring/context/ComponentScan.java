package com.jtli.spring.context;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Classname ComponentScan
 * @Description <p>
 *      自定义ComponentScan
 * </p>
 * @Date 2023/3/18 10:21
 * @Author by jtlee
 * @Version 1.0.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ComponentScan {

    String value();
}
