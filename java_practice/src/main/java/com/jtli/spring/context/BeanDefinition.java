package com.jtli.spring.context;

/**
 * @Classname BeanDefinition
 * @Description <p>
 *      TODO
 * </p>
 * @Date 2023/3/18 10:46
 * @Author by jtlee
 * @Version 1.0.0
 */
public class BeanDefinition {

    private Class type;
    private String scope;
    private boolean isLazy;

    public Class getType() {
        return type;
    }

    public void setType(Class type) {
        this.type = type;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public boolean isLazy() {
        return isLazy;
    }

    public void setLazy(boolean lazy) {
        isLazy = lazy;
    }
}
