package com.jtli.practice.juc.custom;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Classname Mylock
 * @Description <p>
 *      自定义锁
 * </p>
 * @Date 2023/3/1 20:32
 * @Author by jtlee
 * @Version 1.0.0
 */
public class Mylock {

    public static void main(String[] args) throws InterruptedException {

    }

    /**
     * 自行实现一个最普通的独占锁
     * 要求：同一时间只能有一个线程持有锁，不要求可重入
     */
    private static class MyLock implements Lock {

        /**
         * 设计思路：
         * 1. 锁被占用，那么exclusiveOwnerThread应该被记录，并且state = 1
         * 2. 锁没有被占用，那么exclusiveOwnerThread为null，并且state = 0
         */
        private static class Sync extends AbstractQueuedSynchronizer {
            @Override
            protected boolean tryAcquire(int arg) {
                if (isHeldExclusively()) return true;     //无需可重入功能，如果是当前线程直接返回true
                if (compareAndSetState(0, arg)) {    //CAS操作进行状态替换
                    setExclusiveOwnerThread(Thread.currentThread());    //成功后设置当前的所有者线程
                    return true;
                }
                return false;
            }

            @Override
            protected boolean tryRelease(int arg) {
                if (getState() == 0)
                    throw new IllegalMonitorStateException();   //没加锁情况下是不能直接解锁的
                if (isHeldExclusively()) {     //只有持有锁的线程才能解锁
                    setExclusiveOwnerThread(null);    //设置所有者线程为null
                    setState(0);    //状态变为0
                    return true;
                }
                return false;
            }

            @Override
            protected boolean isHeldExclusively() {
                return getExclusiveOwnerThread() == Thread.currentThread();
            }

            protected Condition newCondition() {
                return new ConditionObject();    //直接用现成的
            }
        }

        private final Sync sync = new Sync();

        @Override
        public void lock() {
            sync.acquire(1);
        }

        @Override
        public void lockInterruptibly() throws InterruptedException {
            sync.acquireInterruptibly(1);
        }

        @Override
        public boolean tryLock() {
            return sync.tryAcquire(1);
        }

        @Override
        public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
            return sync.tryAcquireNanos(1, unit.toNanos(time));
        }

        @Override
        public void unlock() {
            sync.release(1);
        }

        @Override
        public Condition newCondition() {
            return sync.newCondition();
        }
    }
}
