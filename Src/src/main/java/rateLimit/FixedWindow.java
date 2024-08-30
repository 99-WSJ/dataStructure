package rateLimit;

/**
 * @program: Src
 * @description: 限流算法——固定窗口
 *
 * 在单位时间内维护的计数器来控制该时间单位内的最大访问量。
 * 易于实现；并且内存占用小，我们只需要存储时间窗口中的计数即可；
 * 它能够确保处理更多的最新请求，不会因为旧请求的堆积导致新请求被饿死。
 * 当然也面临着临界问题，当两个窗口交界处，瞬时流量可能为2n
 *
 * @author: wsj
 * @create: 2024-08-27 16:46
 **/
public class FixedWindow  extends MyRateLimiter {
    /**
     * 每秒限制请求数
     */
    private final long permitsPerSecond;
    /**
     * 上一个窗口的开始时间
     */
    public long timestamp = System.currentTimeMillis();
    /**
     * 计数器
     */
    private int counter;


    public FixedWindow(long permitsPerSecond) {
        this.permitsPerSecond = permitsPerSecond;
    }

    @Override
    public synchronized boolean tryAcquire() {
        long now = System.currentTimeMillis();
        // 窗口内请求数量小于阈值，更新计数放行，否则拒绝请求
        if (now - timestamp < 1000) {
            if (counter < permitsPerSecond) {
                counter++;
                return true;
            } else {
                return false;
            }
        }
        // 时间窗口过期，重置计数器和时间戳
        counter = 0;
        timestamp = now;
        return true;
    }
}

