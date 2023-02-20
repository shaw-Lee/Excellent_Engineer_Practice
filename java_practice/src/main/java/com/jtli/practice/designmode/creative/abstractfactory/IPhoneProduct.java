package com.jtli.practice.designmode.creative.abstractfactory;

/**
 * @Classname IphoneProduct
 * @Description <p>
 *      TODO
 * </p>
 * @Date 2023/2/19 11:15
 * @Author by jtlee
 * @Version 1.0.0
 */
public interface IPhoneProduct {
    //开机
    void start();

    //关机
    void shutdown();

    //打电话
    void callup();

    //发邮件
    void sendSMS();
}
