package com.jtli.practice.designmode.behavioral.template;

/**
 * @Classname TemplateMethodTest
 * @Description <p>
 * 模板方法模式 在一个方法中定义一个算法的骨架，而将一些步骤延迟到子类中。
 * 模板方法使得子类可以在不改变算法结构的情况下，重新定义算法中的某些步骤。
 * </p>
 * @Date 2023/2/22 20:28
 * @Author by jtlee
 * @Version 1.0.0
 */
public class TemplateMethodTest {

    public static void main(String[] args) {
        AbstractDiagnosis diagnosis = new ColdDiagnosis();
        diagnosis.test();
    }
}

/**
 * 抽象诊断方法，因为现在只知道挂号和看医生是固定模式，剩下的开处方和拿药都是不确定的
 */
abstract class AbstractDiagnosis {

    public void test(){
        System.out.println("今天头好晕，不想起床，开摆，先跟公司请个假");
        System.out.println("去医院看病了~");
        System.out.println("1 >> 先挂号");
        System.out.println("2 >> 等待叫号");
        //由于现在不知道该开什么处方，所以只能先定义一下行为，然后具体由子类实现
        //大致的流程先定义好就行
        this.prescribe();
        this.medicine();  //开药同理
    }

    public abstract void prescribe();   //开处方操作根据具体病症决定了

    public abstract void medicine();   //拿药也是根据具体的处方去拿
}

class ColdDiagnosis extends AbstractDiagnosis{
    @Override
    public void prescribe() {
        System.out.println("3 >> 一眼丁真，鉴定为假，你这不是感冒，纯粹是想摆烂");
    }

    @Override
    public void medicine() {
        System.out.println("4 >> 开点头孢回去吃吧");
    }
}