package test.testThread;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

// 实现Delayed接口定义延迟任务
class DelayedTask implements Delayed {
    private String taskName;
    private long executeTime;

    public DelayedTask(String taskName, long delay) {
        this.taskName = taskName;
        this.executeTime = System.currentTimeMillis() + delay;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long diff = executeTime - System.currentTimeMillis();
        return unit.convert(diff, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        long diff = this.executeTime - ((DelayedTask) o).executeTime;
        return Long.compare(diff, 0);
    }

    public String getTaskName() {
        return taskName;
    }
}

public class DelayedWorkQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        DelayQueue<DelayedTask> delayedQueue = new DelayQueue<>();

        // 添加延迟任务到延迟队列
        delayedQueue.put(new DelayedTask("Task 1", 30000));
        delayedQueue.put(new DelayedTask("Task 2", 50000));
        delayedQueue.put(new DelayedTask("Task 3", 20000));

        // 从延迟队列中取出任务并执行
        while (!delayedQueue.isEmpty()) {
            DelayedTask task = delayedQueue.take();
            System.out.println("Executing task: " + task.getTaskName());
        }
    }
}

