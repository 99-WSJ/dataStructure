package test.testThread;

import java.util.concurrent.TimeUnit;

public class ThreadLocalDemo {
    // 创建一个ThreadLocal对象，存储线程局部变量
    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {
        // 创建并启动多个线程
        for (int i = 1; i <= 5; i++) {
            Thread thread = new Thread(() -> {
                // 获取当前线程的局部变量值
                int value = threadLocal.get();
                // 修改局部变量值
                value++;
                // 将修改后的值存储回ThreadLocal中
                threadLocal.set(value);
                // 输出线程名和局部变量值
                System.out.println(Thread.currentThread().getName() + ": " + value);
            });
            thread.start();
        }
    }
}

