package test.testThread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

public class casABAsolve {
    private static AtomicStampedReference<String> atomicReference = new AtomicStampedReference<>("A", 0);

    public static void main(String[] args) throws InterruptedException {
        // 创建并启动线程1
        Thread thread1 = new Thread(() -> {
            int[] stampHolder = new int[1];
            String reference = atomicReference.get(stampHolder);
            // 获取当前版本号
            int currentStamp = stampHolder[0];
            atomicReference.compareAndSet(reference, "B", currentStamp, currentStamp + 1); // 修改为B
            stampHolder[0] = currentStamp + 1;
            reference = atomicReference.get(stampHolder);
            // 获取当前版本号
            currentStamp = stampHolder[0];
            atomicReference.compareAndSet(reference, "A", currentStamp, currentStamp + 1); // 修改回A
        });

        // 创建并启动线程2
        Thread thread2 = new Thread(() -> {
            try {
                // 线程2暂停1秒，以便观察线程1的操作
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int[] stampHolder = new int[1];
            String reference = atomicReference.get(stampHolder);
            // 获取当前版本号
            int currentStamp = stampHolder[0];
            // 线程2尝试将A改为C，但此时共享变量已经被修改过，所以修改失败
            boolean result = atomicReference.compareAndSet(reference, "C", currentStamp, currentStamp + 1);
            System.out.println("Thread 2 update result: " + result); // 应该输出false
        });

        // 启动线程1和线程2
        thread1.start();
        thread2.start();

        // 等待线程1和线程2执行完成
        thread1.join();
        thread2.join();

        // 打印最终的共享变量值
        System.out.println("Final atomicReference value: " + atomicReference.getReference());
    }
}

