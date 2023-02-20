package com.jtli.practice.designmode.creative.builder;

/**
 * @Classname Mobile
 * @Description <p>
 * 将一个复杂对象的构建与其表示分离，使得同样的构建过程可以创建不同的表示
 * </p>
 * @Date 2023/2/19 11:43
 * @Author by jtlee
 * @Version 1.0.0
 */
public class Mobile {
    private  String type;

    private int version;

    private String model;

    private String price;

    private String specific;

    public Mobile() {
    }

    public Mobile(String type, int version, String model, String price, String specific) {
        this.type = type;
        this.version = version;
        this.model = model;
        this.price = price;
        this.specific = specific;
    }

    public static MobileBuilder builder () {
        return new MobileBuilder();
    }
    public static  class MobileBuilder {
        private  String type;
        private int version;
        private String model;
        private String price;
        private String specific;

        public MobileBuilder type(String type) {
            this.type = type;
            return this;
        }

        public MobileBuilder version(int version) {
            this.version = version;
            return  this;
        }
        public MobileBuilder model(int version) {
            this.model = model;
            return  this;
        }
        public MobileBuilder price(int version) {
            this.price = price;
            return  this;
        }
        public MobileBuilder specific(int version) {
            this.specific = specific;
            return  this;
        }

        public Mobile build() {
            return  new Mobile(this.type,this.version,this.model,this.price,this.specific);
        }

    }
}
