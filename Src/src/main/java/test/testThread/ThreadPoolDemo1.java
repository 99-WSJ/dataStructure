package test.testThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;

// newFixedThreadPool方式
// 使用Executors.newFixedThreadPool()创建固定大小的线程池：
public class ThreadPoolDemo1 {
    public static void main(String[] args) {
        // 创建一个固定大小为5的线程池
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // 提交任务给线程池
        for (int i = 0; i < 20; i++) {
            executor.submit(new Task(i));
        }
        String str;
        StringBuilder s = new StringBuilder();
        StringBuffer p;

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
