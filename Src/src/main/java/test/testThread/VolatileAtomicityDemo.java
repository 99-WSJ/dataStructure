package test.testThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *volatile 关键字能保证变量的可见性，
 * 但不能保证对变量的操作是原子性的。
 **/
public class VolatileAtomicityDemo {
    public volatile static int inc = 0;

    public void increase() {
        inc++;
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        VolatileAtomicityDemo volatileAtomicityDemo = new VolatileAtomicityDemo();
        for (int i = 0; i < 5; i++) {
            threadPool.execute(() -> {
                for (int j = 0; j < 500; j++) {
                    volatileAtomicityDemo.increase();
                }
            });
        }
        // 等待1.5秒，保证上面程序执行完成
        Thread.sleep(1500);
        System.out.println(inc);
        threadPool.shutdown();
    }

    // 打印结果都小于2500；这是因为volatile ，无法保证inc++具有原子性
    // 利用 synchronized、Lock或者AtomicInteger都可以。

    //public synchronized void increase() {
    //    inc++;
    //}

    //public AtomicInteger inc = new AtomicInteger();
    //
    //public void increase() {
    //    inc.getAndIncrement();
    //}

    //Lock lock = new ReentrantLock();
    //public void increase() {
    //    lock.lock();
    //    try {
    //        inc++;
    //    } finally {
    //        lock.unlock();
    //    }
    //}



}
