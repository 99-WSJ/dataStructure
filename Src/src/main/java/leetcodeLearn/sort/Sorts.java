package leetcodeLearn.sort;

/**
 * @author wsj
 * @description
 * @date 2024年04月29日 22:35
 */
public class Sorts {
    public static void main(String[] args) {
//        int[] nums = {7,4,2,6,8,4,7,9,10,12,1,1,2};
        int[] nums = {3,1,2,4,5};
        selectionSort(nums);
        for(int i : nums) {
            System.out.print(i + " ");
        }
    }

    // 边找边交换
    private static void bubbleSort(int[] arr) {
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

    // 先找到最小的，看这个下标是不是在第一个，在，不用交换；不在就交换
    private static void selectionSort(int[] arr) {
        int temp;
        boolean flag = false;
        for (int i = 0; i < arr.length ; i++) {
            for (int j = i; j < arr.length ; j++) {
                if(arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

    }
}
