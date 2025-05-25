package handwrite;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: Src
 * @description: 原子类cas实现线程交替打印
 * 步骤：创建一个静态的原子类对象，新建三个线程，
 * 同时自旋查看该原子类的属性value是否符合判断条件，符合的话就打印对应的字符
 * @author: wsj
 * @create: 2025-01-16 12:26
 **/

public class ThreadPrint4 {
    // CAS共享变量，表示当前应该打印哪个字母：0代表A，1代表B，2代表C
    private static final AtomicInteger state = new AtomicInteger(0);

    public static void main(String[] args) {
        // 创建线程A
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    while (true) {
                        // 自旋判断当前是否轮到线程A
                        if (state.get() == 0) {
                            System.out.println("A");
                            // 更新状态到1 (轮到线程B)
                            state.compareAndSet(0, 1);
                            break;
                        }
                    }
                }
            }
        });

        // 创建线程B
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    while (true) {
                        // 自旋判断当前是否轮到线程B
                        if (state.get() == 1) {
                            System.out.println("B");
                            // 更新状态到2 (轮到线程C)
                            state.compareAndSet(1, 2);
                            break;
                        }
                    }
                }
            }
        });

        // 创建线程C
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    while (true) {
                        // 自旋判断当前是否轮到线程C
                        if (state.get() == 2) {
                            System.out.println("C");
                            // 更新状态到0 (轮到线程A)
                            state.compareAndSet(2, 0);
                            break;
                        }
                    }
                }
            }
        });

        // 启动线程
        threadA.start();
        threadB.start();
        threadC.start();
    }
}
