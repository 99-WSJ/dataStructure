package test.testThread;

public class VolatileDemo {
    private static volatile boolean flag = false;

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1 started " + flag);
            while (!flag) {
                // 空循环，等待flag变为true
            }
            System.out.println("Thread 1 finished " + flag);
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("Thread 2 started " + flag);
            try {
                Thread.sleep(2000); // 让线程1有足够的时间启动并进入等待状态
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = true; // 修改flag的值
            System.out.println("Thread 2 set flag to true " + flag);
        });

        thread1.start();
        thread2.start();
    }
}

