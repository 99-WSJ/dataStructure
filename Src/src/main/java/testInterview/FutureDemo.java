package testInterview;

import java.util.concurrent.*;

/**
 * @program: Src
 * @description: Future的底层原理
 * @author: wsj
 * @create: 2024-10-18 16:01
 **/

public class FutureDemo {

    public static void main(String[] args) throws Exception {
        // 创建一个线程池
        ExecutorService executor = Executors.newFixedThreadPool(1);
        // 初始化一个任务
        Callable<String> task = new Task();
        // 提交任务并获得Future的实例
        Future<String> future = executor.submit(task);
        // 从Future获取异步执行返回的结果(可能会阻塞等待结果)
        //String result = future.get(); // 获取结果（会阻塞等待）
        String result = future.get(1, TimeUnit.SECONDS);   // 在指定的时间内获取结果，如果超时，会抛异常并退出等待状态
        System.out.println("任务执行结果：" + result);

        // 任务执行完毕之后，关闭线程池（可选）
        executor.shutdown();
    }
}

class Task implements Callable<String> {

    @Override
    public String call() throws Exception {
        // 执行下载某文件任务，并返回文件名称
        Thread.currentThread().setName("wsj");
        System.out.println("thread name:" + Thread.currentThread().getName() + " 开始执行下载任务");
        Thread.sleep(2000);
        return "xxx.png";
    }
}