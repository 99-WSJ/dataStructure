package structure.sort;

import java.util.Arrays;
public class QuickSort {
    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int i = l;
            int j = r;
            int x = arr[i];
            while (i < j) {
                while (i < j && arr[j] > x) {
                    j--;
                }
                if (i < j) {
                    arr[i] = arr[j];
                    i++;
                }
                while (i < j && arr[i] < x) {
                    i++;
                }
                if(i < j) {
                    arr[j] = arr[i];
                    j--;
                }
            }
            arr[i] = x;
            quickSort(arr, l, i-1);
            quickSort(arr, i + 1, r);
        }
    }

    public static void main(String[] args) {
        int[] array = {6, 72, 113, 11, 23, 12, 52, 12, 9, 16, 5};
        quickSort(array, 0, array.length - 1);
        System.out.println("排序后的结果");
        System.out.println(Arrays.toString(array));
    }
}