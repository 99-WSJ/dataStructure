package leetcodeLearn.hot.half2;

/**
 * @author wsj
 * @description 70. 爬楼梯
 * @date 2024年05月09日 15:36
 */
public class hot81 {
    public static void main(String[] args) {

    }
    public static int climbStairs(int n) {
        if(n<=2) return n;
        // int dp;
        int[] dp = new int[3];
        dp[1] = 1;
        dp[2] = 2;
        int sum = 0;
        for (int i = 3; i<=n; i++ ){
            sum = dp[1] + dp[2];
            dp[1] = dp[2];
            dp[2] = sum;
        }
        return sum;

    }
}
