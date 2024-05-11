package test.testThread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class casABA {
    private static AtomicReference<String> atomicReference = new AtomicReference<>("A");

    public static void main(String[] args) throws InterruptedException {
        // 创建并启动线程1
        Thread thread1 = new Thread(() -> {
            atomicReference.compareAndSet("A", "B");
            atomicReference.compareAndSet("B", "A");
        });

        // 创建并启动线程2
        Thread thread2 = new Thread(() -> {
            try {
                // 线程2暂停1秒，以便观察线程1的操作
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 线程2尝试将A改为C，但此时共享变量已经被修改过，这是一种ABA问题
            boolean result = atomicReference.compareAndSet("A", "C");
            System.out.println("Thread 2 update result: " + result);
            // 应该输出false，但是因为ABA问题，输出了True
        });

        // 启动线程1和线程2
        thread1.start();
        thread2.start();

        // 等待线程1和线程2执行完成
        thread1.join();
        thread2.join();

        // 打印最终的共享变量值
        System.out.println("Final atomicReference value: " + atomicReference.get());
    }
}
