package test.testThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableBlock {

    public static void main(String[] args) {
        // 创建一个Callable任务
        Callable<Integer> callableTask = () -> {
            try {
                // 模拟耗时操作
                System.out.println("sleeping 3s");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 123;
        };

        // 创建一个FutureTask来管理Callable任务
        FutureTask<Integer> futureTask = new FutureTask<>(callableTask);

        // 创建并启动一个线程来执行FutureTask
        Thread thread = new Thread(futureTask);
        thread.start();

        // 在这里，我们调用futureTask.get()来获取结果
        try {
            System.out.println("Task result: " + futureTask.get()); // 此处会阻塞直到任务完成
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread continues...");
    }
}

