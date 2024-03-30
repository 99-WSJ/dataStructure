package sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertSort {

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

    private static void sort(int[] arr) {    //java值传递，非引用传递
//        int[] arr1 = new int[arr.length];
//        int[] a = arr; //a=arr=[2234]
//        a[0] = 1; //a=arr=[1234]
//        int min = arr[0];
        int minIndex = 0;
        int temp = 0;
        for (int i = 1; i < arr.length; i++) {     //arr
            if(arr[i] <= arr[0]) {       //待插入值最小
                temp = arr[i];
                for (int k = i; k > 0; k--) {
                    arr[k] = arr[k-1];
                }

                arr[0] = temp;
            } else if (arr[i] >= arr[i-1]) {  //待插入值最大
                arr[i] = arr[i];
            } else {                           //待插入值在中间
                    for (int j = 1; j < i; j++) {          //arr1
                        if (arr[i]< arr[j]) {
                            minIndex = j;
                            temp = arr[i];
                            break;
                        }
                    }

                for (int k = i; k > minIndex; k--) {
                     arr[k] = arr[k-1];
                }
                arr[minIndex] = temp;
            }

        }
//       return arr1;
    }

}
