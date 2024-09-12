package rateLimit;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @program: Src
 * @description: 令牌桶模拟
 * @author: wsj
 * @create: 2024-09-12 23:40
 **/

public class TokenBucketDemo {
    private int capacity;  // 桶的容量
    private int tokens;     // 当前桶中的令牌数量
    private int refillRate; // 令牌的补充速率（每秒几个令牌）

    public TokenBucketDemo(int capacity, int refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
        this.tokens = capacity;  // 初始令牌数量等于容量
        startRefilling();
    }

    // 每秒补充令牌
    private void startRefilling() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> {
            synchronized (this) {
                if (tokens < capacity) {
                    tokens++;
                    System.out.println("Added a token. Current tokens: " + tokens);
                }
            }
        }, 0, 1, TimeUnit.SECONDS);
    }

    // 请求令牌
    public synchronized boolean tryConsume() {
        if (tokens > 0) {
            tokens--;
            System.out.println("Token consumed. Remaining tokens: " + tokens);
            return true;
        } else {
            System.out.println("No tokens available.");
            return false;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 创建一个容量为5，补充速率为1秒一个令牌的令牌桶
        TokenBucketDemo tokenBucket = new TokenBucketDemo(3, 1);

        // 模拟请求
        for (int i = 0; i < 10; i++) {
            Thread.sleep(500); // 每500ms发出一个请求
            if (tokenBucket.tryConsume()) {
                System.out.println("Request " + (i + 1) + " allowed.");
            } else {
                System.out.println("Request " + (i + 1) + " denied.");
            }
        }
    }
}

