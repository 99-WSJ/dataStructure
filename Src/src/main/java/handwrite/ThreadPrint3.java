package handwrite;

import java.util.concurrent.Semaphore;

/**
 * @program: Src
 * @description: 信号量实现线程交替打印
 * @author: wsj
 * @create: 2025-01-16 12:26
 **/


public class ThreadPrint3 {
    // 定义三个信号量，初始只有线程A的信号量可用
    private static final Semaphore semaphoreA = new Semaphore(1); // 线程A先执行
    private static final Semaphore semaphoreB = new Semaphore(0);
    private static final Semaphore semaphoreC = new Semaphore(0);

    public static void main(String[] args) {
        // 创建线程A
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 100; i++) {
                        semaphoreA.acquire(); // 获取信号量
                        System.out.println("A");
                        semaphoreB.release(); // 释放B的信号量
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // 创建线程B
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 100; i++) {
                        semaphoreB.acquire(); // 获取信号量
                        System.out.println("B");
                        semaphoreC.release(); // 释放C的信号量
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // 创建线程C
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 100; i++) {
                        semaphoreC.acquire(); // 获取信号量
                        System.out.println("C");
                        semaphoreA.release(); // 释放A的信号量
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // 启动线程
        threadA.start();
        threadB.start();
        threadC.start();
    }
}
