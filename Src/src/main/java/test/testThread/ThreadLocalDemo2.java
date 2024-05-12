package test.testThread;

public class ThreadLocalDemo2 {
    // 创建两个 ThreadLocal 对象
    private static ThreadLocal<String> threadLocal1 = new ThreadLocal<>();
    private static ThreadLocal<Integer> threadLocal2 = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        // 在主线程中设置数据到 threadLocal1 和 threadLocal2
        threadLocal1.set("Hello");
        threadLocal2.set(42);

        // 创建一个新线程
        Thread thread = new Thread(() -> {
            // 在新线程中获取和输出存储在 threadLocal1 和 threadLocal2 中的数据
            System.out.println("ThreadLocal 1 in new thread: " + threadLocal1.get());
            System.out.println("ThreadLocal 2 in new thread: " + threadLocal2.get());
        });

        // 启动新线程
        thread.start();
        Thread.sleep(1000);

        // 等待新线程执行完成
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 清除主线程中的 threadLocal1 和 threadLocal2 存储的数据
        //threadLocal1.remove();
        //threadLocal2.remove();

        // 在主线程中尝试获取已清除的数据
        System.out.println("ThreadLocal 1 in main thread after removal: " + threadLocal1.get());
        System.out.println("ThreadLocal 2 in main thread after removal: " + threadLocal2.get());
    }
}