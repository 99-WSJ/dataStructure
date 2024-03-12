package structure.queue;

public class ArrayQueue {


    private int maxSize;
    private int front;
    private int rear;
    private  int[] arr;

    public  ArrayQueue(int arrMaxSize)  {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;

    }
    // full
    public boolean isFull() {
        return rear == maxSize -1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("isFull");
            return;
        }

        rear++;
        arr[rear] = n;

    }

    public int getQueue() {
        if (isEmpty())  {
            throw new RuntimeException("isEmpty");
        }
        front++;
        return arr[front];
    }

    public void showQueue() {
       if(isEmpty())     {
           throw new RuntimeException("isEmpty");
       }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public int headQueue() {
        if(isEmpty()) {
            System.out.println("isEmpty");
        }
        return arr[front+1];
    }
}
