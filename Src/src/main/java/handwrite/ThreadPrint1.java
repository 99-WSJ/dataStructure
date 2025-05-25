package handwrite;

/**
 * @program: Src
 * @description: 三个线程交替打印abc，Synchronized+wait/notifyAll
 * 创建共享变量和锁对象，新建三个线程，如果一个线程获取了锁对象，则进入代码块，
 * 判断是否符合
 * @author: wsj
 * @create: 2025-01-16 11:51
 **/
public class ThreadPrint1 {
    private static int state = 0;
    // state不用volatile修饰，通过synchronized也可以保证线程的可见性
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    synchronized (lock) {
                        while(state % 3 !=0) {
                            try {
                                System.out.println("Thread A: Waiting...");
                                lock.wait(); // wait 释放锁并进入等待，放弃cpu争夺权
                                System.out.println("Thread A: Woke up!");
                                //System.out.println("不满足打印A的条件");
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("A   " + state);
                        state++;
                        lock.notifyAll();
                    }
                }
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 100; i++) {
                        synchronized (lock) {
                            while (state % 3 != 1) {
                                System.out.println("Thread B: Waiting...");
                                lock.wait(); // wait 释放锁并进入等待，放弃cpu争夺权
                                System.out.println("Thread B: Woke up!");
                            }
                            System.out.println("B   " + state);
                            state++;
                            lock.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 100; i++) {
                        synchronized (lock) {
                            while (state % 3 != 2) {
                                System.out.println("Thread C: Waiting...");
                                lock.wait(); // wait 释放锁并进入等待，放弃cpu争夺权
                                System.out.println("Thread C: Woke up!");
                            }
                            System.out.println("C   " + state);
                            state++;
                            lock.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
    }
}
