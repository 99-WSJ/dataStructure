package test.testThread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo4 {
    public static void main(String[] args) {
        // 创建一个ThreadPoolExecutor，手动配置参数
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2, // 核心线程数
                5, // 最大线程数
                60, // 线程空闲时间
                TimeUnit.SECONDS, // 时间单位
                new LinkedBlockingQueue<>() // 任务队列
        );

        // 提交任务给线程池
        for (int i = 0; i < 10; i++) {
            executor.submit(new Task(i));
        }

        // 关闭线程池
        executor.shutdown();
    }

    static class Task implements Runnable {
        private int taskId;

        public Task(int id) {
            this.taskId = id;
        }

        @Override
        public void run() {
            System.out.println("Task " + taskId + " is running in thread: " + Thread.currentThread().getName());
        }
    }
}
