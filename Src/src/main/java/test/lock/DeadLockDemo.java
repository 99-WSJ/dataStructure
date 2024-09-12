package test.lock;

import lombok.Data;

/**
 * @program: Src
 * @description: 死锁
 * 互斥、占有且等待、非抢占、循环等待
 * @author: wsj
 * @create: 2024-09-12 13:45
 *
 **/
 class DeadLockDemo {
    private static Object resource1 = new Object();//资源 1
    private static Object resource2 = new Object();//资源 2

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread() + "get resource1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource2");
                synchronized (resource2) {
                    System.out.println(Thread.currentThread() + "get resource2");
                }
            }
        }, "线程 1").start();

        new Thread(() -> {
            synchronized (resource2) {
                System.out.println("get resource2");
            }
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("waiting....");
            synchronized (resource1) {
                System.out.println(Thread.currentThread().getName() + "get 2");
            }
        });
    }
}
