package com.jtli.practice.designmode.structural.bridge;

/**
 * @Classname RefinedAbstractTea
 * @Description <p>
 *      TODO
 * </p>
 * @Date 2023/2/20 20:09
 * @Author by jtlee
 * @Version 1.0.0
 */
public abstract class RefinedAbstractTea extends AbstractTea {

    protected RefinedAbstractTea(Size size) {
        super(size);
    }

    public String getSize() {   //添加尺寸维度获取方式
        return size.getSize();
    }
}
