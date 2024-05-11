package test.testThread;

import java.util.concurrent.atomic.AtomicInteger;

public class casDemo {
    private static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {
        // 创建两个线程，分别对counter进行递增操作
        Thread thread1 = new Thread(() -> {
            int expected = counter.get(); // 读取当前值
            int newValue = expected + 1;   // 计算新值
            if (counter.compareAndSet(expected, newValue)) { // CAS操作
                System.out.println("Thread 1 updated counter successfully.");
            } else {
                System.out.println("Thread 1 failed to update counter.");
            }
        });

        Thread thread2 = new Thread(() -> {
            int expected = counter.get(); // 读取当前值
            int newValue = expected + 1;   // 计算新值
            if (counter.compareAndSet(expected, newValue)) { // CAS操作
                System.out.println("Thread 2 updated counter successfully.");
            } else {
                System.out.println("Thread 2 failed to update counter.");
            }
        });

        // 启动两个线程
        thread1.start();
        thread2.start();

        // 等待两个线程执行完成
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 打印最终的计数值
        System.out.println("Final counter value: " + counter.get());
    }
}

