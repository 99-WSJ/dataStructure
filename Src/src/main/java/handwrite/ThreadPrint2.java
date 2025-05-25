package handwrite;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: Src
 * @description: Reentranlock和condition实现线程交替打印
 * @author: wsj
 * @create: 2025-01-16 12:25
 **/

public class ThreadPrint2 {
    // 创建可重入锁
    private static final Lock lock = new ReentrantLock();
    // 创建三个条件变量
    private static final Condition conditionA = lock.newCondition();
    private static final Condition conditionB = lock.newCondition();
    private static final Condition conditionC = lock.newCondition();
    // 表示当前该哪个线程执行：0 表示A，1 表示B，2 表示C
    private static int state = 0;

    public static void main(String[] args) {
        // 创建线程A
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 100; i++) {
                        lock.lock(); // 获取锁
                        while (state != 0) { // 检查是否轮到线程A
                            conditionA.await(); // 等待
                        }
                        System.out.println("A");
                        state = 1; // 修改状态为B
                        conditionB.signal(); // 唤醒线程B
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock(); // 释放锁
                }
            }
        });

        // 创建线程B
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 100; i++) {
                        lock.lock();
                        while (state != 1) { // 检查是否轮到线程B
                            conditionB.await();
                        }
                        System.out.println("B");
                        state = 2; // 修改状态为C
                        conditionC.signal(); // 唤醒线程C
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        // 创建线程C
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 100; i++) {
                        lock.lock();
                        while (state != 2) { // 检查是否轮到线程C
                            conditionC.await();
                        }
                        System.out.println("C");
                        state = 0; // 修改状态为A
                        conditionA.signal(); // 唤醒线程A
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        // 启动线程
        threadA.start();
        threadB.start();
        threadC.start();
    }
}
