package test.testThread;

public class SleepWait {
    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread sleepThread = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Sleeping thread acquired lock");
                try {
                    System.out.println("sleep");
                    Thread.sleep(2000); // Sleep for 2 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Sleeping thread woke up");
            }
        });

        Thread waitThread = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Waiting thread acquired lock");
                try {
                    lock.wait(); // Wait indefinitely
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Waiting thread woke up");
            }
        });

        waitThread.start();
        sleepThread.start();

        try {
            Thread.sleep(500); // Give some time for threads to start
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Thread.sleep(6000);

        synchronized (lock) {
            System.out.println("notify");
            lock.notify(); // Notify the waiting thread
        }
    }
}

