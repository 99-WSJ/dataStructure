package scene.design;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: Src
 * @description: 定时器设置
 * @author: wsj
 * @create: 2024-10-19 16:33
 **/
public class TimerDemo {

    private class TimerTask {
        long executeTime; // 任务的执行时间
        Runnable task;    // 要执行的任务

        TimerTask(long delay, Runnable task) {
            this.executeTime = System.currentTimeMillis() + delay;
            this.task = task;
        }
    }

    private PriorityQueue<TimerTask> taskQueue;
    private volatile boolean running;

    public TimerDemo() {
        // 初始化任务队列，按照执行时间排序
        taskQueue = new PriorityQueue<>(Comparator.comparingLong(t -> t.executeTime));
        running = false;
    }

    /**
     * 调度一个任务
     * @param task  要执行的任务
     * @param delay 延迟时间，单位毫秒
     */
    public void schedule(Runnable task, long delay) {
        synchronized (taskQueue) {
            taskQueue.add(new TimerTask(delay, task));
            taskQueue.notify(); // 通知定时器线程有新任务加入
        }
    }

    /**
     * 启动定时器
     */
    public void start() {
        running = true;
        Thread timerThread = new Thread(() -> {
            while (running) {
                TimerTask currentTask;
                synchronized (taskQueue) {
                    while (taskQueue.isEmpty()) {
                        try {
                            taskQueue.wait(); // 队列为空时等待
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }

                    long currentTime = System.currentTimeMillis();
                    currentTask = taskQueue.peek();

                    if (currentTask.executeTime <= currentTime) {
                        taskQueue.poll(); // 取出并移除任务
                    } else {
                        try {
                            // 等待直到下一个任务的执行时间
                            taskQueue.wait(currentTask.executeTime - currentTime);
                            continue; // 等待结束后继续循环
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                }

                // 执行任务
                if (currentTask != null) {
                    currentTask.task.run();
                }
            }
        });
        timerThread.start();
    }

    /**
     * 停止定时器
     */
    public void stop() {
        running = false;
        synchronized (taskQueue) {
            taskQueue.notify(); // 唤醒可能正在等待的线程
        }
    }

    public static void main(String[] args) {
        TimerDemo timer = new TimerDemo();
        timer.start();

        // 调度多个任务
        timer.schedule(() -> System.out.println("任务1执行！"), 2000);
        timer.schedule(() -> System.out.println("任务2执行！"), 1000);
        timer.schedule(() -> System.out.println("任务3执行！"), 3000);

        // 主线程等待5秒后停止定时器
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        timer.stop();
        System.out.println("定时器已停止");
    }
}
