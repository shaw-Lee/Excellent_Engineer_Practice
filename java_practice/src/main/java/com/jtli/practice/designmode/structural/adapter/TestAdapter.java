package com.jtli.practice.designmode.structural.adapter;

/**
 * @Classname TestAdapter
 * @Description <p>
 * 是作为两个不兼容的接口之间的桥梁。这种类型的设计模式属于结构型模式，它结合了两个独立接口的功能。
 * <p>
 * 这种模式涉及到一个单一的类，该类负责加入独立的或不兼容的接口功能。举个真实的例子，
 * 读卡器是作为内存卡和笔记本之间的适配器。
 * 您将内存卡插入读卡器，再将读卡器插入笔记本，这样就可以通过笔记本来读取内存卡。
 * </p>
 * @Date 2023/2/20 19:53
 * @Author by jtlee
 * @Version 1.0.0
 */
public class TestAdapter implements Target {
    TestSupplier testSupplier;

    public TestAdapter(TestSupplier testSupplier) {
        this.testSupplier = testSupplier;
    }

    @Override
    public String supply() {
        return testSupplier.doSupply();
    }
}
