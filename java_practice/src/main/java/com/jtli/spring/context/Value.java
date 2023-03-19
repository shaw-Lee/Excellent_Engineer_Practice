package com.jtli.spring.context;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Classname Value
 * @Description <p>
 * 自定义@Value
 * </p>
 * @Date 2023/3/19 9:38
 * @Author by jtlee
 * @Version 1.0.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Value {

    String value();
}
