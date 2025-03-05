package structure.sort;

import java.util.Arrays;
public class QuickSort {
    public static void quickSort(int[] arr, int l, int r) {
        if(l < r) {
            int i = l, j = r,x = arr[l];
            while(i < j) {
                while(i < j && arr[j] > x) {
                    j--;
                }
                if(i < j) {
                    // [3, 1, 4, 1, 5, 9, 2, 6]
                    // 确保在指针 i 和 j 相遇或交叉时，不再进行交换操作，避免数组越界和逻辑错误
                    arr[i] = arr[j];
                    i++;
                }
                while(i < j && arr[i] < x) {
                    i++;
                }
                if(i < j) {
                    arr[j] = arr[i];
                    j--;
                }
            }
            arr[i] = x;
            for (int k =l ; k<=r; k++) {
                System.out.print(arr[k] + " ");
            }
            System.out.println();
            quickSort(arr, l, i-1);
            quickSort(arr, i+1, r);
        }
    }

    public static void main(String[] args) {
        int[] array = {3, 1, 4, 1, 5, 9, 2, 6};
        // int[] array = {6, 72, 113, 11, 23, 12, 52, 12, 9, 16, 5};
        quickSort(array, 0, array.length - 1);
        System.out.println("排序后的结果");
        System.out.println(Arrays.toString(array));
    }
}