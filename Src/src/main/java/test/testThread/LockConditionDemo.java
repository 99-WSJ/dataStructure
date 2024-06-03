package test.testThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class LockConditionDemo {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        Thread waitingThread = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("Waiting thread is waiting for the condition...");
                condition.await(); // 等待条件
                System.out.println("Waiting thread has been notified and is resuming execution.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
        });

        waitingThread.start();

        // 主线程等待一段时间后通知等待线程
        try {
            Thread.sleep(2000); // 模拟一些操作
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        lock.lock();
        try {
            System.out.println("Main thread is notifying the waiting thread.");
            condition.signal(); // 通知等待线程
        } finally {
            lock.unlock();
        }
    }
}
