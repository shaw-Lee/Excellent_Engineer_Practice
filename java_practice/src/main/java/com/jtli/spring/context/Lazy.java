package com.jtli.spring.context;

import com.jtli.spring.Constants;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Classname Lazy
 * @Description <p>
 *      TODO
 * </p>
 * @Date 2023/3/18 17:27
 * @Author by jtlee
 * @Version 1.0.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Lazy {

}
