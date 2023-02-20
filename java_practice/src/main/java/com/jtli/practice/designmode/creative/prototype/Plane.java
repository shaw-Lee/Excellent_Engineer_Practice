package com.jtli.practice.designmode.creative.prototype;

/**
 * @Classname Plane
 * @Description <p>
 *      TODO
 * </p>
 * @Date 2023/2/19 13:15
 * @Author by jtlee
 * @Version 1.0.0
 */
public class Plane implements Cloneable {

    private String x;

    private int y = 0;

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public Plane clone() throws CloneNotSupportedException {
        return (Plane) super.clone();
    }
}
