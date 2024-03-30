package structure.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wsj
 * @description 二分查找，有序
 * @date 2023年12月19日 15:27
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 9, 10, 10, 10, 78, 90, 110, 390, 450, 451, 453};
        int target = 10;
//        int index = binarySearch(arr, 0, arr.length - 1, target);
        List<Integer> resIndexList = binarySearch2(arr, 0, arr.length - 1, target);
        System.out.println("resIndexList=" + resIndexList);
//        if (index == -1) {
//            System.out.println("没有找到");
//        } else {
//            System.out.println("下标为" + index);
//        }
    }

    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        // 当 left > right 时，说明递归整个数组，但是没有找到
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (findVal > midVal) { // 向 右递归
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) { // 向左递归
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }


    }

    public static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {
        // 当 left > right 时，说明递归整个数组，但是没有找到
        if (left > right) {
            return new ArrayList<Integer>();
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (findVal > midVal) { // 向 右递归
            return binarySearch2(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) { // 向左递归
            return binarySearch2(arr, left, mid - 1, findVal);
        } else {
            // * 思路分析
            // * 1. 在找到 mid 索引值，不要马上返回
            // * 2. 向 mid 索引值的左边扫描，将所有满足 1000， 的元素的下标，加入到集合 ArrayList
            // * 3. 向 mid 索引值的右边扫描，将所有满足 1000， 的元素的下标，加入到集合 ArrayList
            // * 4. 将 Arraylist 返回
            List<Integer> resIndexlist = new ArrayList<Integer>();
            //向 mid 索引值的左边扫描，将所有满足 1000， 的元素的下标，加入到集合 ArrayList
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findVal) {//退
                    break;
                }

                //否则，就 temp 放入到 resIndexlist
                resIndexlist.add(temp);
                temp -= 1; //temp 左移
            }
            resIndexlist.add(mid); //
            //向 mid 索引值的右边扫描，将所有满足 1000， 的元素的下标，加入到集合 ArrayList
            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findVal) {//退出
                    break;
                }
                //否则，就 temp 放入到 resIndexlist
                resIndexlist.add(temp);
                temp += 1; //temp 右移
            }
            return resIndexlist;
        }
    }
}



