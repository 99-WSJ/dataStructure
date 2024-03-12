package sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SelectSort {
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
        Date data2 = new Date();
        for (int i = 0; i < maxSize; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int temp = arr[i];
            int index = i;         //加一个变量描述最小值的下标
            for (int j = i; j < arr.length-1; j++) {
                if(arr[j+1]<= temp) {
                    temp = arr[j+1];
                    index = j+1;
                }

            }
            arr[index] = arr[i];
            arr[i] = temp;

        }

    }

}