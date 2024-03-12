package structure.search;

/**
 * @author wsj
 * @description 插值查找
 * @date 2023年12月19日 20:13
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        // int [] arr = new int[100];
        // for(int i = 0; i < 100; i++) {
        // arr[i] = i + 1;
        // }
        int arr[] = {1, 8, 10, 89, 1000, 1000, 1234};
        int index = insertValueSearch(arr, 0, arr.length - 1, 1234);
        //int index = binarySearch(arr, 0, arr.length, 1);
        System.out.println("index = " + index);
        //System.out.println(Arrays.toString(arr));
    }

    private static int insertValueSearch(int[] arr, int left, int right, int findVal) {
        //注意：findVal < arr[0] 和 findVal > arr[arr.length - 1] 必须需要
        //否则我们得到的 mid 可能越界
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }
        // 求出 mid, 自适应
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (findVal > midVal) { // 说明应该向右边递归
            return insertValueSearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) { // 说明向左递归查找
            return insertValueSearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }



}
