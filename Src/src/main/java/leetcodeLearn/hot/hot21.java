package leetcodeLearn.hot;

/**
 * @author wsj
 * @description 240、搜索二维矩阵2
 * @date 2024年05月08日 22:21
 */
public class hot21 {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24}, {18,21,23,26,30}};
        int target = 30;
        boolean res = searchMatrix(matrix, target);
        System.out.println(res);
    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        //每一行查找
        for(int[] nums : matrix) {
            if(search(nums, target)) {
                return true;
            }
        }
        return false;
    }
    // 二分查找:如果能找到，返回它的下表；如果不能找到，返回插入它的位置
    static boolean search(int[] matrix, int target) {
        int m = matrix.length;
        int left = 0, right = m - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if(target == matrix[mid]) {
                return true;
            } else if(target > matrix[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    // 避免使用分情况讨论，复杂了；一般都有技巧
    // 二分查找:如果能找到，返回它的下表；如果不能找到，返回插入它的位置
    static int searchIndex(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int min = Math.min(m, n);
        int left = 0, right = min - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if(target == matrix[mid][mid]) {
                return mid;
            } else if(target > matrix[mid][mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right + 1;
    }

}
