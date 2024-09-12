package rateLimit;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @program: Src
 * @description: 漏桶模拟
 * @author: wsj
 * @create: 2024-09-13 00:12
 **/

public class LeakyBucketDemo {
    private int capacity; // 桶的容量
    private int water;    // 当前桶中的水（请求数）
    private int outRate;  // 漏桶的漏出速率（每秒处理的请求数）

    public LeakyBucketDemo(int capacity, int outRate) {
        this.capacity = capacity;
        this.outRate = outRate;
        this.water = 0;
        startLeaking();
    }

    // 模拟漏水过程，即以固定速率处理请求
    private void startLeaking() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> {
            synchronized (this) {
                if (water > 0) {
                    water -= outRate;
                    if (water < 0) {
                        water = 0;
                    }
                    System.out.println("Processed " + outRate + " requests. Remaining water (requests): " + water);
                }
            }
        }, 0, 1, TimeUnit.SECONDS); // 每秒执行一次
    }

    // 尝试向漏桶中加入请求（即水）
    public synchronized boolean addRequest() {
        if (water < capacity) {
            water++;
            System.out.println("Request added. Current water level: " + water);
            return true;
        } else {
            System.out.println("Bucket full! Request denied.");
            return false;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 创建一个容量为10，漏出速率为1的漏桶
        LeakyBucketDemo leakyBucketDemo = new LeakyBucketDemo(10, 1);

        // 模拟请求，每隔300ms发出一个请求
        for (int i = 0; i < 20; i++) {
            Thread.sleep(300); // 每300ms发出一个请求
            if (leakyBucketDemo.addRequest()) {
                System.out.println("Request " + (i + 1) + " added.");
            } else {
                System.out.println("Request " + (i + 1) + " denied.");
            }
        }
    }
}

