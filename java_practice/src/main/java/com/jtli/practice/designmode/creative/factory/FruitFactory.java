package com.jtli.practice.designmode.creative.factory;

/**
 * @Classname FruitFactory
 * @Description <p>
 * 根据迪米特法则，我们应该尽可能地少与其他类进行交互，
 * 所以我们可以将那些需要频繁出现的对象创建，封装到一个工厂类中，
 * 当我们需要对象时，直接调用工厂类中的工厂方法来为我们生成对象，
 * 这样，就算类出现了变动，我们也只需要修改工厂中的代码即可，而不是大面积地进行修改。
 * </p>
 * @Date 2023/2/19 10:41
 * @Author by jtlee
 * @Version 1.0.0
 */
public class FruitFactory {

    /**
     * 这里就直接来一个静态方法根据指定类型进行创建
     * @param type 水果类型
     * @return 对应的水果对象
     */
    public static Fruit getFruit(String type) {
        switch (type) {
            case "苹果":
                return new Apple();
            case "橘子":
                return new Orange();
            default:
                return null;
        }
    }
}
