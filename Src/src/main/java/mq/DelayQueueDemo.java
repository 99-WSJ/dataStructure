package mq;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @program: Src
 * @description: 延时队列——订单
 * @author: wsj
 * @create: 2024-09-10 23:54
 **/


// 订单类，实现 Delayed 接口
class Order implements Delayed {
    private String orderId;
    private long startTime;  // 延迟的到期时间

    public Order(String orderId, long delayInMilliseconds) {
        this.orderId = orderId;
        // 设置延迟时间，当前时间 + 指定的延迟时间
        this.startTime = System.currentTimeMillis() + delayInMilliseconds;
    }

    public String getOrderId() {
        return orderId;
    }

    // 计算剩余的延迟时间，还需要等多长时间
    @Override
    public long getDelay(TimeUnit unit) {
        long delay = startTime - System.currentTimeMillis();
        return unit.convert(delay, TimeUnit.MILLISECONDS);
    }

    // 定义比较规则，按到期时间排序
    @Override
    public int compareTo(Delayed o) {
        if (this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS)) {
            return -1;
        } else if (this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS)) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Order{" + "orderId='" + orderId + '\'' + ", startTime=" + startTime + '}';
    }
}

public class DelayQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        // 创建 DelayQueue 队列
        DelayQueue<Order> delayQueue = new DelayQueue<>();

        // 添加订单到队列中，订单延迟30秒后过期
        delayQueue.put(new Order("Order1", 5000)); // 5秒后处理
        delayQueue.put(new Order("Order2", 10000)); // 10秒后处理
        delayQueue.put(new Order("Order3", 15000)); // 15秒后处理
        delayQueue.put(new Order("Order22", 9000)); // 15秒后处理

        System.out.println("All orders added to the queue with delay...");

        // 消费队列中的订单
        while (!delayQueue.isEmpty()) {
            Order order = delayQueue.take();  // take() 方法会阻塞直到有订单到期
            System.out.println("Processing: " + order.getOrderId() + " at " + System.currentTimeMillis());
        }

        System.out.println("All orders processed.");
    }
}
