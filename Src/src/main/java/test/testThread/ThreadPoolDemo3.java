package test.testThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 使用Executors.newSingleThreadExecutor()创建一个单线程的线程池，
// 保证任务顺序执行：
public class ThreadPoolDemo3 {
    public static void main(String[] args) {
        // 创建一个单线程的线程池
        ExecutorService executor = Executors.newSingleThreadExecutor();

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
