package sort;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class BubbleSort {
    public static void main(String[] args) {
        int maxSize = 3;
        int[] arr = new int[maxSize];
        System.out.println("排序前：");
        for (int i = 0; i <maxSize ; i++) {
            arr[i] = (int)(Math.random() * maxSize);
            System.out.print(arr[i]+" ");
        }
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        String dateStr1 = simpleDateFormat.format(data1);
        System.out.println("\n"+data1);

        System.out.println("\n排序后：");
        sort1(arr);
        Date data2 = new Date();
//        String dateStr2 = simpleDateFormat.format(data2);
//        System.out.println(dateStr2);
//        int[] newArr = sort1(arr);
        for (int i = 0; i <maxSize ; i++) {
            System.out.print(arr[i]+ " ");
        }


    }

    /**
     * 改进
     * @param arr
     */

    private static void sort1(int[] arr) {
        int temp;
        boolean flag = false;
        for (int j = 0; j < arr.length-1; j++) {
            for (int i = 0; i < arr.length -1-j; i++) {
                if(arr[i] > arr[i+1]) {
                    flag = true;
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;

                }

            }
            if(!flag) {
                break;
            } else {
                flag = false;
            }



        }

    }

    /**
     * 简单冒泡
     * @param arr  待排序的数组
     */
    private static void sort(int[] arr) {
        int temp;
        for (int j = 0; j < arr.length-1; j++) {
            for (int i = 0; i < arr.length -1; i++) {
                if(arr[i] > arr[i+1]) {
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;

                }
            }
        }

    }
}
