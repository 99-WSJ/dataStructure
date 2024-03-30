package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShellSort {
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
        sort(arr);
//        arr = sort(arr);
        Date data2 = new Date();
        for (int i = 0; i < maxSize; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void sort(int[] arr) {    //交换法
        int temp;
        for (int gap = arr.length/2; gap > 0; gap=gap/2) {
            for (int i = gap; i < arr.length ; i++) {
                for (int j = i-gap; j >=0 ; j=j-gap) {
                    if(arr[j] > arr[j+gap]) {
                        temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }
                }

            }
            System.out.println("ShellSort: " + Arrays.toString(arr));
        }
    }
    private static void sort1(int[] arr) {        //移位法
        for (int gap = arr.length/2; gap > 0; gap=gap/2) {
            for (int i = gap; i < arr.length ; i++) {
                int j = i;
                int temp = arr[j];
                if(arr[j] < arr[j-gap]) {
                    while(j - gap >= 0 && temp < arr[j - gap]) {
                        arr[j] = arr [j-gap];
                        j -= gap;
                    }
                    //当退出循环while，给temp找到插入的位置
                    arr[j] = temp;
                }

            }
            System.out.println("ShellSort: " + Arrays.toString(arr));
        }
    }

}
