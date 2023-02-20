package com.jtli.practice.designmode.structural.bridge;

/**
 * @Classname Large
 * @Description <p>
 *      TODO
 * </p>
 * @Date 2023/2/20 20:10
 * @Author by jtlee
 * @Version 1.0.0
 */
public class Large implements Size {
    @Override
    public String getSize() {
        return "mug";
    }
}
