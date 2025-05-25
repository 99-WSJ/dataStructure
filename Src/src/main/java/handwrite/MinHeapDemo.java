package handwrite;

import java.util.Arrays;

/**
 * @program: Src
 * @description: 最小堆
 * @author: wsj
 * @create: 2024-09-27 09:24
 **/
public class MinHeapDemo {

}

class Heap{
   private int size;
   private int[] heap;
   private int capacity;

   public Heap(int len){
       this.capacity = len;
       heap = new int[len];
       size = 0;
   }

   public Heap(int[] arr){
       this(arr.length);
       for(int i : arr) {
           insert(i);
       }
   }
   public void ensureCapacity(){
       if (size == heap.length) {
           int newCapacity = heap.length * 2;
           heap = Arrays.copyOf(heap, newCapacity);
           capacity = newCapacity;
       }
   }

    private void insert(int value) {
       ensureCapacity();
       heap[size] = value;
       up(size);
       size++;
    }

    private void up(int index) {
       while( index > 0) {
           int parent = (index - 1) / 2;
           if(heap[index] < heap[parent]) {
               int temp = heap[index];
               heap[index] = heap[parent];
               heap[parent] = temp;
               index = parent;
           } else {
               break;
           }
       }
    }

    public int extraMin() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;
       down(0);
       return min;
    }

    private void down(int index) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * (index + 1);

        int small = index;
        if (leftChild < size && heap[leftChild] < heap[small]) {
            small = leftChild;
        }
        if (rightChild < size && heap[rightChild] < heap[small]) {
            small = rightChild;
        }
        if (small != index) {
            int temp = heap[index];
            heap[index] = heap[small];
            heap[small] = temp;
            down(small);
        }
    }

    public int getSize() {
       return size;
    }
    public boolean isEmpty() {
       return size == 0;
    }


}
