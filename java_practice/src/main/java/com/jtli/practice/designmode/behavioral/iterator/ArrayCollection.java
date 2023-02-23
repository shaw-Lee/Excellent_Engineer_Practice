package com.jtli.practice.designmode.behavioral.iterator;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @Classname ArrayCollection
 * @Description <p>
 *      TODO
 * </p>
 * @Date 2023/2/22 21:06
 * @Author by jtlee
 * @Version 1.0.0
 */
public class ArrayCollection<T> implements Iterable<T> {

    private final T[] array;

    public static <T> ArrayCollection<T> of (T[] array) {
        return new ArrayCollection<>(array);
    }
    public ArrayCollection(T[] array) {
        this.array = array;
    }

    @Override
    public Iterator<T> iterator() {    //需要实现iterator方法，此方法会返回一个迭代器，用于迭代我们集合中的元素
        return new ArrayIterator();
    }

    public class ArrayIterator implements Iterator<T> {   //这里实现一个，注意别用静态，需要使用对象中存放的数组
        private int cur = 0;   //这里我们通过一个指针表示当前的迭代位置

        @Override
        public boolean hasNext() {     //判断是否还有下一个元素
            return cur < array.length;   //如果指针大于或等于数组最大长度，就不能再继续了
        }

        @Override
        public T next() {   //返回当前指针位置的元素并向后移动一位
            return array[cur++];   //正常返回对应位置的元素，并将指针自增
        }
    }
}
