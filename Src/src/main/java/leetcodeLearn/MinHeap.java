package leetcodeLearn;

/**
 * @program: Src
 * @description: 最小堆
 * 一种特殊的完全二叉树数据结构，在这种结构中，对于任意节点，其值都小于或等于它的子节点的值。
 * 根节点是堆中的最小元素。最小堆常用于实现优先队列，以及堆排序算法。
 * @author: wsj
 * @create: 2024-09-26 10:29
 **/

import java.util.Arrays;

public class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    // 构造函数，接收一个数组，构建最小堆
    public MinHeap(int[] arr) {
        this(arr.length);
        for (int value : arr) {
            insert(value);
        }
    }

    public void insert(int value) {
        ensureCapacity();
        heap[size] = value;
        siftUp(size);
        size++;
    }

    private void ensureCapacity() {
        if (size == heap.length) {
            int newCapacity = heap.length * 2;
            heap = Arrays.copyOf(heap, newCapacity);
            capacity = newCapacity;
        }
    }

    public int extractMin() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        siftDown(0);
        return min;
    }

    private void siftUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap[parentIndex] > heap[index]) {
                swap(parentIndex, index);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    private void siftDown(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int smallest = index;

        if (leftChildIndex < size && heap[leftChildIndex] < heap[smallest]) {
            smallest = leftChildIndex;
        }
        if (rightChildIndex < size && heap[rightChildIndex] < heap[smallest]) {
            smallest = rightChildIndex;
        }
        if (smallest != index) {
            swap(index, smallest);
            siftDown(smallest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void printHeap() {
        System.out.println(Arrays.toString(Arrays.copyOf(heap, size)));
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        MinHeap heap = new MinHeap(arr);

        System.out.println("Initial heap:");
        heap.printHeap();

        System.out.println("\nExtracted min: " + heap.extractMin());
        System.out.println("Heap after extraction:");
        heap.printHeap();

        System.out.println("\nInserting 3:");
        heap.insert(3);
        heap.printHeap();

        System.out.println("\nHeap size: " + heap.getSize());
        System.out.println("Is heap empty?\n " + heap.isEmpty());
    }
}


