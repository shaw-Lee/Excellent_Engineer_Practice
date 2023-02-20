package com.jtli.practice.designmode.creative.abstractfactory;

/**
 * @Classname HuaweiProduct
 * @Description <p>
 *      TODO
 * </p>
 * @Date 2023/2/19 11:17
 * @Author by jtlee
 * @Version 1.0.0
 */
public interface IRouterProduct {
    //开机
    void start();

    //关机
    void shutdown();

    //打开wifi
    void openwifi();

    //设置
    void setting();
}
