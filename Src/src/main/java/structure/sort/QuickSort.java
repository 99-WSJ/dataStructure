package sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class QuickSort {

    public static void main(String[] args) {
        int maxSize = 10;
        int[] arr = new int[maxSize];
        System.out.println("排序前：");
        for (int i = 0; i < maxSize; i++) {
            arr[i] = (int) (Math.random() * maxSize);
            System.out.print(arr[i] + " ");
        }
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        String dateStr1 = simpleDateFormat.format(data1);
        System.out.println("\n" + data1);

        System.out.println("\n排序后：");
        sort(arr,0,arr.length-1);
        Date data2 = new Date();
        for (int i = 0; i < maxSize; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void sort(int[] arr, int left, int right) {    //java值传递，非引用传递
        int l = left;
        int r = right;
        System.out.println("test");
        int pivot = arr[(left + right)/2];
        int temp = 0;
        int[] arr1 = {1,3,4};




    }

}
