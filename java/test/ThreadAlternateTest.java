package test;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程学习 - 交替数组打印（还差个保序，可以用CountDownLatch(1)，后执行的上来等待，先执行的减到0就countdown，保证顺序）
 * LockSupport.park/unpark 可用于唤醒阻塞线程
 * wait/notify === await/signal 需要先唤起其他线程再进入等待，为了所有线程都可以结束，记得唤起最后一个还在等待的线程
 * transferQueue 还没想到使用场景，但take/transfer的api还挺有意思的
 *
 * @author yanchuang
 * @date 2023/06/24
 */
public class ThreadAlternateTest {

    public static void main(String[] args) {
        char[] chars1 = new char[]{'A', 'B', 'C', 'D', 'E'};
        char[] chars2 = new char[]{'1', '2', '3', '4', '5'};

//        transferQueueTest(chars1, chars2);
//        System.out.println("-------------");
//        lockSupportTest(chars1, chars2);
//        System.out.println("-------------");
//        waitNotifyTest(chars1, chars2);
//        System.out.println("-------------");
        reentrantLockTest(chars1, chars2);
    }

    public static void reentrantLockTest(char[] chars1, char[] chars2) {
        Lock lock = new ReentrantLock();

        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();

        new Thread(() -> {
            lock.lock();
            try {
                for (char c : chars1) {
                    System.out.print(c);
                    c2.signal();
                    c1.await();
                }
                c2.signal(); // 必须，否则无法停下
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            lock.lock();
            try {
                for (char c : chars2) {
                    System.out.print(c);
                    c1.signal();
                    c2.await();
                }
                c1.signal();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }).start();
    }

    public static void waitNotifyTest(char[] chars1, char[] chars2) {
        Object o = new Object();

        new Thread(() -> {
            synchronized (o) {
                for (char c : chars1) {
                    System.out.print(c);
                    o.notify();
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                o.notify(); // 必须，否则无法停下
            }
        }, "t1").start();

        new Thread(() -> {
            synchronized (o) {
                for (char c : chars2) {
                    System.out.print(c);
                    o.notify();
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                o.notify();
            }
        }, "t2").start();
    }

    public static void transferQueueTest(char[] chars1, char[] chars2) {
        TransferQueue<Character> queue = new LinkedTransferQueue<>();

        new Thread(() -> {
            try {
                for (char c : chars1) {
                    // 必须拿到一个才能继续执行
                    System.out.print(queue.take());
                    queue.transfer(c);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "t1").start();

        new Thread(() -> {
            try {
                for (char c : chars2) {
                    queue.transfer(c);
                    System.out.print(queue.take());
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "t2").start();
        System.out.println();
    }

    static Thread t1 = null;
    static Thread t2 = null;

    public static void lockSupportTest(char[] chars1, char[] chars2) {

        t1 = new Thread(() -> {
            for (char c : chars1) {
                System.out.print(c);
                LockSupport.unpark(t2); // 叫醒t2，需要有线程将其park，才能unpark
                LockSupport.park(); // t1阻塞

            }
        }, "t1");

        t2 = new Thread(() -> {
            for (char c : chars2) {
                LockSupport.park(t2); // t2阻塞
                System.out.print(c);
                LockSupport.unpark(t1); // 叫醒t1
            }
        }, "t2");

        t1.start();
        t2.start();
        System.out.println();
    }
}
