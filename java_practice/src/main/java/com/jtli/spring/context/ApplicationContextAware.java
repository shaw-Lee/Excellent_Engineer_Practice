package com.jtli.spring.context;

/**
 * @Classname ApplicationContextAware
 * @Description <p>
 *      TODO
 * </p>
 * @Date 2023/3/18 21:19
 * @Author by jtlee
 * @Version 1.0.0
 */
public interface ApplicationContextAware {

    void setApplicationContext(ApplicationContext applicationContext);
}
