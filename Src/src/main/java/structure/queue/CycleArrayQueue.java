package structure.queue;

public class CycleArrayQueue {

    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CycleArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;

    }

    // full
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("isFull");
            return;
        }


        arr[rear] = n;
        rear = (rear + 1) % maxSize;

    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("isEmpty");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    public void showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("isEmpty");
        }
        for (int i = front; i < front + size(); i++) {
            System.out.println(arr[i % maxSize]);
        }
    }

    //求出当前队列的有效个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    public int headQueue() {
        if (isEmpty()) {
            System.out.println("isEmpty");
        }
        return arr[front];
    }
}
