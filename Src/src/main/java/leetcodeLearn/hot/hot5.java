package leetcodeLearn.hot;

/**
 * @author wsj
 * @description  11、盛最多水的容器
 * @date 2024年04月21日 14:14
 */
public class hot5 {
    public static void main(String[] args) {
        int[] nums = {1,8,6,2,5,4,8,3,7};
        int res = fuc(nums);
        System.out.println(res);
    }
    // 暴力超时
    /*
    private static int fuc(int[] height) {
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                res = Math.max(res, Math.min(height[i] , height[j]) * (j - i));
            }
        }
        return res;
    }
    */

    private static int fuc(int[] height) {
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                if(height[j] < height[i]) {
                    res = Math.max(res,height[j] * (j - i));
                } else {

                    res = Math.max(res,height[i] * (j - i));
                }
            }
        }
        return res;
    }
}
