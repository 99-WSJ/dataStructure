package test.testThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//ThreadPoolDemo2
// 使用Executors.newCachedThreadPool()创建一个可缓存的线程池，
// 线程数量根据需要自动调整：
public class ThreadPoolDemo2 {
    public static void main(String[] args) {
        // 创建一个可缓存的线程池
        ExecutorService executor = Executors.newCachedThreadPool();

        // 提交任务给线程池
        for (int i = 0; i < 20; i++) {
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
